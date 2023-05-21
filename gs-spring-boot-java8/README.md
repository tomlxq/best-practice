# 异步的八种实现方式
* 线程Thread
* Future
* 异步框架CompletableFuture
* Spring注解@Async
* Spring ApplicationEvent事件
* 消息队列
* 第三方异步框架，比如Hutool的ThreadUtil
* Guava异步


# 查看存活的类
* Twitter的分布式自增ID算法，Snowflake
* 最初Twitter把存储系统从MySQL迁移到Cassandra（由Facebook开发一套开源分布式NoSQL数据库系统）因为Cassandra没有顺序ID生成机制，所有开发了这样一套全局唯一ID生成服务。
* Twitter的分布式雪花算法SnowFlake，经测试SnowFlake每秒可以产生26万个自增可排序的ID
* twitter的SnowFlake生成ID能够按照时间有序生成
* SnowFlake算法生成ID的结果是一个64Bit大小的整数，为一个Long型（转换成字符串后长度最多19）
* 分布式系统内不会产生ID碰撞（由datacenter 和 workerID做区分）并且效率较高
* 分布式系统中，有一些需要全局唯一ID的场景，生成ID的基本要求

0 0000000000 0000000000 0000000000 0000000000 0 0000000000 0000000000 00

1bit 时间戳位

12bit 序列号位

1bit 符号位

10bit工作进程位

时间范围：2^41／（365＊24＊60＊60＊1000L）＝69.73年

工作进程数量：2^10=1024

生成不碰撞序列的TPS：2^12＊1000＝409.6万

第一部分
二进制中最高位是符号位，1表示负数，0表示正数。生成的ID一般都是用整数，所以最高位固定为0。

第二部分
第二部分是41bit时间戳位，用来记录时间戳，毫秒级

41位可以表示 2^41 -1 个数字

如果只用来表示正整数，可以表示的范围是：0 - 2^41 -1，减1是因为可以表示的数值范围是从0开始计算的，而不是从1。

也就是说41位可以表示 2^41 - 1 毫秒的值，转换成单位年则是 69.73年

第三部分
第三部分为工作机器ID，10Bit用来记录工作机器ID

可以部署在2^10 = 1024个节点，包括5位 datacenterId（数据中心，机房） 和 5位 workerID（机器码）

5位可以表示的最大正整数是 2 ^ 5 = 31个数字，来表示不同的数据中心 和 机器码

第四部分
12位bit可以用来表示的正整数是 2^12 = 4095，即可以用0 1 2 … 4094 来表示同一个机器同一个时间戳内产生的4095个ID序号。

SnowFlake可以保证
所有生成的ID按时间趋势递增

整个分布式系统内不会产生重复ID，因为有datacenterId 和 workerId来做区分

为了解决时钟回拨问题，导致ID重复，后面有人专门提出了解决的方案：
百度开源的分布式唯一ID生成器 UidGenerator
https://gitee.com/baidu/uid-generator#uidgenerator
Leaf - 美团点评分布式ID生成系统
https://github.com/Meituan-Dianping/Leaf