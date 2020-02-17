package com.example.mvvmdemo;

import android.app.Application;
import android.os.Build;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.mvvmdemo.util.log.KLog;
import com.facebook.stetho.Stetho;

/**
 * Date: 2020/2/17
 * Time: 14:20
 * author: cmt
 * desc:
 */
public class BaseApplication extends Application {
    private static BaseApplication mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        //初始化app的日志记录
        KLog.init(BuildConfig.IS_DEBUG);
        //fackbook开发的android调试工具，可以与chrome配合
        Stetho.initializeWithDefaults(this);
        if(BuildConfig.IS_DEBUG){
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); //阿里的路由管理框架
    }
}
