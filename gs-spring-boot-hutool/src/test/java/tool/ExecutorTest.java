package tool;

import cn.hutool.core.thread.ExecutorBuilder;
import cn.hutool.core.thread.ThreadFactoryBuilder;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.dfa.SensitiveUtil;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 线程池
 * Hutool 支持使用建造者的模式创建自定义线程池
 *
 * @author TomLuo
 * @date 2023年04月18日 6:22
 */
public class ExecutorTest {
    private static ExecutorService pool = ExecutorBuilder.create()
            .setCorePoolSize(10)//初始池大小
            .setMaxPoolSize(20) //最大池大小
            .setWorkQueue(new LinkedBlockingQueue<>(100))//最大等待数为100
            .setThreadFactory(ThreadFactoryBuilder.create().setNamePrefix("IM-Pool-").build())// 线程池命名
            .build();

    /**
     * 实际项目中，如果一个对象的属性比较多，有限考虑使用建造者模式创建对象。
     *
     * 并且，Hutool 还提供一个全局的线程池，默认所有异步方法在这个线程池中执行。
     *
     * ThreadUtil.execute : 直接在公共线程池中执行线程
     * ThreadUtil.execAsync: 执行异步方法
     * ......
     * Hutool 自身就大量用到了 ThreadUtil，比如敏感词工具类 SensitiveUtil
     * @param sensitiveWords
     * @param isAsync
     */
    //SensitiveUtil.init();

   /* public static void init(final Collection<String> sensitiveWords, boolean isAsync){
        if(isAsync){
            // 异步初始化敏感词树
            ThreadUtil.execAsync(new Callable<Boolean>(){
                @Override
                public Boolean call() throws Exception {
                    init(sensitiveWords);
                    return true;
                }

            });
        }else{
            // 同步初始化敏感词树
            init(sensitiveWords);
        }
    }*/
}