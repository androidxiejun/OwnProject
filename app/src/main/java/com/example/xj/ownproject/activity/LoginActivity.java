package com.example.xj.ownproject.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.netlibrary.entity.bean.User;
import com.example.netlibrary.sqlhelper.GreenDaoUtil;
import com.example.xj.ownproject.R;
import com.example.xj.ownproject.presenter.BasePresenter;
import com.example.xj.ownproject.presenter.LoginPresenter;

/**
 * Created by AndroidXJ on 2019/6/10.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private LoginPresenter mPresenter;
    private Context mContext;
    private TextView mTxt;
    private Button mBtnSave, mBtnChange;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mPresenter = (LoginPresenter) bindPresenter();
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initView() {
        if (mPresenter != null) {
            mPresenter.attechView(this);
        }
        mContext = this;
        mTxt = findViewById(R.id.sample_text);
        mBtnSave = findViewById(R.id.btn_save);
        mBtnChange = findViewById(R.id.btn_change);
        mBtnSave.setOnClickListener(this);
        mBtnChange.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter<LoginActivity> bindPresenter() {
        mPresenter = new LoginPresenter();
        return mPresenter;
    }

    @Override
    public Context getContext() {
        return mContext;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save:
                User user=new User();
                user.setName("xiejun ");
                user.setAge(18);
                GreenDaoUtil.getInstance().getSession().getUserDao().save(user);
                break;
            case R.id.btn_change:
                break;
        }
    }
}
