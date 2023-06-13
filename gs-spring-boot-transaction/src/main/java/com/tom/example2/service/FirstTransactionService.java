package com.tom.example2.service;

import java.io.IOException;

/**
 * FirstTransactionService
 *
 * @author TomLuo
 * @date 2023年05月14日 9:00
 */
public interface FirstTransactionService {
    void transaction1();

    void transactionInnerNested();


   void createUser1();

    void createUser();

    void createUserWithUncheckException() throws IOException;

    void createUserWithInterface();
    void createUserWithAopProxy();

    void createUserWithRuntimeException();

    //  @Transactional
    void createUserWithCheckException() throws IOException;

    void createUserWithTryCatch();
}
