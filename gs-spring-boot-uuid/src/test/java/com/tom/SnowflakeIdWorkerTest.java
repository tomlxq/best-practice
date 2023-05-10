package com.tom;



/**
 * SnowflakeIdWorkerTest
 *
 * @author TomLuo
 * @date 2023年05月07日 23:09
 */
class SnowflakeIdWorkerTest {
    //=========================================Test=========================================

    /**
     * 测试
     */
    public static void main(String[] args) {
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
        for (int i = 0; i < 1000; i++) {
            long id = idWorker.nextId();
            System.out.println(id);
        }
    }
}