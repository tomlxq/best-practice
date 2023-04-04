package org.springframework.web.servlet;


import com.guide.controller.HelloController;
import org.springframework.web.annotation.Controller;
import org.springframework.web.annotation.RequestMapping;
import org.springframework.web.annotation.RequestParam;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * DispatcherServlet
 *
 * @author TomLuo
 * @date 2019/9/22
 */
public class DispatcherServlet extends HttpServlet {
    private List<HandlerMapping> handlerMappings = new ArrayList<>();

    private List<ViewResolver> viewResolvers = new ArrayList<>();
    //  Map<HandlerExecutionChain, HandlerAdapter> mapHandlerAdapter = new ConcurrentHashMap<HandlerExecutionChain, HandlerAdapter>();
    private List<HandlerAdapter> handlerAdapters = new ArrayList<>();
    ;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispatch(req, resp);
        System.out.println("spring mvc service");
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HandlerExecutionChain mappedHandler = null;
        ModelAndView mv = null;
        mappedHandler = getHandler(req);
        if (mappedHandler == null) {
            resp.getWriter().write("404 not found");
            return;
        }
        // Determine handler adapter for the current request.
        HandlerAdapter ha = getHandlerAdapter(mappedHandler.getHandler());

        mv = ha.handle(req, resp, mappedHandler.getHandler());
        applyDefaultViewName(mv, resp);
    }

    private void applyDefaultViewName(ModelAndView mv, HttpServletResponse resp) throws IOException {
        if (null == mv) {
            resp.getWriter().write("Not velocity view");
            return;
        }
        if (this.viewResolvers.isEmpty()) {
            resp.getWriter().write("no view resolvers");
            return;
        }

        List<ViewResolver> collect = this.viewResolvers.stream().filter(v -> !mv.getViewName().equals(v.getViewName())).collect(Collectors.toList());
        if (collect.isEmpty()) {
            resp.getWriter().write("no template file");
            return;
        }
        ViewResolver viewResolver = collect.get(0);
        String parse = viewResolver.parse(mv);
        resp.getWriter().write(parse);
    }

    private HandlerAdapter getHandlerAdapter(HandlerExecutionChain handler) {
        if (handlerAdapters.isEmpty()) {
            return null;
        }
        for (HandlerAdapter handlerAdapter : handlerAdapters) {
            if (handlerAdapter.getHandler().getHandler() == handler) {
                return handlerAdapter;
            }
        }
        return null;
    }

    /**
     * 循环handlerMappings，取出Handler
     *
     * @param req
     * @return
     */
    private HandlerExecutionChain getHandler(HttpServletRequest req) {
        if (handlerMappings.isEmpty()) {
            return null;
        }

        String url = req.getRequestURI().replace(req.getContextPath(), "").replaceAll("/+", "/");
        for (HandlerMapping handlerMapping : handlerMappings) {
            Matcher matcher = handlerMapping.getPattern().matcher(url);
            if (!matcher.find()) {
                continue;
            }
            return handlerMapping.getHandler();
        }
        return null;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("spring mvc init");
        ApplicationContext context = new ApplicationContext(config.getInitParameter("contextConfigLocation"));
        //HelloController helloController = (HelloController) context.getBean("helloController");
        initMultipartResolver(context);
        initLocaleResolver(context);
        initThemeResolver(context);
        initHandlerMappings(context);
        System.out.println(this.handlerMappings);
        initHandlerAdapters(context);
        initHandlerExceptionResolvers(context);
        initRequestToViewNameTranslator(context);
        initViewResolvers(context);
        initFlashMapManager(context);
    }

    private void initFlashMapManager(ApplicationContext context) {

    }

    /**
     * 模板一般不会放在WebRoot下的,而是放在WEB-INFO或是class下,这样不会被用户直接请求到
     *
     * @param context
     */
    private void initViewResolvers(ApplicationContext context) {
        String path = this.getClass().getResource("/").getPath();
        ;
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(new File(path + context.getTemplatePath().replaceAll("classpath:", ""))));
            String templatePath = path + prop.getProperty("webapp.resource.loader.path");
            Arrays.stream(new File(templatePath).listFiles()).forEach(f -> {
                System.out.println(f.getPath());
                viewResolvers.add(new ViewResolver(f.getName(), f));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(context.getTemplatePath());
        System.out.println(path);
    }

    private void initRequestToViewNameTranslator(ApplicationContext context) {

    }

    private void initHandlerExceptionResolvers(ApplicationContext context) {

    }

    private void initHandlerAdapters(ApplicationContext context) {
        if (handlerMappings.isEmpty()) {
            return;
        }
        handlerMappings.forEach(handler -> {
            Class<?>[] parameterTypes = handler.getHandler().getMethod().getParameterTypes();
            Map<String, Integer> paramTypes = new HashMap<>();
            for (int idx = 0; idx < parameterTypes.length; idx++) {
                Class<?> parameterType = parameterTypes[idx];
                if (parameterType == HttpServletRequest.class || parameterType == HttpServletResponse.class) {
                    paramTypes.put(parameterType.getName(), idx);
                }
            }
            Annotation[][] parameterAnnotations = handler.getHandler().getMethod().getParameterAnnotations();
            for (int idx = 0; idx < parameterAnnotations.length; idx++) {
                Annotation[] parameterAnnotation = parameterAnnotations[idx];
                for (Annotation annotation : parameterAnnotation) {
                    if (annotation instanceof RequestParam) {
                        String paramName = ((RequestParam) annotation).value();
                        if (!"".equals(paramName)) {
                            paramTypes.put(paramName, idx++);
                        }
                    }
                }
            }
            handlerAdapters.add(new HandlerAdapter(paramTypes, handler));

        });
    }

    /**
     * 处理URL与Method的关系
     * 找出有@Controller注解的类
     * 在有@Controller的方法中找出有@RequestMapping方法的类
     *
     * @param context
     */
    private void initHandlerMappings(ApplicationContext context) {
        Map<String, Object> all = context.getAll();
        if (all.isEmpty()) {
            return;
        }
        all.forEach((name, bean) -> {
            if (!bean.getClass().isAnnotationPresent(Controller.class)) {
                return;
            }
            //处理在类上注解的ＵＲＬ地址
            String url = "";
            if (bean.getClass().isAnnotationPresent(RequestMapping.class)) {
                RequestMapping annotation = bean.getClass().getAnnotation(RequestMapping.class);
                url = annotation.value();
            }
            Method[] methods = bean.getClass().getMethods();
            String finalUrl = url;
            Arrays.stream(methods).forEach(method -> {
                if (!method.isAnnotationPresent(RequestMapping.class)) {
                    return;
                }
                RequestMapping annotation = method.getAnnotation(RequestMapping.class);
                String tempURL = finalUrl + annotation.value();
                Pattern pattern = Pattern.compile(tempURL.replaceAll("/+", "/"));
                handlerMappings.add(new HandlerMapping(new HandlerExecutionChain(bean, method), pattern));
            });
        });
    }

    private void initThemeResolver(ApplicationContext context) {

    }

    private void initLocaleResolver(ApplicationContext context) {
    }

    private void initMultipartResolver(ApplicationContext context) {
    }
}
