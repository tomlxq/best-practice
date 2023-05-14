package com.tom.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * FirstTransactionService
 *
 * @author TomLuo
 * @date 2023年05月14日 9:00
 */
public interface FirstTransactionService {
   // @Transactional(rollbackFor = Exception.class)
    void transaction1();

    @Transactional(rollbackFor = Exception.class)
    void transactionInnerNested();
}
