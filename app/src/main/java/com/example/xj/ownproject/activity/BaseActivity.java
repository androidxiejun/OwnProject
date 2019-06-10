package com.example.xj.ownproject.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.xj.ownproject.presenter.BasePresenter;
import com.example.xj.ownproject.view.IBaseView;

/**
 * Created by AndroidXJ on 2019/6/10.
 */

public abstract class BaseActivity extends AppCompatActivity implements IBaseView {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
        init();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void refreshData() {

    }

    @Override
    public void showToast(String message) {

    }

    protected abstract void init();

    protected abstract void initView();

    protected abstract @LayoutRes
    int getLayoutId();

    protected abstract <P extends BasePresenter> BasePresenter bindPresenter();
}
