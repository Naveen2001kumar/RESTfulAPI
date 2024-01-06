package com.naveen.crud.Exception;

import lombok.Data;

import java.util.Date;

@Data
public class Error {
    private Integer statusCode;
    private String message;
    private Date timestap;
}
