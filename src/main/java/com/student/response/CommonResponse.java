package com.student.response;

import com.student.enumeration.ResponseStatus;

public class CommonResponse {
    private ResponseStatus status;
    private String errorMessage;
    private String successMessage;
    private Object data;
    private int code;
}
