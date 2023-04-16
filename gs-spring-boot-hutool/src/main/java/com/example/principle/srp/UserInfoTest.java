package com.example.principle.srp;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/10
 */
public class UserInfoTest {
    public static void main(String[] args) {
        IUserInfo userInfo = new UserInfo();
        //我要赋值了，我就认为它是一个纯粹的BO
        IUserBO userBO = (IUserBO) userInfo;
        userBO.setPassword("abc");
//我要执行动作了，我就认为是一个业务逻辑类
        IUserBiz userBiz = (IUserBiz) userInfo;
        userBiz.deleteUser();
    }
}
