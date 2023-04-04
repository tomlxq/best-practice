package com.example.goodcontroller;

import org.springframework.stereotype.Service;

/**
 * TestService
 *
 * @author TomLuo
 * @date 2023年03月24日 6:22
 */
@Service
public class TestService {

    public Double service(TestDTO testDTO) throws Exception {
        if (testDTO.getNum() <= 0) {
            throw new Exception("输入的数字需要大于0");
        }
        if (testDTO.getType().equals("square")) {
            return Math.pow(testDTO.getNum(), 2);
        }
        if (testDTO.getType().equals("factorial")) {
            double result = 1;
            int num = testDTO.getNum();
            while (num > 1) {
                result = result * num;
                num -= 1;
            }
            return result;
        }
        throw new Exception("未识别的算法");
    }
}