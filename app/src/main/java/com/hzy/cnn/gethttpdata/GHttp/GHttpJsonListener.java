package com.hzy.cnn.gethttpdata.GHttp;
import android.util.Log;
import com.google.gson.Gson;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 */

public abstract class GHttpJsonListener<M> implements GHttpListener<M>{

    Class<M> dataclass;
    @Override
    abstract public void OnSuccess(M data);
    public void SetData(StringBuffer stringBuffer){
        //获取泛型类型
        Type genType = this.getClass().getGenericSuperclass();
        dataclass = (Class<M>)((ParameterizedType)genType).getActualTypeArguments()[0];

        Log.i("标志", "SetData: "+dataclass.getName());

        //转换为javabean数据
         Gson gson=new Gson();
         M jm = gson.fromJson(stringBuffer.toString(),dataclass);
         OnSuccess((M)jm);
    }

    @Override
    abstract public void OnFailure();
}
