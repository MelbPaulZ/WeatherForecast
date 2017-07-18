package org.paul.weatherforecast.locationforecast;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby.mvp.MvpFragment;

import org.paul.weatherforecast.R;
import org.paul.weatherforecast.databinding.FragmentLocationForecastBinding;

/**
 * Created by Paul on 18/7/17.
 */

public class LocationForecastFragment extends MvpFragment<LocationForecastMvpView, LocationForecastPresenter<LocationForecastMvpView>> {
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
}
