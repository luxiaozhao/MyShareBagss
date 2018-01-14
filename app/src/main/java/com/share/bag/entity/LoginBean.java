package com.share.bag.entity;

/**
 * Created by Administrator on 2017/12/23.
 */

public class LoginBean {

    /**
     * status : 0
     * info : 输入有误
     */

    private String status;
    private String info;
    /**
     * msg : {"id":"13","username":"15210493698","password":"25f9e794323b453885f5181f1b624d0b","gender":null,"iconurl":null,"name":null}
     */

    private MsgBean msg;

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

    public MsgBean getMsg() {
        return msg;
    }

    public void setMsg(MsgBean msg) {
        this.msg = msg;
    }


    public static class MsgBean {
        /**
         * id : 13
         * username : 15210493698
         * password : 25f9e794323b453885f5181f1b624d0b
         * gender : null
         * iconurl : null
         * name : null
         */

        private String id;
        private String username;
        private String password;
        private Object gender;
        private Object iconurl;
        private Object name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Object getGender() {
            return gender;
        }

        public void setGender(Object gender) {
            this.gender = gender;
        }

        public Object getIconurl() {
            return iconurl;
        }

        public void setIconurl(Object iconurl) {
            this.iconurl = iconurl;
        }

        public Object getName() {
            return name;
        }

        public void setName(Object name) {
            this.name = name;
        }
    }


}
