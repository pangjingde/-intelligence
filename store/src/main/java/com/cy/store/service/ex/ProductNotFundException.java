package com.cy.store.service.ex;

public class ProductNotFundException extends  ServiceException{

    public ProductNotFundException() {
        super();
    }

    public ProductNotFundException(String message) {
        super(message);
    }

    public ProductNotFundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductNotFundException(Throwable cause) {
        super(cause);
    }

    protected ProductNotFundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
