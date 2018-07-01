package com.hzy.cnn.gethttpdata.GHttp;

import java.net.URL;

/**
 * Created by 胡泽宇 on 2018/6/18.
 * 实际操作接口
 */

public interface GHttpService {
    //发送请求数据
    public void PostHttpRequest(String urlstr);
    //设置监听
    public void setListener(GHttpListener gHttpListener);

}
