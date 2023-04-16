package com.example.demo.commander;

import java.util.Arrays;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/18
 */
public class CommanderTest {
    public static void main(String[] args) {
        Light kitchenLight = new Light("厨房的灯");
        Commander kitchenLightOnCommander = new LightOnCommand(kitchenLight);
        Commander kitchenLightOffCommander = new LightOffCommand(kitchenLight);
        Light LivingRoomLight = new Light("客厅的灯");
        Commander LivingRoomLightOnCommander = new LightOnCommand(LivingRoomLight);
        Commander LivingRoomLightOffCommander = new LightOffCommand(LivingRoomLight);
        Stereo stereo=new Stereo();
        Commander stereoOnCommand = new StereoOnCommand(stereo);
        Commander stereoOffCommand = new StereoOffCommand(stereo);
        Commander stereoIncreaseCommand = new StereoIncreaseCommand(stereo);
        Commander stereoDecreaseCommand = new StereoDecreaseCommand(stereo);
        Commander lightOnCommander = new GroupCommander(Arrays.asList(kitchenLightOnCommander,LivingRoomLightOnCommander,stereoOnCommand));
        Commander lightOffCommander = new GroupCommander(Arrays.asList(kitchenLightOffCommander,LivingRoomLightOffCommander,stereoOffCommand));
        Controller controller = new Controller();
        controller.setCommander(0,kitchenLightOnCommander,kitchenLightOffCommander);
        controller.setCommander(1,LivingRoomLightOnCommander,LivingRoomLightOffCommander);
        controller.setCommander(2,stereoOnCommand,stereoOffCommand);
        controller.setCommander(3,stereoIncreaseCommand,stereoDecreaseCommand);
        controller.setCommander(4,lightOnCommander,lightOffCommander);
        controller.onButton(0);
        controller.offButton(0);
        controller.onButton(1);
        controller.offButton(1);
        controller.onButton(2);
        controller.offButton(2);
        controller.onButton(3);
        controller.offButton(3);
        controller.undo();
        controller.undo();
        System.out.println("组合命令：");
        controller.onButton(4);
        controller.undo();
    }
}
