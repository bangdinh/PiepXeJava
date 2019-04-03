package com.xuanbang.me.piepxe.di.module;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;

import dagger.Module;
import dagger.Provides;


@Module
public class AndroidModule {

    @Provides
    AudioManager provideAudioManager(Application application) {
        return (AudioManager) application.getSystemService(Context.AUDIO_SERVICE);
    }

    @Provides
    SensorManager provideSensorManager(Application application) {
        return (SensorManager) application.getSystemService(Context.SENSOR_SERVICE);
    }

    @Provides
    Sensor provideSensor(SensorManager sensorManager) {
        return sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Provides
    ConnectivityManager provideConnectivityManager(Application application) {
        return (ConnectivityManager) application.getSystemService(Context.CONNECTIVITY_SERVICE);
    }


    @Provides
    Resources provideAppResource(Application application) {
        return application.getResources();
    }

}
