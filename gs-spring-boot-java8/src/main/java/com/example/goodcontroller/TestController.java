package com.example.goodcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * 参数校验
 * Java API 的规范 JSR303 定义了校验的标准 validation-api ，其中一个比较出名的实现是 hibernate validation。
 * <p>
 * spring validation 是对其的二次封装，常用于 SpringMVC 的参数自动校验，参数校验的代码就不需要再与业务逻辑代码进行耦合了。
 * ①@PathVariable 和 @RequestParam 参数校验
 * Get 请求的参数接收一般依赖这两个注解，但是处于 url 有长度限制和代码的可维护性，超过 5 个参数尽量用实体来传参。
 * 对 @PathVariable 和 @RequestParam 参数进行校验需要在入参声明约束的注解。
 * 如果校验失败，会抛出 MethodArgumentNotValidException 异常。
 * 校验原理
 * 在 SpringMVC 中，有一个类是 RequestResponseBodyMethodProcessor，这个类有两个作用（实际上可以从名字上得到一点启发）
 * 用于解析 @RequestBody 标注的参数
 * 处理 @ResponseBody 标注方法的返回值
 * 解析 @RequestBoyd 标注参数的方法是 resolveArgument。
 *
 * ②@RequestBody 参数校验
 * Post、Put 请求的参数推荐使用 @RequestBody 请求体参数。
 * 对 @RequestBody 参数进行校验需要在 DTO 对象中加入校验条件后，再搭配 @Validated 即可完成自动校验。
 * 如果校验失败，会抛出 ConstraintViolationException 异常。
 * 校验原理
 * 声明约束的方式，注解加到了参数上面，可以比较容易猜测到是使用了 AOP 对方法进行增强。
 * 而实际上 Spring 也是通过 MethodValidationPostProcessor 动态注册 AOP 切面，然后使用 MethodValidationInterceptor 对切点方法进行织入增强。
 *
 * @author TomLuo
 * @date 2023年03月24日 6:21
 */
@RestController(value = "prettyTestController")
@RequestMapping("/pretty")
public class TestController {

    private TestService testService;

    @GetMapping("/{num}")
    public Integer detail(@PathVariable("num") @Min(1) @Max(20) Integer num) {
        return num * num;
    }

    @GetMapping("/getByEmail")
    public TestDTO getByAccount(@RequestParam @NotBlank @Email String email) {
        TestDTO testDTO = new TestDTO();
        testDTO.setEmail(email);
        return testDTO;
    }

    @Autowired
    public void setTestService(TestService prettyTestService) {
        this.testService = prettyTestService;
    }
}