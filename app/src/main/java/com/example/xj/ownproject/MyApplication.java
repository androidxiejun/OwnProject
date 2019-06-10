package com.example.xj.ownproject;

import android.app.Application;

import com.example.netlibrary.nethelper.RetrofitClient;
import com.example.netlibrary.sqlhelper.GreenDaoUtil;
import com.example.seriallibrary.service.impl.SerialPortService;
import com.example.xj.ownproject.module.BaseContent;

import java.io.IOException;

/**
 * Created by AndroidXJ on 2019/6/10.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        try {
            //初始化数据库
            GreenDaoUtil.getInstance().init(getApplicationContext());
            //初始化网络库
            RetrofitClient.getmInstance().init(getApplicationContext());
            //初始化串口通信
            SerialPortService.getInstance().init(BaseContent.DEVICEPATH, BaseContent.BAUDRATE, BaseContent.TIME_OUT_CMD);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
