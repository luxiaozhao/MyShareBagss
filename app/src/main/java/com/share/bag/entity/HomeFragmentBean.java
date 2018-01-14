package com.share.bag.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/12/25.
 */

public class HomeFragmentBean {


    private List<HeaderimgBean> headerimg;
    private List<ListBean> list;

    public List<HeaderimgBean> getHeaderimg() {
        return headerimg;
    }

    public void setHeaderimg(List<HeaderimgBean> headerimg) {
        this.headerimg = headerimg;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class HeaderimgBean {
        /**
         * id : 1
         * title : 11111
         * img : ./Public/headerimg/1111.png
         */

        private String id;
        private String title;
        private String img;

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

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }
    }

    public static class ListBean {
        /**
         * id : 1
         * title : 品牌专区
         * pid : 0
         * bagthinks : [{"id":"1","title":"111111","originalprice":"100.00","days":"1","days_money":"10.00","img":"./Public/headerimg/1111.png"},{"id":"2","title":"22222","originalprice":"200.00","days":"1","days_money":"20.00","img":"./Public/headerimg/1111.png"},{"id":"2","title":"22222","originalprice":"200.00","days":"1","days_money":"20.00","img":"./Public/headerimg/1111.png"}]
         * _child : [{"id":"4","title":"休闲度假","pid":"2","bagthinks":[{"id":"2","title":"22222","originalprice":"200.00","days":"1","days_money":"20.00","img":"./Public/headerimg/1111.png"},{"id":"2","title":"22222","originalprice":"200.00","days":"1","days_money":"20.00","img":"./Public/headerimg/1111.png"},{"id":"2","title":"22222","originalprice":"200.00","days":"1","days_money":"20.00","img":"./Public/headerimg/1111.png"}]},{"id":"5","title":"宴会轻奢","pid":"2","bagthinks":[{"id":"1","title":"111111","originalprice":"100.00","days":"1","days_money":"10.00","img":"./Public/headerimg/1111.png"},{"id":"2","title":"22222","originalprice":"200.00","days":"1","days_money":"20.00","img":"./Public/headerimg/1111.png"},{"id":"1","title":"111111","originalprice":"100.00","days":"1","days_money":"10.00","img":"./Public/headerimg/1111.png"},{"id":"2","title":"22222","originalprice":"200.00","days":"1","days_money":"20.00","img":"./Public/headerimg/1111.png"}]},{"id":"6","title":"商务办公","pid":"2","bagthinks":[{"id":"1","title":"111111","originalprice":"100.00","days":"1","days_money":"10.00","img":"./Public/headerimg/1111.png"},{"id":"1","title":"111111","originalprice":"100.00","days":"1","days_money":"10.00","img":"./Public/headerimg/1111.png"},{"id":"2","title":"22222","originalprice":"200.00","days":"1","days_money":"20.00","img":"./Public/headerimg/1111.png"},{"id":"2","title":"22222","originalprice":"200.00","days":"1","days_money":"20.00","img":"./Public/headerimg/1111.png"}]}]
         */

        private String id;
        private String title;
        private String pid;
        private List<BagthinksBean> bagthinks;
        private List<ChildBean> _child;

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

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public List<BagthinksBean> getBagthinks() {
            return bagthinks;
        }

        public void setBagthinks(List<BagthinksBean> bagthinks) {
            this.bagthinks = bagthinks;
        }

        public List<ChildBean> get_child() {
            return _child;
        }

        public void set_child(List<ChildBean> _child) {
            this._child = _child;
        }

        public static class BagthinksBean {
            /**
             * id : 1
             * title : 111111
             * originalprice : 100.00
             * days : 1
             * days_money : 10.00
             * img : ./Public/headerimg/1111.png
             */

            private String id;
            private String title;
            private String originalprice;
            private String days;
            private String days_money;
            private String img;

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

            @Override
            public String toString() {
                return "BagthinksBean{" +
                        "id='" + id + '\'' +
                        ", title='" + title + '\'' +
                        ", originalprice='" + originalprice + '\'' +
                        ", days='" + days + '\'' +
                        ", days_money='" + days_money + '\'' +
                        ", img='" + img + '\'' +
                        '}';
            }
        }

        public static class ChildBean {
            /**
             * id : 4
             * title : 休闲度假
             * pid : 2
             * bagthinks : [{"id":"2","title":"22222","originalprice":"200.00","days":"1","days_money":"20.00","img":"./Public/headerimg/1111.png"},{"id":"2","title":"22222","originalprice":"200.00","days":"1","days_money":"20.00","img":"./Public/headerimg/1111.png"},{"id":"2","title":"22222","originalprice":"200.00","days":"1","days_money":"20.00","img":"./Public/headerimg/1111.png"}]
             */

            private String id;
            private String title;
            private String pid;
            private List<BagthinksBeanX> bagthinks;

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

            public String getPid() {
                return pid;
            }

            public void setPid(String pid) {
                this.pid = pid;
            }

            public List<BagthinksBeanX> getBagthinks() {
                return bagthinks;
            }

            public void setBagthinks(List<BagthinksBeanX> bagthinks) {
                this.bagthinks = bagthinks;
            }

            @Override
            public String toString() {
                return "ChildBean{" +
                        "id='" + id + '\'' +
                        ", title='" + title + '\'' +
                        ", pid='" + pid + '\'' +
                        ", bagthinks=" + bagthinks +
                        '}';
            }

            public static class BagthinksBeanX {
                /**
                 * id : 2
                 * title : 22222
                 * originalprice : 200.00
                 * days : 1
                 * days_money : 20.00
                 * img : ./Public/headerimg/1111.png
                 */

                private String id;
                private String title;
                private String originalprice;
                private String days;
                private String days_money;
                private String img;

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

                @Override
                public String toString() {
                    return "BagthinksBeanX{" +
                            "id='" + id + '\'' +
                            ", title='" + title + '\'' +
                            ", originalprice='" + originalprice + '\'' +
                            ", days='" + days + '\'' +
                            ", days_money='" + days_money + '\'' +
                            ", img='" + img + '\'' +
                            '}';
                }
            }
        }
    }
}
