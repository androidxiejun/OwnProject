package com.example.netlibrary.api;


import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by AndroidXJ on 2019/6/4.
 */

public interface INetService {
    @POST
    Observable<String> getData(@Url String url, @QueryMap Map<String, Object> maps);
}
