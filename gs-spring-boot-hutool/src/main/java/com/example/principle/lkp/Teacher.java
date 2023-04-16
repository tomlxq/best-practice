package com.example.principle.lkp;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/10
 */
public class Teacher {
    //老师对学生发布命令，清一下女生
    public void commond(GroupLeader groupLeader) {
//告诉体育委员开始执行清查任务
        groupLeader.countGirls();
    }
}