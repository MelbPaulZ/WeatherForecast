package org.paul.weatherforecast.week;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;
import android.view.View;

import org.paul.weatherforecast.BR;
import org.paul.weatherforecast.R;
import org.paul.weatherforecast.bean.WeatherDay;
import org.paul.weatherforecast.locationforecast.LocationForecastPresenter;

import java.util.List;

import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * Created by Paul on 22/7/17.
 */

public class WeekViewModel extends BaseObservable {
    private LocationForecastPresenter<WeekMvpView> presenter;
    private WeatherDay weatherDay;

    public WeekViewModel(LocationForecastPresenter<WeekMvpView> presenter) {
        this.presenter = presenter;
    }

    public void searchSevenDaysLocation(String location){
        presenter.fetchSevenDaysForecast(location);
    }

    private List<RowOneDayViewModel> items = new ObservableArrayList<>();
    private ItemBinding<RowOneDayViewModel> itemBinding = ItemBinding.of(BR.oneDayVM, R.layout.row_one_day);

    @Bindable
    public List<RowOneDayViewModel> getItems() {
        return items;
    }

    public void setItems(List<RowOneDayViewModel> items) {
        this.items = items;
        notifyPropertyChanged(BR.items);
    }

    @Bindable
    public ItemBinding<RowOneDayViewModel> getItemBinding() {
        return itemBinding;
    }

    public void setItemBinding(ItemBinding<RowOneDayViewModel> itemBinding) {
        this.itemBinding = itemBinding;
        notifyPropertyChanged(BR.itemBinding);
    }
}
