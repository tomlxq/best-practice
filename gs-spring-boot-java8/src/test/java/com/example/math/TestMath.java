package com.example.math;

import com.example.lib.ArithmeticUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * TestMath
 *
 * @author TomLuo
 * @date 2023年03月21日 23:54
 */
@Slf4j
public class TestMath {
    /**
     * 1）参数类型为double的构造方法的结果有一定的不可预知性。
     * 有人可能认为在Java中写入newBigDecimal(0.1)所创建的BigDecimal正好等于 0.1（非标度值 1，其标度为 1），
     * 但是它实际上等于0.1000000000000000055511151231257827021181583404541015625。
     * 这是因为0.1无法准确地表示为 double（或者说对于该情况，不能表示为任何有限长度的二进制小数）。
     * 这样，传入到构造方法的值不会正好等于 0.1（虽然表面上等于该值）
     * <p>
     * 2）String 构造方法是完全可预知的：写入 newBigDecimal(“0.1”) 将创建一个 BigDecimal，它正好等于预期的 0.1。
     * 因此，比较而言， 通常建议优先使用String构造方法
     * <p>
     * 3）当double必须用作BigDecimal的源时，请注意，此构造方法提供了一个准确转换；
     * 它不提供与以下操作相同的结果：先使用Double.toString(double)方法，
     * 然后使用BigDecimal(String)构造方法，将double转换为String。
     * 要获取该结果，请使用static valueOf(double)方法
     */
    @Test
    void name() {

        BigDecimal a = new BigDecimal(0.1);
        log.info("a values is:" + a);
        log.info("=====================");
        BigDecimal b = new BigDecimal("0.1");
        log.info("b values is:" + b);

        BigDecimal c = new BigDecimal(Double.toString(0.1));
        log.info("c values is:" + c);
    }

    /**
     * BigDecimal大小比较
     * java中对BigDecimal比较大小一般用的是bigdemical的compareTo方法
     * <p>
     * int a = bigdemical.compareTo(bigdemical2)
     * 返回结果分析：
     * <p>
     * a = -1,表示bigdemical小于bigdemical2；
     * a = 0,表示bigdemical等于bigdemical2；
     * a = 1,表示bigdemical大于bigdemical2；
     * 举例：a大于等于b
     * <p>
     * new bigdemica(a).compareTo(new bigdemical(b)) >= 0
     */
    @Test
    void name2() {
        BigDecimal bigDecimal1 = new BigDecimal(Double.toString(0.1));
        BigDecimal bigDecimal2 = new BigDecimal(Double.toString(0.1));
        int a = bigDecimal1.compareTo(bigDecimal2);
        if (a == -1) {
            log.info("表示bigDecimal1小于bigDecimal2");
        }
        if (a == 0) {
            log.info("表示bigDecimal1等于bigDecimal2");
        }
        if (a == 1) {
            log.info("表示bigDecimal1大于bigDecimal2");
        }
    }

    /**
     * 由于NumberFormat类的format()方法可以使用BigDecimal对象作为其参数，可以利用BigDecimal对超出16位有效数字的货币值，百分值，
     * 以及一般数值进行格式化控制。
     * <p>
     * 以利用BigDecimal对货币和百分比格式化为例。首先，创建BigDecimal对象，进行BigDecimal的算术运算后，分
     * 别建立对货币和百分比格式化的引用，最后利用BigDecimal对象作为format()方法的参数，输出其格式化的货币值和百分比。
     */
    @Test
    void name3() {
        NumberFormat currency = NumberFormat.getCurrencyInstance(); //建立货币格式化引用
        NumberFormat percent = NumberFormat.getPercentInstance();  //建立百分比格式化引用
        percent.setMaximumFractionDigits(3); //百分比小数点最多3位

        BigDecimal loanAmount = new BigDecimal("15000.48"); //贷款金额
        BigDecimal interestRate = new BigDecimal("0.008"); //利率
        BigDecimal interest = loanAmount.multiply(interestRate); //相乘

        log.info("贷款金额:\t" + currency.format(loanAmount));
        log.info("利率:\t" + percent.format(interestRate));
        log.info("利息:\t" + currency.format(interest));
    }

    @Test
    void name4() {
        log.info(formatToNumber(new BigDecimal("3.435")));
        log.info(formatToNumber(new BigDecimal(0)));
        log.info(formatToNumber(new BigDecimal("0.00")));
        log.info(formatToNumber(new BigDecimal("0.001")));
        log.info(formatToNumber(new BigDecimal("0.006")));
        log.info(formatToNumber(new BigDecimal("0.206")));
    }

    @Test
    void name5() {
        assertThrows(ArithmeticException.class, () -> BigDecimal.valueOf(10).divide(BigDecimal.valueOf(3)));
        assertEquals(ArithmeticUtils.div(10, 3, 2), 3.33d);
    }

    /**
     * @param obj传入的小数
     * @return
     * @desc 1.0~1之间的BigDecimal小数，格式化后失去前面的0,则前面直接加上0。
     * 2.传入的参数等于0，则直接返回字符串"0.00"
     * 3.大于1的小数，直接格式化返回字符串
     */
    public static String formatToNumber(BigDecimal obj) {
        DecimalFormat df = new DecimalFormat("#.00");
        if (obj.compareTo(BigDecimal.ZERO) == 0) {
            return "0.00";
        } else if (obj.compareTo(BigDecimal.ZERO) > 0 && obj.compareTo(new BigDecimal(1)) < 0) {
            return "0" + df.format(obj).toString();
        } else {
            return df.format(obj).toString();
        }
    }
}