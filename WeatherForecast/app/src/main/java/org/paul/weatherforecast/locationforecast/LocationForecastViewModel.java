package org.paul.weatherforecast.locationforecast;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import org.paul.weatherforecast.BR;

/**
 * Created by Paul on 18/7/17.
 */

public class LocationForecastViewModel extends BaseObservable {
    private String location;
    private LocationForecastPresenter presenter;

    public LocationForecastViewModel(LocationForecastPresenter presenter) {
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
        presenter.fetchForecast(location);
    }
}
