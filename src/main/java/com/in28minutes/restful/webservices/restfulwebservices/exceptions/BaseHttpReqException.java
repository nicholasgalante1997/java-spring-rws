package com.in28minutes.restful.webservices.restfulwebservices.exceptions;

import java.util.Date;

public class BaseHttpReqException {
    private Date timestamp;
    private String errorMessage;
    private String details;

    public BaseHttpReqException(String errorMessage, String details) {
        this.timestamp = new Date();
        this.errorMessage = errorMessage;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
