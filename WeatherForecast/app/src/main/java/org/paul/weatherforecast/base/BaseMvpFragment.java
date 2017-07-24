package org.paul.weatherforecast.base;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpFragment;
import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by Paul on 22/7/17.
 */

public abstract class BaseMvpFragment<T, V extends MvpView, P extends MvpBasePresenter<V>> extends MvpFragment<V , P> {
    private T t;
    private String location;

    public void setData(T t) {
        this.t = t;
    }

    public T getData() {
        return t;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
