package com.example;

import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 自定义属性转换方法
 *
 * @author TomLuo
 * @date 2023年06月04日 20:41
 */
@Component
public class TypeConversion {
    public static final String PERCENT_TO_RATE = "percentToRate";

    /** 将带 ￥的字符串转化为指定精度的 BigDecimal **/
    @Named("strToMoney")
    public BigDecimal strToMoney(String str) {
        try {
            BigDecimal result = new BigDecimal(str.replaceAll("¥|,", ""));
            return result.setScale(2, RoundingMode.HALF_UP);
        } catch (NumberFormatException e) {
            throw new ServiceException("金额数据的格式有误，数据为: " + str);
        }
    }

    /** 将带 %的字符串转化为指定精度的 BigDecimal **/
    @Named(PERCENT_TO_RATE)
    public BigDecimal percentToRate(String str) {
        try {
            String replaceStr = str.replace("%", "");
            return new BigDecimal(replaceStr).setScale(2, RoundingMode.HALF_UP);
        } catch (NumberFormatException e) {
            throw new ServiceException("百分比数据的格式有误，数据为: " + str);
        }
    }
}