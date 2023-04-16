package com.example.principle.lkp.software;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/10
 */
public class Client {
    public static void main(String[] args) {
        InstallSoftware invoker = new InstallSoftware();
        invoker.installWizard(new Wizard());
    }
}
