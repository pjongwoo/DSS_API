package com.jwhj.dss.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ApiResponseMessage {
    private String status;          //Http상태값
    private String message;         //Http 기본 메세지
    private String errorCode;       //에로코드
    private String errorMessage;    //에러 메세지


    public ApiResponseMessage() {}

    public ApiResponseMessage(String status, String message, String errorCode, String errorMessage){
        this.status = status;
        this.message = message;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;

    }
}
