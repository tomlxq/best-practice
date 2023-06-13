package com.example;

import com.example.domain.DyGoodsRecordImportVo;
import com.example.domain.DyRoomGoodsRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 业务场景，从简单到复杂举例
 * <p>
 * 1. 浅拷贝或深拷贝数据对象，用于产生一个新的对象；
 * <p>
 * 2. 两个对象属性名和类型大部分相同，比如前端DTO转数据层PO；
 * <p>
 * 3. 拷贝时需要忽略一些属性；
 * <p>
 * 4. 不同类型的对象转换，比如Bean 和 Map相互转换；
 * <p>
 * 5. 集合类型拷贝，比如两个List<DTO>之间拷贝和转换；
 * <p>
 * 6. 两个对象之间一些属性名称和类型不同，需要自定义规则，
 * 比如字符串属性“￥8.8787”转换为数字 8.88，
 * 比如字符串 “8.8787%” 转换为数字 8.88
 * <p>
 * 前面4种可以用 BeanUtil.copyProperties，再加点手动设置属性的代码，基本能解决。
 */
@SpringBootApplication
@Slf4j
public class MapstructApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MapstructApplication.class, args);
	}

	public static void drawConvert() {
		TypeConversion typeConversion = new TypeConversion();
		DyGoodsRecordImportVo model = new DyGoodsRecordImportVo();
		DyRoomGoodsRecord dyRoomGoodsRecord = new DyRoomGoodsRecord();
		dyRoomGoodsRecord.setLiveRoomNum(model.getLiveRoomNum());
		dyRoomGoodsRecord.setExplainTimes(model.getExplainTimes());
		dyRoomGoodsRecord.setFirstListingAt(model.getFirstListingAt());

		dyRoomGoodsRecord.setSalePrice(typeConversion.strToMoney(model.getSalePrice()));


		dyRoomGoodsRecord.setTurnoverMoney(typeConversion.strToMoney(model.getTurnoverMoney()));
		dyRoomGoodsRecord.setSoldGoodsCount(model.getSoldGoodsCount());

		dyRoomGoodsRecord.setPresellOrderCount(model.getPresell0rderCount());

		//自定义转换方法
		dyRoomGoodsRecord.setClickerCount(model.getClickerCount());

		dyRoomGoodsRecord.setExposeClickerRate(typeConversion.percentToRate(model.getExposeClickerRate()));


		dyRoomGoodsRecord.setClickerBuyerRate(typeConversion.percentToRate(model.getClickerBuyerRate()));
		dyRoomGoodsRecord.setGpmGoodsPay(typeConversion.strToMoney(model.getGpmGoodsPay()));

		dyRoomGoodsRecord.setPreDeliveryRefundOrderCount(model.getPreDeliveryRefundOrderCount());
		if (model.getPreDeliveryRefundMoney() != null) {

			dyRoomGoodsRecord.setPreDeliveryRefundMoney(new BigDecimal(model.getPreDeliveryRefundMoney()));
		}
	}

	@Override
	public void run(String... args) throws Exception {
		DyGoodsRecordImportVo importVo = new DyGoodsRecordImportVo();
		importVo.setExplainTimes(new Date());
		importVo.setClickerCount(5);
		importVo.setLiveRoomNum(123);
		importVo.setFirstListingAt(new Date());
		importVo.setExposeClickerRate("8.8787%");
		importVo.setClickerBuyerRate("18.8787%");
		importVo.setSalePrice("¥8.8787");
		importVo.setTurnoverMoney("¥8.8787");
		importVo.setGpmGoodsPay("¥8.8787");
		DyRoomGoodsRecord target = DyDataConverter.convertFromVo(importVo);
		log.info("DyGoodsRecord:{}", target);
		List<DyGoodsRecordImportVo> importList = Arrays.asList(importVo);
		List<DyRoomGoodsRecord> list = DyDataConverter.convertFromVoList(importList);
		log.info("list:{}", list);
	}
}
