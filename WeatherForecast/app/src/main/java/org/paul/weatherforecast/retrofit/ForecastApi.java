package org.paul.weatherforecast.retrofit;

import org.paul.weatherforecast.bean.OpenWeatherBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Paul on 18/7/17.
 */

public interface ForecastApi {
    @GET("weather?appid=df2491ca48f0f77fbfe7c3245a0d319c")
    Observable<OpenWeatherBean> fetchWeather(@Query("q") String location);

    @GET("/weather?q=London,uk&appid=b1b15e88fa797225412429c1c50c122a1")
    Observable<OpenWeatherBean> fetchLondon();
}
