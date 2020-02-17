package com.example.mvvmdemo.mvvm.view;

/**
 * Date: 2020/2/17
 * Time: 15:12
 * author: cmt
 * desc:
 */
public interface IBaseView {
    void initView(); //初始化view
    void initListener(); //初始化监听器
    void initData(); //初始化数据
    void finishActivity(); //结束当前activity
    void showInitLoadView(); //显示初始化加载框
    void showNoDataView(); //显示没有数据的布局
    void showTransLoadingView(); //显示透明加载框
    void showNetworkErrView(); //显示没有网络的布局
}
