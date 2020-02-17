package com.example.mvvmdemo.mvvm.viewmodel;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

import com.example.mvvmdemo.event.SingleLiveEvent;
import com.example.mvvmdemo.mvvm.model.BaseModel;
import com.example.mvvmdemo.mvvm.model.IBaseModel;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.disposables.Disposable;

/**
 * Date: 2020/2/17
 * Time: 15:39
 * author: cmt
 * desc: viewmodel 是负责将model里面获取的数据，和view的进行关联，
 */
public class BaseViewModel<M extends BaseModel> extends AndroidViewModel implements IBaseViewModel, Consumer<Disposable> {
    protected M mModel;
    protected UIChangeLiveData mUIChangeLiveData;
    public BaseViewModel(@NonNull Application application,M model) {
        super(application);
        this.mModel = model;
    }
    //相当于一个数据实体更新状态的一个触发器，调用定义好的方法去触发ui界面的变化
    public UIChangeLiveData getUC(){
        if(mUIChangeLiveData == null)
            mUIChangeLiveData = new UIChangeLiveData();
        return mUIChangeLiveData;
    }

    @Override
    public void onAny(LifecycleOwner owner, Lifecycle.Event event) {

    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    //具有观察者模式的数据实体更新事件
    public final class UIChangeLiveData extends SingleLiveEvent {
        private SingleLiveEvent<Boolean> showInitLoadViewEvent;
        private SingleLiveEvent<Boolean> showTransLoadingViewEvent;
        private SingleLiveEvent<Boolean> showNoDataViewEvent;
        private SingleLiveEvent<Boolean> showNetWorkErrViewEvent;
        private SingleLiveEvent<Map<String, Object>> startActivityEvent;
        private SingleLiveEvent<Void> finishActivityEvent;
        private SingleLiveEvent<Void> onBackPressedEvent;

        public SingleLiveEvent<Boolean> getShowInitLoadViewEvent() {
            return showInitLoadViewEvent;
        }

        public SingleLiveEvent<Boolean> getShowTransLoadingViewEvent() {
            return showTransLoadingViewEvent;
        }

        public SingleLiveEvent<Boolean> getShowNoDataViewEvent() {
            return showNoDataViewEvent;
        }

        public SingleLiveEvent<Boolean> getShowNetWorkErrViewEvent() {
            return showNetWorkErrViewEvent;
        }

        public SingleLiveEvent<Map<String, Object>> getStartActivityEvent() {
            return startActivityEvent;
        }

        public SingleLiveEvent<Void> getFinishActivityEvent() {
            return finishActivityEvent;
        }

        public SingleLiveEvent<Void> getOnBackPressedEvent() {
            return onBackPressedEvent;
        }

        protected SingleLiveEvent createLiveData(SingleLiveEvent liveData){
            if(liveData==null)
                liveData = new SingleLiveEvent();
            return liveData;
        }

        public void postShowInitLoadViewEvent(boolean show) {
            if (mUIChangeLiveData != null) {
                mUIChangeLiveData.showInitLoadViewEvent.postValue(show);
            }
        }

        public void postShowNoDataViewEvent(boolean show) {
            if (mUIChangeLiveData != null) {
                mUIChangeLiveData.showNoDataViewEvent.postValue(show);
            }
        }

        public void postShowTransLoadingViewEvent(boolean show) {
            if (mUIChangeLiveData != null) {
                mUIChangeLiveData.showTransLoadingViewEvent.postValue(show);
            }
        }

        public void postShowNetWorkErrViewEvent(boolean show) {
            if (mUIChangeLiveData != null) {
                mUIChangeLiveData.showNetWorkErrViewEvent.postValue(show);
            }
        }
        public void postStartActivityEvent(Class<?> clz, Bundle bundle) {
            Map<String, Object> params = new HashMap<>();
            params.put(ParameterField.CLASS, clz);
            if (bundle != null) {
                params.put(ParameterField.BUNDLE, bundle);
            }
            mUIChangeLiveData.startActivityEvent.postValue(params);
        }


        public void postFinishActivityEvent() {
            mUIChangeLiveData.finishActivityEvent.call();
        }


        public void postOnBackPressedEvent() {
            mUIChangeLiveData.onBackPressedEvent.call();
        }
    }



    @Override
    public void accept(Disposable disposable) {

    }

    @Override
    public void onCleared() {

    }


    public static final class ParameterField {
        public static String CLASS = "CLASS";
        public static String CANONICAL_NAME = "CANONICAL_NAME";
        public static String BUNDLE = "BUNDLE";
    }
}
