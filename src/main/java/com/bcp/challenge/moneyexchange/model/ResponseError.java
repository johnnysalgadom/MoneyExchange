package com.bcp.challenge.moneyexchange.model;

import com.bcp.challenge.moneyexchange.model.enums.ErrorType;
import java.util.ArrayList;
import java.util.List;

public class ResponseError {

    public static final String FIELD_REQUIRED_MSG  = "field required";
    public static final String REPEATED_FIELD_MSG  = "field must be unique";
    private List<String> loc = new ArrayList<>();
    private String msg = FIELD_REQUIRED_MSG;
    private ErrorType type = ErrorType.VALUE_MISSING;

    public ResponseError() {}

    public ResponseError(List<String> loc, String msg, ErrorType type) {
        this.loc = loc;
        this.msg = msg;
        this.type = type;
    }

    public List<String> getLoc() {
        return loc;
    }

    public void setLoc(List<String> loc) {
        this.loc = loc;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ErrorType getType() {
        return type;
    }

    public void setType(ErrorType type) {
        this.type = type;
    }
}
