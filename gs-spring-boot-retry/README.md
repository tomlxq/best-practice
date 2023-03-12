spring系列的spring-retry是另一个实用程序模块，可以帮助我们以标准方式处理任何特定操作的重试。在spring-retry中，所有配置都是基于简单注释的。

注解中几个参数的含义：

* value：抛出指定异常才会重试
* include：和value一样，默认为空，当exclude也为空时，默认所有异常
* exclude：指定不处理的异常
* maxAttempts：最大重试次数，默认3次
* backoff：重试等待策略，默认使用@Backoff，@Backoff的value默认为1000L，我们设置为2000L；multiplier（指定延迟倍数）默认为0，表示固定暂停1秒后进行重试，如果把multiplier设置为1.5，则第一次重试为2秒，第二次为3秒，第三次为4.5秒。

当重试耗尽时还是失败，会出现什么情况呢？

当重试耗尽时，RetryOperations可以将控制传递给另一个回调，即RecoveryCallback。Spring-Retry还提供了@Recover注解，用于@Retryable重试失败后处理方法。如果不需要回调方法，可以直接不写回调方法，那么实现的效果是，重试次数完了后，如果还是没成功没符合业务判断，就抛出异常。