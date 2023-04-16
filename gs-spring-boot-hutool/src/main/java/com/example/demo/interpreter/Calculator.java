package com.example.demo.interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/6
 */
public class Calculator {
    public Calculator() {
        float[][] dataSource = new float[3][6];
        System.out.println("data source:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                dataSource[i][j] = (float) (Math.random() * 100);
                System.out.print(dataSource[i][j] + ",");
            }
            System.out.println(";");
        }

        try {
            System.out.println("Input a expression:");
            BufferedReader is = new BufferedReader(new InputStreamReader(
                    System.in));
            for (; ; ) {
                String input = new String();
                input = is.readLine().trim();
                if (input.equals("q"))
                    break;
                else {
                    RPN boya = new RPN(input);
                    HashMap<String, Float> var;
                    for (int i = 0; i < 3; i++) {
                        var = new HashMap<String, Float>();
                        var.put("a", dataSource[i][0]);
                        var.put("b", dataSource[i][1]);
                        var.put("c", dataSource[i][2]);
                        var.put("d", dataSource[i][3]);
                        var.put("e", dataSource[i][4]);
                        var.put("f", dataSource[i][5]);

                        boya.getResult(var);

                    }

                }
                System.out
                        .println("Input another expression or input 'q' to quit:");
            }
            is.close();
        } catch (IOException e) {
            System.out.println("Wrong input!!!");
        }

    }
}
