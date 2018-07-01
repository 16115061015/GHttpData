package com.hzy.cnn.gethttpdata.GHttp;

/**
 * Created by 胡泽宇 on 2018/6/18.
 * 数据监听接口用于回调任务数据
 */

public interface GHttpListener<M> {
    public void OnSuccess(M data);
    public void OnFailure();
}
