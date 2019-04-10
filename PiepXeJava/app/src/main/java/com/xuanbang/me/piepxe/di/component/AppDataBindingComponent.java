package com.xuanbang.me.piepxe.di.component;

import android.app.Application;

import com.xuanbang.me.piepxe.di.module.AppDataBindingModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;


/**
 * Ref: https://android.jlelse.eu/android-data-binding-event-binding-part-2-5c0893480eef
 * Ref: https://android.jlelse.eu/data-binding-attributes-and-event-handler-4f51d188ea7d
 */
@Singleton
@Component(modules = {
        AppDataBindingModule.class
})
public interface AppDataBindingComponent extends androidx.databinding.DataBindingComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppDataBindingComponent build();
    }
}
