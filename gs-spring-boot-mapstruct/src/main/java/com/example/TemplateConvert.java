package com.example;


import com.example.domain.DyGoodsRecordImportVo;
import com.example.domain.DyRoomGoodsRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
/**
 * 添加接口，指定使用自定义的转换类 TypeConversion
 *
 * @author TomLuo
 * @date 2023年06月04日 21:21
 */

@Mapper(uses = TypeConversion.class)
public interface TemplateConvert {
    // 转换价格字符串
    @Mapping(target = "salePrice", qualifiedByName = "strToMoney")
    @Mapping(target = "turnoverMoney", qualifiedByName = "strToMoney", defaultValue = "0.00")
    @Mapping(target = "gpmGoodsPay", qualifiedByName = "strToMoney")
    // 转换百分比为数字
    @Mapping(target = "exposeClickerRate", qualifiedByName = TypeConversion.PERCENT_TO_RATE)
    @Mapping(target = "clickerBuyerRate", qualifiedByName = TypeConversion.PERCENT_TO_RATE)
    DyRoomGoodsRecord convert(DyGoodsRecordImportVo model);

    List<DyRoomGoodsRecord> convert(List<DyGoodsRecordImportVo> list);
}