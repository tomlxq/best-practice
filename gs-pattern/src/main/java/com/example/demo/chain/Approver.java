package com.example.demo.chain;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/31
 */
public abstract class Approver {
    protected String name;

    public Approver(String name) {
        this.name = name;
    }

    protected Approver successor;

    protected void setApprover(Approver successor) {
        this.successor = successor;
    }

    protected abstract void processRequest(PurchaseRequest purchaseRequest);
}
