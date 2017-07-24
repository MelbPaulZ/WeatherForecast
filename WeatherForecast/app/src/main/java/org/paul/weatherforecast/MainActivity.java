package org.paul.weatherforecast;

import android.os.Bundle;

import org.paul.weatherforecast.locationforecast.LocationForecastFragment;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocationForecastFragment fragment = new LocationForecastFragment();
        getSupportFragmentManager().beginTransaction().add(getFragmentContainerId() ,fragment).commit();



//        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
//        setSupportActionBar(toolbar);
    }

    @Override
    int getFragmentContainerId() {
        return R.id.main_container;
    }
//

}
