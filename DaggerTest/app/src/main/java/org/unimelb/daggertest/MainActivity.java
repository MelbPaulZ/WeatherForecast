package org.unimelb.daggertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.unimelb.daggertest.Test.DaggerTestComponent;
import org.unimelb.daggertest.Test.Mock;
import org.unimelb.daggertest.Test.TestComponent;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    TestComponent testComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
        testComponent = DaggerTestComponent.builder().build();
        testComponent.inject(this);

        Mock mock = testComponent.provideMock();
        List<User> users = testComponent.provideUsers();
        Log.i("asda", "onCreate: " + testComponent.provideMock());


    }
}
