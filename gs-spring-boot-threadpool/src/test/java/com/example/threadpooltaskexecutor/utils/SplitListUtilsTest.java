package com.example.threadpooltaskexecutor.utils;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @Description: SplitListUtilsTest
 * @Author: TomLuo
 * @CreateDate: 2023年06月18日 10:11
 * @Version: V1.0
 */
@Slf4j
class SplitListUtilsTest {
    @BeforeEach
    void setUp() {

    }

    /**
     * 运行测试代码 可以按顺序拆分为11个集合
     */
    @Test
    void pagingList() {
        //初始化数据
        List<String> list = Lists.newArrayList();
        int size = 19;
        for (int i = 0; i < size; i++) {
            list.add("hello-" + i);
        }
        // 大集合里面包含多个小集合
        List<List<String>> temps = SplitListUtils.pagingList(list, 100);
        int j = 0;
        // 对大集合里面的每一个小集合进行操作
        for (List<String> obj : temps) {
            log.info(String.format("row:%s -> size:%s,data:%s", ++j, obj.size(), obj));
        }

    }
}