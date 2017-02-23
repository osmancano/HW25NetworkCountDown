package com.ironyard.data;

/**
 * Created by osmanidris on 2/23/17.
 */
public class TIYResponse {
    private boolean success;
    private Integer number;

    public TIYResponse(){}
    public TIYResponse(boolean success, Integer number) {
        this.success = success;
        this.number = number;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
