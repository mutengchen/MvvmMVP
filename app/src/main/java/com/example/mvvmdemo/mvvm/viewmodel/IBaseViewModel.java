package com.example.mvvmdemo.mvvm.viewmodel;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * Date: 2020/2/17
 * Time: 15:28
 * author: cmt
 * desc: 定义baseViewmodel里面的所有生命周期
 *        使用了lifecycle来做activity资源的销毁处理，是通过观察者模式来实现的，随生命周期的变化，来释放资源，减少与调用者之间的耦合
 */
public interface IBaseViewModel extends LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    void onAny(LifecycleOwner owner,Lifecycle.Event event);

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate();

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy();

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onStart();

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onStop();

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResume();

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void onPause();
}
