package com.hzy.cnn.gethttpdata.GHttp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**

 *线程池，负责管理异步下载线程
 */

public class GHttpData {
    private static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    private static GHttpData gHttpData;
    private GHttpService gHttpService;
    private GHttpListener gHttpListener;
    private String url;
    public GHttpData(){

    }
    //开启线程
    public void postTask(String urlstr,GHttpService gHttpService,GHttpListener gHttpListener){
        this.gHttpService=gHttpService;
        this.gHttpListener=gHttpListener;
        this.url=urlstr;
        cachedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                GHttpData.this.gHttpService.setListener(GHttpData.this.gHttpListener);
                GHttpData.this.gHttpService.PostHttpRequest(GHttpData.this.url);
            }
        });
    }
    //单例模式
    public static GHttpData getInstance(){
        if(gHttpData==null){
            gHttpData = new GHttpData();
        }
        return gHttpData;
    }
}
