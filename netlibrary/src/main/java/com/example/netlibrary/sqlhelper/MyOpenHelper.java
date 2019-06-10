package com.example.netlibrary.sqlhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.netlibrary.entity.dao.DaoMaster;

import org.greenrobot.greendao.database.Database;

/**
 * Created by AndroidXJ on 2019/6/10.
 */

public class MyOpenHelper extends DaoMaster.OpenHelper {

    public MyOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
    }
}
