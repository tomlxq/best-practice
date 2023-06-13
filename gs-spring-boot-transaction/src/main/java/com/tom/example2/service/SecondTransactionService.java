package com.tom.example2.service;

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
