package com.example.mvvmdemo.mvvm.model;

import android.app.Application;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Date: 2020/2/17
 * Time: 15:20
 * author: cmt
 * desc:
 */
public abstract class BaseModel implements IBaseModel {
    protected Application mApplication;
    //管理retrofit的产生的Disposable,防止UI销毁的时候，造成的内存泄漏
    private CompositeDisposable mCompositeDisposable;

    public BaseModel(Application mApplication) {
        this.mApplication = mApplication;
        mCompositeDisposable = new CompositeDisposable();
    }

    //往管理器中添加disposable
    public void addSubscribe(Disposable disposable){
        if(mCompositeDisposable==null){
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void onCleared() {
        if(mCompositeDisposable!=null)
            mCompositeDisposable.clear();
    }
}
