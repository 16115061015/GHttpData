package com.hzy.cnn.gethttpdata.GHttp;

import android.os.Looper;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 */

public class GHttpJsonService implements GHttpService {
    private URL url;
    private GHttpJsonListener listener;
    private HttpURLConnection httpURLConnection;
    //获得的返回字符串
    private StringBuffer stringBuffer=new StringBuffer();

    private BufferedReader bufferedReader;

    private android.os.Handler handler=new android.os.Handler(Looper.getMainLooper());
    @Override
    public void PostHttpRequest(String urlstr) {
        //实际操作获取数据流
        try {
            String str;
            //网络请求数据
            url = new URL(urlstr);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            while ((str = bufferedReader.readLine()) != null) {
                stringBuffer.append(str);
            }
            Log.i("数据", "PostHttpRequest: "+stringBuffer.toString());

            //主线程执行回调
            handler.post(new Runnable() {
                @Override
                public void run() {
                    if(listener!=null) {
                        //回调数据
                        listener.SetData(stringBuffer);
                    }
                }
            });
        } catch (java.io.IOException e) {
            e.printStackTrace();
            //主线程执行
            handler.post(new Runnable() {
                @Override
                public void run() {
                    if(listener!=null) {
                        listener.OnFailure();
                    }
                }
            });
        }finally {
            try {
                if(bufferedReader!=null) {

                    bufferedReader.close();
                }
                if(httpURLConnection!=null){
                    httpURLConnection.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public void setListener(GHttpListener gHttpListener) {
        this.listener =(GHttpJsonListener)gHttpListener;
    }
}