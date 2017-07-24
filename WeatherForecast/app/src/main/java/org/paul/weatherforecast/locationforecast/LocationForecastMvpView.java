package org.paul.weatherforecast.locationforecast;

import com.hannesdorfmann.mosby.mvp.MvpView;

import org.paul.weatherforecast.base.BaseMvpView;
import org.paul.weatherforecast.bean.OpenWeatherBean;

/**
 * Created by Paul on 18/7/17.
 */

public interface LocationForecastMvpView extends MvpView {
    void onClickToday(String location);
    void onClickWeek(String location);
}
