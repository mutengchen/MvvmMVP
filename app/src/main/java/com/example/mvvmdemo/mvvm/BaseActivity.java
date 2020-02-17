package com.example.mvvmdemo.mvvm;


import com.example.mvvmdemo.mvvm.view.IBaseView;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * Date: 2020/2/17
 * Time: 14:55
 * author: cmt
 * desc:
 */
public class BaseActivity  extends RxAppCompatActivity implements IBaseView {
    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void finishActivity() {

    }

    @Override
    public void showInitLoadView() {

    }

    @Override
    public void showNoDataView() {

    }

    @Override
    public void showTransLoadingView() {

    }

    @Override
    public void showNetworkErrView() {

    }
}
