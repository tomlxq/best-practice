package com.example.refactor.functional;

import java.io.IOException;

/**
 *     函数式接口实现
 * 向接口 FtpProvider 添加一个新方法，需要我们仅在一个地方进行更改。
 * 我们可以轻松地将我们的 FtpProvider 注入到其他服务中。
 * 我们将ftp操作的逻辑封装在一个类中。相对于上面的方式，我们也没有用到AOP的库，所以我个人还是比较推荐的。
 *
 * @author TomLuo
 * @date 2023年05月21日 23:34
 */
@FunctionalInterface
public interface FtpOperation<T, R> {

    R apply(T t) throws IOException;
}