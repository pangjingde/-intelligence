package com.cy.store.until;

import java.io.Serializable;

/**
 * 返回前端的JSON数据
 * @param <E>
 */
public class JsonResult<E> implements Serializable {
    private Integer state;
    private  String message;
    private  E data;

    public JsonResult() {
    }

    public JsonResult(Integer state) {
        this.state = state;
    }
    public JsonResult(Throwable e) {
        this.message= e.getMessage();
    }
    public JsonResult(Integer state, E data) {
        this.state = state;
        this.data = data;
    }
    public JsonResult(Integer state, String message) {
        this.state = state;
        this.message=message;
    }
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
