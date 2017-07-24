package org.paul.weatherforecast.week;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hannesdorfmann.mosby.mvp.MvpFragment;
import com.wang.avi.AVLoadingIndicatorView;

import org.paul.weatherforecast.R;
import org.paul.weatherforecast.base.BaseMvpFragment;
import org.paul.weatherforecast.bean.OneDay;
import org.paul.weatherforecast.bean.Weather;
import org.paul.weatherforecast.bean.WeatherDay;
import org.paul.weatherforecast.databinding.FragmentWeekBinding;
import org.paul.weatherforecast.locationforecast.LocationForecastPresenter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Paul on 22/7/17.
 */

public class WeekFragment extends BaseMvpFragment< WeatherDay,WeekMvpView, LocationForecastPresenter<WeekMvpView>> implements WeekMvpView{

    private FragmentWeekBinding binding;
    private WeekViewModel vm;
    private AVLoadingIndicatorView loading;


    @Override
    public LocationForecastPresenter<WeekMvpView> createPresenter() {
        return new LocationForecastPresenter<>(getContext());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (binding == null){
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_week, container, false);
        }
        return binding.getRoot();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        vm = new WeekViewModel(getPresenter());
        binding.setVm(vm);
        loading = (AVLoadingIndicatorView) getActivity().findViewById(R.id.week_network_processing);
        loading.smoothToShow();
        getPresenter().fetchSevenDaysForecast(getLocation());
    }


    @Override
    public void onSuccess(Object o) {
        loading.smoothToHide();
        WeatherDay weatherDay = (WeatherDay) o;
        Calendar c = Calendar.getInstance();
        List<RowOneDayViewModel> datas = new ArrayList<>();
        for (OneDay oneDay: weatherDay.getList()){
            String date = (String) DateFormat.format("yyyy-MM-dd", c);
            datas.add(new RowOneDayViewModel(oneDay, date));
            c.roll(Calendar.DATE, true);
        }
        vm.setItems(datas);
    }

    @Override
    public void onFailed() {
        loading.smoothToHide();
        Toast.makeText(getContext(), "Error to fetch week forecast data, please try again",Toast.LENGTH_SHORT).show();
    }
}
