package com.xuanbang.me.piepxe.ui.main.viewmodels;

import android.app.Application;
import android.util.Log;

import com.xuanbang.me.domain.entity.UserEntity;
import com.xuanbang.me.domain.interactor.GetUserUseCase;
import com.xuanbang.me.piepxe.Resource;
import com.xuanbang.me.piepxe.application.PiepXeApp;
import com.xuanbang.me.piepxe.common.base.views.BaseViewModel;
import com.xuanbang.me.piepxe.mapper.UserModelDataMapper;
import com.xuanbang.me.piepxe.model.UserModel;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.subscribers.DisposableSubscriber;


public class MainActivityViewModel extends BaseViewModel {
    private final static String TAG = MainActivityViewModel.class.getSimpleName();
    private MutableLiveData<Resource<UserModel>> results;
    private final GetUserUseCase getUserUseCase;
    private final UserModelDataMapper dataMapper;

    @Inject
    public MainActivityViewModel(@NonNull Application application, GetUserUseCase userUseCase, UserModelDataMapper dataMapper) {
        super(application);
        PiepXeApp app = (PiepXeApp) application;
        Log.e(TAG,"current: "+app.getCurrentTaskId());
        this.getUserUseCase = userUseCase;
        this.dataMapper = dataMapper;
    }

    public MutableLiveData<Resource<UserModel>> getResults(String idUser) {
        if (results != null) {
            // TODO: 2017/11/16 Memory Cache
            return results;
        } else {
            results = new MutableLiveData<>();
        }
        getUserUseCase.execute(new GetUserGithub(), idUser);

        return results;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        getUserUseCase.dispose();
    }

    private final class GetUserGithub extends DisposableSubscriber<UserEntity> {
        @Override
        protected void onStart() {
            super.onStart();
            results.setValue(Resource.loading(null));

        }

        @Override
        public void onNext(UserEntity userEntity) {
            results.setValue(Resource.success(dataMapper.transform(userEntity)));
        }

        @Override
        public void onError(Throwable t) {
            results.setValue(Resource.error(t.getMessage(), null));
        }

        @Override
        public void onComplete() {

        }
    }
}
