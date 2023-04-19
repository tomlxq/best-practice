package tool;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 在分布式环境中，唯一 ID 生成应用十分广泛，生成方法也多种多样，Hutool 针对一些常用生成策略做了简单封装。
 *
 * Hutool 提供的唯一 ID 生成器的工具类，涵盖了：
 *
 * UUID
 * ObjectId（MongoDB）
 * Snowflake（Twitter）
 * 拿 UUID 举例！
 *
 * Hutool 重写java.util.UUID的逻辑，对应类为cn.hutool.core.lang.UUID，使生成不带-的 UUID 字符串不再需要做字符替换，性能提升一倍左右。
 *
 * @author TomLuo
 * @date 2023年04月17日 6:30
 */
@Slf4j
public class IDTest {
    private final long workerId = 0;
    private final long datacenterId = 1;

    @Test
    void name() {

//生成的UUID是带-的字符串，类似于：a5c8a5e8-df2b-4706-bea4-08d0939410e3
        String uuid = IdUtil.randomUUID();
        log.info("uuid: " + uuid);
//生成的是不带-的字符串，类似于：b17f24ff026d40949c85a24f4f375d42
        String simpleUUID = IdUtil.simpleUUID();
        log.info("simpleUUID: " + simpleUUID);
        Snowflake snowflake = IdUtil.getSnowflake(workerId, datacenterId);

        log.info("snowflake nextId: " + snowflake.nextId());

    }
}