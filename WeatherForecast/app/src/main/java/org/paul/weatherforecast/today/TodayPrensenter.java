package org.paul.weatherforecast.today;

import android.content.Context;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by Paul on 18/7/17.
 */

public class TodayPrensenter<V extends MvpView> extends MvpBasePresenter<V> {
    private Context context;

    public TodayPrensenter(Context context) {
        this.context = context;
    }
}
