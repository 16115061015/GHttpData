package com.hzy.cnn.gethttpdata.GHttp;

import java.util.List;

/**
 * Created by asus on 2018/2/4.
 */

public class JsonMessage {
    //这里的List实例必须与Json数据中的名字相同
    public List<UserInfo> UserInfos;
    public static class UserInfo{
        private String name;
        private String touxianImage;
        private String says;
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTouxianImage() {
            return touxianImage;
        }

        public void setTouxianImage(String touxianImage) {
            this.touxianImage = touxianImage;
        }

        public String getSays() {
            return says;
        }

        public void setSays(String says) {
            this.says = says;
        }

        @Override
        public String toString() {
            return "name:"+name+" "+"touxianImage:"+touxianImage+" "+"says:"+says+"\n";
        }
    }
}

