package org.unimelb.daggertest.Test;

import org.unimelb.daggertest.MainActivity;
import org.unimelb.daggertest.User;
import org.unimelb.daggertest.UserModule;

import java.util.List;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Paul on 18/7/17.
 */
@Singleton
@Component(modules = {MockModule.class})
public interface TestComponent {
    Mock provideMock();
    List<User> provideUsers();
    void inject(MainActivity mainActivity);
}
