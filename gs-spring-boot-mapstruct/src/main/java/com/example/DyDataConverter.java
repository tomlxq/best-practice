package com.example;


import com.example.domain.DyGoodsRecordImportVo;
import com.example.domain.DyRoomGoodsRecord;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 自定义转换接口
 *
 * @author TomLuo
 * @date 2023年06月04日 20:47
 */
public class DyDataConverter {
    private static final TemplateConvert CONVERT = Mappers.getMapper(TemplateConvert.class);

    /**
     * 转换List对象
     **/
    public static List<DyRoomGoodsRecord> convertFromVoList(List<DyGoodsRecordImportVo> data) {
        return CONVERT.convert(data);
    }

    /**
     * 转换单个对象
     **/
    public static DyRoomGoodsRecord convertFromVo(DyGoodsRecordImportVo data) {
        return CONVERT.convert(data);
    }


}