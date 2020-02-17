package com.example.mvvmdemo.binding.viewAdapter.daisyrefresh;

import androidx.databinding.BindingAdapter;

import com.example.mvvmdemo.binding.command.BindingCommand;
import com.refresh.lib.BaseRefreshLayout;
import com.refresh.lib.DaisyRefreshLayout;

/**
 * Date: 2020/2/17
 * Time: 17:24
 * author: cmt
 * desc: 可刷新的adapter
 */
public class ViewAdapter {
    //添加了下拉刷新的监听设置，设置了onRefreshCommand监听器的地方可以接收到回调
    @BindingAdapter(value ={"onRefreshCommand","onLoadMoreCommand","onAutoRefreshCommand"},requireAll = false)
    public static void onRefreshCommand(DaisyRefreshLayout refreshLayout, final BindingCommand onRefreshCommand,final BindingCommand onLoadMoreCommand,final BindingCommand onAutoRerefeshCommond){
        refreshLayout.setOnRefreshListener(new BaseRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if(onRefreshCommand != null)
                    onRefreshCommand.execute();
            }
        });
        refreshLayout.setOnLoadMoreListener(new BaseRefreshLayout.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                if (onLoadMoreCommand != null) {
                    onLoadMoreCommand.execute();
                }
            }
        });
        refreshLayout.setOnAutoLoadListener(new BaseRefreshLayout.OnAutoLoadListener() {
            @Override
            public void onAutoLoad() {
                if (onAutoRerefeshCommond != null) {
                    onAutoRerefeshCommond.execute();
                }
            }
        });
    }

}
