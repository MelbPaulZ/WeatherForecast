package org.paul.weatherforecast.retrofit;

import org.paul.weatherforecast.bean.OpenWeatherBean;
import org.paul.weatherforecast.bean.WeatherDay;

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

    @GET("daily?appid=df2491ca48f0f77fbfe7c3245a0d319c&cnt=7")
    Observable<WeatherDay> fetchSevenDaysWeather(@Query("q") String location);




//    http://samples.openweathermap.org/data/2.5/forecast/daily?id=524901&appid=b1b15e88fa797225412429c1c50c122a1
}
