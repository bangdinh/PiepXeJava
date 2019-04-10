package com.xuanbang.me.piepxe.di.module;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class AndroidModule {

    @Singleton
    @Provides
    AudioManager provideAudioManager(Application application) {
        return (AudioManager) application.getSystemService(Context.AUDIO_SERVICE);
    }

    @Singleton
    @Provides
    SensorManager provideSensorManager(Application application) {
        return (SensorManager) application.getSystemService(Context.SENSOR_SERVICE);
    }

    @Singleton
    @Provides
    Sensor provideSensor(SensorManager sensorManager) {
        return sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Singleton
    @Provides
    ConnectivityManager provideConnectivityManager(Application application) {
        return (ConnectivityManager) application.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    @Singleton
    @Provides
    Resources provideAppResource(Application application) {
        return application.getResources();
    }

    @Singleton
    @Provides
    ActivityManager provideActivityManager(Application application) {
        return (ActivityManager) application.getSystemService(Context.ACTIVITY_SERVICE);
    }

}
