package com.share.bag.entity;

/**
 * Created by Administrator on 2017/12/25.
 */

public class RegisterBean {

    /**
     * status : 0
     * info : 验证码输入有误
     */

    private String status;
    private String info;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
