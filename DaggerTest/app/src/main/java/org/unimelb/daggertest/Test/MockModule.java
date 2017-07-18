package org.unimelb.daggertest.Test;

import org.unimelb.daggertest.User;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Paul on 18/7/17.
 */

@Module
public class MockModule {

    @Provides
    @Singleton
    Mock provideMock(){
        return new Mock();
    }

    @Provides
    List<User> provideUsers(){
        List<User> users = new ArrayList<>();
        users.add(new User("1F","1L"));
        users.add(new User("2F","2L"));
        users.add(new User("3F","3L"));
        users.add(new User("4F","4L"));
        return users;
    }
}
