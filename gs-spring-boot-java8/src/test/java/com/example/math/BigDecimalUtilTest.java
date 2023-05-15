package com.example.math;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.NumberFormat;

import static com.example.math.BigDecimalUtil.formatToNumber;
import static java.math.BigDecimal.ROUND_CEILING;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * BigDecimalTest
 *
 * @author TomLuo
 * @date 2023年05月14日 11:49
 */
@Slf4j
public class BigDecimalUtilTest {
    @Test
    void name() {
        BigDecimal a = new BigDecimal(0.1);
        System.out.println("a values is:" + a);
        System.out.println("=====================");
        BigDecimal b = new BigDecimal("0.1");
        System.out.println("b values is:" + b);
    }

    @Test
    void name2() {
        NumberFormat currency = NumberFormat.getCurrencyInstance(); //建立货币格式化引用
        NumberFormat percent = NumberFormat.getPercentInstance();  //建立百分比格式化引用
        percent.setMaximumFractionDigits(3); //百分比小数点最多3位

        BigDecimal loanAmount = new BigDecimal("15000.48"); //贷款金额
        BigDecimal interestRate = new BigDecimal("0.008"); //利率
        BigDecimal interest = loanAmount.multiply(interestRate); //相乘

        System.out.println("贷款金额:\t" + currency.format(loanAmount));
        System.out.println("利率:\t" + percent.format(interestRate));
        System.out.println("利息:\t" + currency.format(interest));
    }

    @Test
    void name3() {
        System.out.println(formatToNumber(new BigDecimal("3.435")));
        System.out.println(formatToNumber(new BigDecimal(0)));
        System.out.println(formatToNumber(new BigDecimal("0.00")));
        System.out.println(formatToNumber(new BigDecimal("0.001")));
        System.out.println(formatToNumber(new BigDecimal("0.006")));
        System.out.println(formatToNumber(new BigDecimal("0.206")));
    }

    @Test
    void name4() {
        BigDecimal loanAmount = new BigDecimal("10");
        BigDecimal loanAmount2 = new BigDecimal("3");
        final String message = assertThrows(ArithmeticException.class, () -> loanAmount.divide(loanAmount2)).getMessage();
        assertThat(message, equalTo("Non-terminating decimal expansion; no exact representable decimal result."));
        log.info(message);
        log.info("{}", loanAmount.divide(loanAmount2, 2, BigDecimal.ROUND_HALF_UP).toPlainString());

    }
}