package com.tom.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * SecondTransactionService
 *
 * @author TomLuo
 * @date 2023年05月14日 8:23
 */
public interface SecondTransactionService {
   // @Transactional(rollbackFor = Exception.class)
    void transaction2();

   // @Transactional(rollbackFor = Exception.class,propagation = Propagation.NESTED)
    void transactionNested();
}
