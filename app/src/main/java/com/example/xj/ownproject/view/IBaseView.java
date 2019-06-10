package com.example.xj.ownproject.view;

import android.content.Context;

/**
 * Created by AndroidXJ on 2019/6/10.
 */

public interface IBaseView {
    void refreshData();

    void showToast(String message);

    Context getContext();
}
