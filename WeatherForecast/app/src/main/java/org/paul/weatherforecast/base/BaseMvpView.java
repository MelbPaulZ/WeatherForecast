package org.paul.weatherforecast.base;

import com.hannesdorfmann.mosby.mvp.MvpView;

import org.paul.weatherforecast.bean.OpenWeatherBean;

/**
 * Created by Paul on 19/7/17.
 */

public interface BaseMvpView<T> extends MvpView {
    void onSuccess(T t);
    void onFailed();
}
