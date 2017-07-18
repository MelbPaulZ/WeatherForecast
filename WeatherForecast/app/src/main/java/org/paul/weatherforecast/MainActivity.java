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
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.toolbar_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.action_today:
//                Toast.makeText(getApplicationContext(), "today", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.action_week:
//                Toast.makeText(getApplicationContext(), "today", Toast.LENGTH_SHORT).show();
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
