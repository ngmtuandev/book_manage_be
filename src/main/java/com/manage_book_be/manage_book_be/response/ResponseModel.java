package com.manage_book_be.manage_book_be.response;

public class ResponseModel {
    private int status;
    private String mess;

    private Object data;

    public ResponseModel(int status, String mess, Object data) {
        this.status = status;
        this.mess = mess;
        this.data = data;
    }
}
