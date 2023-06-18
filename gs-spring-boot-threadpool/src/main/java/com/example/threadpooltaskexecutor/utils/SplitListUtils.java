package com.example.threadpooltaskexecutor.utils;



import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * 拆分工具类
 *  * 1、获取需要进行批量更新的大集合A，对大集合进行拆分操作，分成N个小集合A-1 ~ A-N;
 *  * 2、开启线程池，针对集合的大小进行调参，对小集合进行批量更新操作;
 *  * 3、对流程进行控制，控制线程执行顺序。按照指定大小拆分集合的工具类
 *
 * @author TomLuo
 * @date 2023年06月18日 5:32
 */
@Slf4j
public class SplitListUtils {
    /**
     * 功能描述:拆分集合
     * @param <T> 泛型对象
     * @MethodName: split
     * @MethodParam: [resList:需要拆分的集合, subListLength:每个子集合的元素个数]
     * @Return: java.util.List<java.util.List<T>>:返回拆分后的各个集合组成的列表
     * 代码里面用到了guava和common的结合工具类
     */
    public static <T> List<List<T>> split(List<T> resList, int subListLength) {
        if (CollectionUtils.isEmpty(resList) || subListLength <= 0) {
            return Lists.newArrayList();
        }
        List<List<T>> ret = Lists.newArrayList();
        int size = resList.size();
        if (size <= subListLength) {
            // 数据量不足 subListLength 指定的大小
            ret.add(resList);
        } else {
            int pre = size / subListLength;
            int last = size % subListLength;
            // 前面pre个集合，每个大小都是 subListLength 个元素
            for (int i = 0; i < pre; i++) {
                List<T> itemList = Lists.newArrayList();
                for (int j = 0; j < subListLength; j++) {
                    itemList.add(resList.get(i * subListLength + j));
                }
                ret.add(itemList);
            }
            // last的进行处理
            if (last > 0) {
                List<T> itemList = Lists.newArrayList();
                for (int i = 0; i < last; i++) {
                    itemList.add(resList.get(pre * subListLength + i));
                }
                ret.add(itemList);
            }
        }
        return ret;
    }

    /**
     * 功能描述:方法二：集合切割类，就是把一个大集合切割成多个指定条数的小集合，方便往数据库插入数据
     * 推荐使用
     * @MethodName: pagingList
     * @MethodParam:[resList:需要拆分的集合, subListLength:每个子集合的元素个数]
     * @Return: java.util.List<java.util.List<T>>：返回拆分后的各个集合组成的列表
     */
    public static <T> List<List<T>> pagingList(List<T> resList, int pageSize){
        //判断是否为空
        if (CollectionUtils.isEmpty(resList) || pageSize <= 0) {
            return Lists.newArrayList();
        }
        int length = resList.size();
        int num = (length+pageSize-1)/pageSize;
        List<List<T>> newList =  new ArrayList<>();
        for(int i=0;i<num;i++){
            int fromIndex = i*pageSize;
            int toIndex = (i+1)*pageSize<length?(i+1)*pageSize:length;
            newList.add(resList.subList(fromIndex,toIndex));
        }
        return newList;
    }



}

