package org.paul.weatherforecast.locationforecast;

import android.content.Context;
import android.util.Log;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

import org.paul.weatherforecast.Util.NetworkUtil;
import org.paul.weatherforecast.base.NetworkBase;
import org.paul.weatherforecast.bean.OpenWeatherBean;
import org.paul.weatherforecast.retrofit.ForecastApi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Paul on 18/7/17.
 */

public class LocationForecastPresenter<V extends MvpView> extends MvpBasePresenter<V> {
    private Context context;
    private Retrofit retrofit;

    public LocationForecastPresenter(Context context) {
        this.context = context;
    }

    public void fetchForecast(String location){
        retrofit = NetworkUtil.getRetrofit();
        ForecastApi forecastApi = retrofit.create(ForecastApi.class);
        NetworkUtil.subscribe(forecastApi.fetchWeather(location), new Subscriber<OpenWeatherBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.i("", "onError: "  );
            }

            @Override
            public void onNext(OpenWeatherBean openWeatherBean) {
                Log.i("", "onNext: ");
            }
        });
    }
}
