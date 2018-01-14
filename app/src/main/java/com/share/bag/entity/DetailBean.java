package com.share.bag.entity;

/**
 * Created by Administrator on 2017/12/27.
 */

public class DetailBean {


    /**
     * id : 1
     * title : 111111
     * originalprice : 100.00
     * days : 1
     * days_money : 10.00
     * img : /Public/headerimg/1111.png
     * bagtype_id : 1
     * bagsize_id : 1
     * bagbrand_id : 1
     * create_time : null
     * create_user : null
     * update_time : null
     * update_user : null
     */

    private String id;
    private String title;
    private String originalprice;
    private String days;
    private String days_money;
    private String img;
    private String bagtype_id;
    private String bagsize_id;
    private String bagbrand_id;
    private Object create_time;
    private Object create_user;
    private Object update_time;
    private Object update_user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalprice() {
        return originalprice;
    }

    public void setOriginalprice(String originalprice) {
        this.originalprice = originalprice;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getDays_money() {
        return days_money;
    }

    public void setDays_money(String days_money) {
        this.days_money = days_money;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getBagtype_id() {
        return bagtype_id;
    }

    public void setBagtype_id(String bagtype_id) {
        this.bagtype_id = bagtype_id;
    }

    public String getBagsize_id() {
        return bagsize_id;
    }

    public void setBagsize_id(String bagsize_id) {
        this.bagsize_id = bagsize_id;
    }

    public String getBagbrand_id() {
        return bagbrand_id;
    }

    public void setBagbrand_id(String bagbrand_id) {
        this.bagbrand_id = bagbrand_id;
    }

    public Object getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Object create_time) {
        this.create_time = create_time;
    }

    public Object getCreate_user() {
        return create_user;
    }

    public void setCreate_user(Object create_user) {
        this.create_user = create_user;
    }

    public Object getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Object update_time) {
        this.update_time = update_time;
    }

    public Object getUpdate_user() {
        return update_user;
    }

    public void setUpdate_user(Object update_user) {
        this.update_user = update_user;
    }
}
