package org.paul.weatherforecast.Util;

import org.paul.weatherforecast.base.NetworkBase;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Paul on 18/7/17.
 */

public class NetworkUtil {
    private static Retrofit retrofit;
    public static Retrofit getRetrofit(){
        if (retrofit==null) {
            retrofit = new Retrofit.Builder().baseUrl(NetworkBase.BaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static <T> void subscribe(Observable<T> observable, Subscriber<? super T> subscriber){
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
