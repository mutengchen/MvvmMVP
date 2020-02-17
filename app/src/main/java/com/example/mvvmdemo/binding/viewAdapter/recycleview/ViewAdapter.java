package com.example.mvvmdemo.binding.viewAdapter.recycleview;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Date: 2020/2/17
 * Time: 17:22
 * author: cmt
 * desc:
 */
public class ViewAdapter {

    //设置recycleview的布局
    @BindingAdapter({"linearLayoutManager"})
    public static void setLinearLayoutManager(RecyclerView recyclerView,boolean b){
        LinearLayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext());
        layoutManager.setOrientation(b?LinearLayoutManager.HORIZONTAL:LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
    }
}
