package com.hzy.cnn.gethttpdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.hzy.cnn.gethttpdata.GHttp.GHttpData;
import com.hzy.cnn.gethttpdata.GHttp.GHttpJsonListener;
import com.hzy.cnn.gethttpdata.GHttp.GHttpJsonService;
import com.hzy.cnn.gethttpdata.GHttp.GHttpListener;
import com.hzy.cnn.gethttpdata.GHttp.JsonMessage;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //自行设置一个可用的URL地址和传入的JsonMessage为JSON的JavaBean数据
        String url="";
        final TextView tv=findViewById(R.id.tv);
        GHttpData.getInstance().postTask(url, new GHttpJsonService(), new GHttpJsonListener<JsonMessage>() {
            @Override
            public void OnSuccess(JsonMessage data) {
                //data为获取到的JSON数据对应的javaBean对象
                tv.setText(data.UserInfos.get(0).toString());
            }

            @Override
            public void OnFailure() {

                tv.setText("获取数据失败！");
            }
        });

    }
}
