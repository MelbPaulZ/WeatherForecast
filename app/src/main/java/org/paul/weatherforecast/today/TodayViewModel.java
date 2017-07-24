package org.paul.weatherforecast.today;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import org.paul.weatherforecast.BR;
import org.paul.weatherforecast.bean.OpenWeatherBean;

/**
 * Created by Paul on 18/7/17.
 */

public class TodayViewModel extends BaseObservable {
    private OpenWeatherBean openWeatherBean;

    public TodayViewModel() {

    }

    public void setOpenWeatherBean(OpenWeatherBean openWeatherBean) {
        this.openWeatherBean = openWeatherBean;
        notifyPropertyChanged(BR.openWeatherBean);
    }

    @Bindable
    public OpenWeatherBean getOpenWeatherBean() {
        return openWeatherBean;
    }
}
