package com.example.principle.lkp;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/10
 */
public class Client {
    public static void main(String[] args) {
//产生一个女生群体
        List<Girl> listGirls = new ArrayList<Girl>();
//初始化女生
        for (int i = 0; i < 20; i++) {
            listGirls.add(new Girl());
        }
        Teacher teacher = new Teacher();
//老师发布命令
        teacher.commond(new GroupLeader(listGirls));
    }
}
