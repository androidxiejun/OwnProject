package com.example.netlibrary.sqlhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.netlibrary.entity.dao.DaoMaster;
import com.example.netlibrary.entity.dao.DaoSession;

/**
 * Created by AndroidXJ on 2019/6/10.
 */

public class GreenDaoUtil {
    public static GreenDaoUtil mInstance;

    private DaoMaster mMaster;
    private DaoMaster.OpenHelper mHelper;
    private SQLiteDatabase mDb;
    private DaoSession mSession;

    public static GreenDaoUtil getInstance() {
        synchronized (GreenDaoUtil.class) {
            if (mInstance == null) {
                mInstance = new GreenDaoUtil();
            }
        }
        return mInstance;
    }

    public void init(Context context) {
        mHelper = new MyOpenHelper(context, "user.db", null);
        mDb = mHelper.getWritableDatabase();
        mMaster = new DaoMaster(mDb);
        mSession = mMaster.newSession();
    }

    public DaoSession getSession() {
        return mSession;
    }
}
