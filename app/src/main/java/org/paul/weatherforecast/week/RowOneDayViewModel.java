package org.paul.weatherforecast.week;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import org.paul.weatherforecast.BR;
import org.paul.weatherforecast.bean.OneDay;

/**
 * Created by Paul on 24/7/17.
 */

public class RowOneDayViewModel extends BaseObservable {
    private OneDay oneDay;
    private String date;

    public RowOneDayViewModel(OneDay oneDay, String date) {
        this.oneDay = oneDay;
        this.date = date;
    }

    @Bindable
    public OneDay getOneDay() {
        return oneDay;
    }

    public void setOneDay(OneDay oneDay) {
        this.oneDay = oneDay;
        notifyPropertyChanged(BR.oneDay);
    }

    @Bindable
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
        notifyPropertyChanged(BR.date);
    }
}
