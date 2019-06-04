package com.example.netlibrary.Util;

import android.content.Context;

import com.example.netlibrary.api.INetService;
import com.example.netlibrary.callback.INetCallback;

import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by AndroidXJ on 2019/6/4.
 */

public class RetrofitClient {
    /**
     * 连接超时时长
     **/
    private static final int CONNECT_TIME_OUT = 20;
    /**
     * 读数据超时时长
     **/
    private static final int READ_TIME_OUT = 60;
    /**
     * 写数据接超时时长
     **/
    private static final int WRITE_TIME_OUT = 60;

    private static String BASE_URL = "";

    private Retrofit mRetrofit;
    private INetService mNetService;
    private OkHttpClient mOkHttpClient;
    private Context mContext;

    private static RetrofitClient mInstance;

    public static synchronized RetrofitClient getmInstance(Context context) {
        if (mInstance == null) {
            mInstance = new RetrofitClient(context);
        }
        return mInstance;
    }

    public String getBaseUrl() {
        return BASE_URL;
    }

    public void setBaseUrl(String url) {
        this.BASE_URL = url;
    }

    private RetrofitClient(Context context) {
        mContext = context.getApplicationContext();
        File httpCacheDirectory = new File(context.getCacheDir(), "responses");//设置缓存路径
        Cache cache = new Cache(httpCacheDirectory, 10 * 1024 * 1024);

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIME_OUT, TimeUnit.SECONDS)
                //.cache(cache)// 设置Cache目录
                //走缓存，两个都要设置
                //.addInterceptor(new NetworkInterceptor(context))
                //.addNetworkInterceptor(new NetworkInterceptor(context))
                .retryOnConnectionFailure(true);// 失败重连
        //.addInterceptor(interceptorManager);// 添加拦截器，存取cookie
        // .sslSocketFactory(BaseApplication.sslParams.sSLSocketFactory, BaseApplication.sslParams.trustManager)// 添加证书
        // .hostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

        mOkHttpClient = builder.build();
        mRetrofit = new Retrofit.Builder()
                .client(mOkHttpClient)
                .baseUrl(getBaseUrl())
                .addConverterFactory(ScalarsConverterFactory.create())// 增加返回值为String的支持
                .addConverterFactory(GsonConverterFactory.create())// 增加返回值为Gson的支持(以实体类返回)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        mNetService = mRetrofit.create(INetService.class);

    }

    /**
     *
     * @param url
     * @param maps
     * @param callback
     */
    public void getData(String url, Map<String ,Object>maps, INetCallback callback){
        mNetService.getData(url,maps)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
