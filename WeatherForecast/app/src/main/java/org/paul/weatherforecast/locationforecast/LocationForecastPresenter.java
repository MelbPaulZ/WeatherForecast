package org.paul.weatherforecast.locationforecast;

import android.content.Context;
import android.util.Log;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

import org.paul.weatherforecast.Util.NetworkUtil;
import org.paul.weatherforecast.base.NetworkBase;
import org.paul.weatherforecast.bean.OpenWeatherBean;
import org.paul.weatherforecast.bean.WeatherDay;
import org.paul.weatherforecast.retrofit.ForecastApi;
import org.paul.weatherforecast.today.TodayMvpView;
import org.paul.weatherforecast.week.WeekMvpView;

import retrofit2.Retrofit;
import rx.Subscriber;


/**
 * Created by Paul on 18/7/17.
 */

public class LocationForecastPresenter<V extends MvpView> extends MvpBasePresenter<V> {
    private Context context;
    public LocationForecastPresenter(Context context) {
        this.context = context;
    }

    public void fetchForecast(String location){

        Retrofit retrofit = NetworkUtil.getRetrofit(NetworkBase.SingleDateUrl);
        ForecastApi forecastApi = retrofit.create(ForecastApi.class);
        NetworkUtil.subscribe(forecastApi.fetchWeather(location), new Subscriber<OpenWeatherBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                TodayMvpView view = (TodayMvpView) getView();
                if (view!=null){
                    view.onFailed();
                }
            }

            @Override
            public void onNext(OpenWeatherBean openWeatherBean) {
                TodayMvpView view = (TodayMvpView) getView();
                if (view!=null){
                    view.onSuccess(openWeatherBean);
                }
            }
        });
    }

    public void fetchSevenDaysForecast(String location){
        Retrofit retrofit = NetworkUtil.getRetrofit(NetworkBase.SevenDaysUtl);
        ForecastApi forecastApi = retrofit.create(ForecastApi.class);
        NetworkUtil.subscribe(forecastApi.fetchSevenDaysWeather(location), new Subscriber<WeatherDay>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                WeekMvpView view = (WeekMvpView) getView();
                if (view!=null){
                    view.onFailed();
                }
            }

            @Override
            public void onNext(WeatherDay weatherDay) {
                WeekMvpView view = (WeekMvpView) getView();
                if (view!=null){
                    view.onSuccess(weatherDay);
                }
            }
        });
    }
}
