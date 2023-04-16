package com.example.demo.prototype;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/25
 */
public class RobotTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Robot robot = new Robot();
        robot.setAge(18);
        robot.setName("机器人1代");
        Robot clone = robot.clone();
        System.out.println(clone == robot);
        System.out.println(clone.getArrayList() == robot.getArrayList());
    }
}
