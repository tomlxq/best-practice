package tool;

import cn.hutool.core.convert.Convert;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 类型转换
 * Convert 类封装了针对 Java 常见类型的转换。
 *
 * @author TomLuo
 * @date 2023年04月17日 6:20
 */
@Slf4j
class ConvertDemoTest {


    @Test
    void name() {
        long[] b = {1, 2, 3, 4, 5};
        String bStr = Convert.toStr(b);//"[1, 2, 3, 4, 5]"
        log.info("{}", bStr);

        double a = 67556.32;
        String digitUppercase = Convert.digitToChinese(a);//"陆万柒仟伍佰伍拾陆元叁角贰分"
        log.info("{}", digitUppercase);
    }


}