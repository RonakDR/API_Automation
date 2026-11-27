package com.api.constant;

public enum OEM {
    GOOGLE(1),APPLE(2);

    final int code;
    OEM(int code){
        this.code=code;
    }

    public int getCode(){
        return code;
    }
}
