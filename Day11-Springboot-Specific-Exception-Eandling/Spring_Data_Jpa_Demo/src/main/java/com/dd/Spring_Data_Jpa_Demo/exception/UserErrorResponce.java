package com.dd.Spring_Data_Jpa_Demo.exception;

//Step 01 Custom error class
public class UserErrorResponce {
    private int status;
    private String message;
    private long timeStamp;

    public UserErrorResponce() {
    }

    public UserErrorResponce(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
