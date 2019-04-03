package com.xuanbang.me.piepxe.di.module;

import com.xuanbang.me.piepxe.di.key.ViewModelKey;
import com.xuanbang.me.piepxe.ui.main.viewmodels.MainActivityViewModel;
import com.xuanbang.me.piepxe.ui.main.viewmodels.MainFragmentViewModel;
import com.xuanbang.me.piepxe.di.BaseModelFactory;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel.class)
    abstract ViewModel bindMainActivityViewModel(MainActivityViewModel repoViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(MainFragmentViewModel.class)
    abstract ViewModel bindMainFragmentViewModel(MainFragmentViewModel repoViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(BaseModelFactory factory);
}
