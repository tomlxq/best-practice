package com.example.demo.chain;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/31
 */
public class ApproverTest {
    public static void main(String[] args) {
        Client client = new Client();
        GroupApprover tom = new GroupApprover("tom");
        DepartmentApprover jack = new DepartmentApprover("Jack");
        VicePresentApprover rose = new VicePresentApprover("rose");
        PresentApprover green = new PresentApprover("Green");
        tom.setApprover(jack);
        jack.setApprover(rose);
        rose.setApprover(green);
        green.setApprover(tom);
        tom.processRequest(client.sendRequest("花生", 8, 400));
        tom.processRequest(client.sendRequest("苹果", 10, 800));
        tom.processRequest(client.sendRequest("笔记本电脑", 12000, 1));
        tom.processRequest(client.sendRequest("办公桌", 2000, 12));
    }
}
