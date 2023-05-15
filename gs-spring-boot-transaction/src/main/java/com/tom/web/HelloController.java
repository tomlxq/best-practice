package com.tom.web;

import com.tom.service.FirstTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

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


    @GetMapping("/testInnerMethodTx")
    public String testInnerMethodTx() {
        firstTransactionService.createUser();
        return "success";
    }
    @GetMapping("/testUserWithInterfaceTx")
    public String testUserWithInterfaceTx() {
        firstTransactionService.createUserWithInterface();
        return "success";
    }
    @GetMapping("/testUserWithAopProxyTx")
    public String testUserWithAopProxyTx() {
        firstTransactionService.createUserWithAopProxy();
        return "success";
    }
    @GetMapping("/testUserWithCheckExceptionTx")
    public String testUserWithCheckExceptionTx() throws IOException {
        firstTransactionService.createUserWithCheckException();
        return "success";
    }
    @GetMapping("/testUserWithRuntimeExceptionTx")
    public String testUserWithRuntimeExceptionTx() {
        firstTransactionService.createUserWithRuntimeException();
        return "success";
    }
    @GetMapping("/testUserWithUncheckExceptionTx")
    public String testUserWithUncheckExceptionTx() throws IOException {
        firstTransactionService.createUserWithUncheckException();
        return "success";
    }
    @GetMapping("/testUserWithTryCatchTx")
    public String testUserWithTryCatchTx() {
        firstTransactionService.createUserWithTryCatch();
        return "success";
    }
}