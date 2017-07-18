package org.unimelb.daggertest;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Paul on 17/7/17.
 */
@Module
public class UserModule {
    @Provides
    @Singleton
    User aaa(){
        return new User("Lars", "Vogel");
    }

}
