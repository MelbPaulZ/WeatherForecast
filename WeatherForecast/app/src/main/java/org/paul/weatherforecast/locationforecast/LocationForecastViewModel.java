package org.paul.weatherforecast.locationforecast;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import org.paul.weatherforecast.BR;

/**
 * Created by Paul on 18/7/17.
 */

public class LocationForecastViewModel extends BaseObservable {
    private String location;
    private LocationForecastPresenter<LocationForecastMvpView> presenter;

    public LocationForecastViewModel(LocationForecastPresenter<LocationForecastMvpView> presenter) {
        this.presenter = presenter;
    }

    @Bindable
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
        notifyPropertyChanged(BR.location);
    }

    public void onFetchTodaysForecast(){
        LocationForecastMvpView mvpView = presenter.getView();
        if (mvpView!=null){
            mvpView.onClickToday(location);
        }
    }

    public void onFetchSevenDaysForecast(){
        LocationForecastMvpView mvpView = presenter.getView();
        if (mvpView!=null){
            mvpView.onClickWeek(location);
        }
    }
}
