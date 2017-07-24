package org.paul.weatherforecast.today;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hannesdorfmann.mosby.mvp.MvpFragment;
import com.wang.avi.AVLoadingIndicatorView;

import org.paul.weatherforecast.R;
import org.paul.weatherforecast.base.BaseMvpFragment;
import org.paul.weatherforecast.bean.OpenWeatherBean;
import org.paul.weatherforecast.databinding.FragmentTodayBinding;
import org.paul.weatherforecast.locationforecast.LocationForecastMvpView;
import org.paul.weatherforecast.locationforecast.LocationForecastPresenter;

/**
 * Created by Paul on 18/7/17.
 */

public class TodayFragment extends BaseMvpFragment<OpenWeatherBean,TodayMvpView, LocationForecastPresenter<TodayMvpView>> implements TodayMvpView{

    private FragmentTodayBinding binding;
    private TodayViewModel vm;
    private AVLoadingIndicatorView loading;


    @Override
    public LocationForecastPresenter<TodayMvpView> createPresenter() {
        return new LocationForecastPresenter<>(getContext());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (binding==null){
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_today, container, false);
        }
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        vm = new TodayViewModel();
        binding.setVm(vm);
        loading = (AVLoadingIndicatorView) getActivity().findViewById(R.id.today_network_processing);
        loading.smoothToShow();
        presenter.fetchForecast(getLocation());
    }

    @Override
    public void onSuccess(OpenWeatherBean openWeatherBean) {
        loading.smoothToHide();
        vm.setOpenWeatherBean(openWeatherBean);
    }

    @Override
    public void onFailed() {
        loading.smoothToHide();
        Toast.makeText(getContext(), "Failed to fetch data, please try again", Toast.LENGTH_SHORT).show();
    }


}
