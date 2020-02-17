package com.example.mvvmdemo.provider;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.template.IProvider;

import javax.inject.Provider;

/**
 * Date: 2020/2/17
 * Time: 16:43
 * author: cmt
 * desc:
 */
public interface INewProvider extends IProvider {
    Fragment getNewsFragments();
}
