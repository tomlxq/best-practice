package com.example.principle.lkp;

import java.util.List;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/10
 */
public class GroupLeader {
    private List<Girl> listGirls;

    //传递全班的女生进来
    public GroupLeader(List<Girl> _listGirls) {
        this.listGirls = _listGirls;
    }

    //清查女生数量
    public void countGirls() {
        System.out.println("女生数量是：" + this.listGirls.size());
    }
}