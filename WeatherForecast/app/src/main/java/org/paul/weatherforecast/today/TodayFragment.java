package org.paul.weatherforecast.today;

import com.hannesdorfmann.mosby.mvp.MvpFragment;

/**
 * Created by Paul on 18/7/17.
 */

public class TodayFragment extends MvpFragment<TodayMvpView, TodayPrensenter<TodayMvpView>> {
    @Override
    public TodayPrensenter<TodayMvpView> createPresenter() {
        return new TodayPrensenter<>(getContext());
    }
}
