package org.paul.weatherforecast;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import org.paul.weatherforecast.base.BaseMvpFragment;
import org.paul.weatherforecast.bean.OpenWeatherBean;
import org.paul.weatherforecast.bean.WeatherDay;
import org.paul.weatherforecast.today.TodayFragment;
import org.paul.weatherforecast.week.WeekFragment;

import java.io.Serializable;

/**
 * Created by Paul on 19/7/17.
 */

public class ForecastActivity extends BaseActivity {

    public enum ForecaseType{
        today, week
    }

    private ForecaseType currentShowType;
    private String location;

    @Override
    int getFragmentContainerId() {
        return R.id.forecast_container;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        Intent intent = getIntent();
        ForecaseType forecaseType = (ForecaseType) intent.getSerializableExtra(ForecaseType.class.getSimpleName());
        location = intent.getStringExtra("location");
        currentShowType = forecaseType;
        toolbar.setTitle(location);
        BaseMvpFragment fragment = null;
        if (forecaseType == ForecaseType.today){
            fragment = getForecastFragment(TodayFragment.class);

        }else if (forecaseType == ForecaseType.week){
            fragment = getForecastFragment(WeekFragment.class);
        }
        getSupportFragmentManager().beginTransaction().add(getFragmentContainerId(), fragment).commit();
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private <F extends BaseMvpFragment> F getForecastFragment(Class<F> fragmentClass){
        F fragment = null;
        try {
            fragment = fragmentClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        fragment.setLocation(location);
        return fragment;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_today:
                if (currentShowType==ForecaseType.week){
                    TodayFragment todayFragment = getForecastFragment(TodayFragment.class);
                    currentShowType = ForecaseType.today;
                    getSupportFragmentManager().beginTransaction().replace(getFragmentContainerId(), todayFragment).commit();
                }
                break;
            case R.id.action_week:
                if (currentShowType==ForecaseType.today){
                    WeekFragment weekFragment = getForecastFragment(WeekFragment.class);
                    currentShowType = ForecaseType.week;
                    getSupportFragmentManager().beginTransaction().replace(getFragmentContainerId(), weekFragment).commit();
                }
                break;
            case android.R.id.home:
                Intent intent = new Intent(this, MainActivity.class);
                NavUtils.navigateUpTo(this, intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
