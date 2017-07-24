package org.paul.weatherforecast.locationforecast;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby.mvp.MvpFragment;

import org.paul.weatherforecast.ForecastActivity;
import org.paul.weatherforecast.R;
import org.paul.weatherforecast.bean.OpenWeatherBean;
import org.paul.weatherforecast.bean.WeatherDay;
import org.paul.weatherforecast.databinding.FragmentLocationForecastBinding;

/**
 * Created by Paul on 18/7/17.
 */

public class LocationForecastFragment extends MvpFragment<LocationForecastMvpView, LocationForecastPresenter<LocationForecastMvpView>> implements LocationForecastMvpView {
    private FragmentLocationForecastBinding binding;
    private LocationForecastViewModel vm;

    @Override
    public LocationForecastPresenter<LocationForecastMvpView> createPresenter() {
        return new LocationForecastPresenter<>(getContext());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (binding == null){
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_location_forecast, container, false);
        }
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (vm == null){
            vm = new LocationForecastViewModel(getPresenter());
        }
        binding.setVm(vm);

    }


//    @Override
//    public void onSuccess(Object o) {
//        Intent intent = new Intent(getActivity(), ForecastActivity.class);
//        intent.putExtra("location", vm.getLocation());
//        if (o instanceof OpenWeatherBean) {
//            intent.putExtra(OpenWeatherBean.class.getSimpleName(), (OpenWeatherBean) o);
//            intent.putExtra(ForecastActivity.ForecaseType.class.getSimpleName(), ForecastActivity.ForecaseType.today);
//        }else if (o instanceof WeatherDay){
//            intent.putExtra(WeatherDay.class.getSimpleName(), (WeatherDay)o);
//            intent.putExtra(ForecastActivity.ForecaseType.class.getSimpleName(), ForecastActivity.ForecaseType.week );
//        }
//        startActivity(intent);
//    }



    @Override
    public void onClickToday(String location) {
        Intent intent = new Intent(getActivity(), ForecastActivity.class);
        intent.putExtra("location", location);
        intent.putExtra(ForecastActivity.ForecaseType.class.getSimpleName(), ForecastActivity.ForecaseType.today);
        startActivity(intent);
    }

    @Override
    public void onClickWeek(String location) {
        Intent intent = new Intent(getActivity(), ForecastActivity.class);
        intent.putExtra("location", location);
        intent.putExtra(ForecastActivity.ForecaseType.class.getSimpleName(), ForecastActivity.ForecaseType.week );
        startActivity(intent);

    }
}
