package com.example.netlibrary.api;


import com.example.netlibrary.entity.bean.User;

import java.util.Map;

import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by AndroidXJ on 2019/6/4.
 */

public interface INetService {
    @POST
    Observable<User> getData(@Url String url, @QueryMap Map<String, Object> maps);
}
