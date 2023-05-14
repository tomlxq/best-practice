package com.tom.web;

import com.tom.service.FirstTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * www
 *
 * @author TomLuo
 * @date 2023年05月14日 9:02
 */
@RestController
@RequiredArgsConstructor
public class HelloController {
private final FirstTransactionService firstTransactionService;
    @GetMapping("/testWithoutNestedTx")
    public String testWithoutNestedTx() {
        firstTransactionService.transaction1();
        return "success";
    }
    @GetMapping("/testNestedTx")
    public String testNestedTx() {
        firstTransactionService.transactionInnerNested();
        return "success";
    }
}