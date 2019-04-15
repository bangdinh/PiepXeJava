package com.xuanbang.me.piepxe.ui.started.viewmodels;

import android.app.Application;
import android.util.Log;
import android.view.View;

import com.xuanbang.me.domain.entity.UserEntity;
import com.xuanbang.me.domain.interactor.GetUserCore;
import com.xuanbang.me.piepxe.Resource;
import com.xuanbang.me.piepxe.common.base.views.BaseViewModel;
import com.xuanbang.me.piepxe.mapper.UserModelDataMapper;
import com.xuanbang.me.piepxe.model.UserModel;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.subscribers.DisposableSubscriber;

public class NullMainActivityViewModel extends BaseViewModel {

    private final static String TAG = NullMainActivityViewModel.class.getSimpleName();
    private MutableLiveData<Resource<UserModel>> results;
    private final GetUserCore mGetUserCore;
    private final UserModelDataMapper mDataMapper;
    private LiveData<Resource<String>> mResourceLiveData;


    @Inject
    public NullMainActivityViewModel(@NonNull Application application, GetUserCore getUserCore, UserModelDataMapper dataMapper) {
        super(application);
        mGetUserCore = getUserCore;
        mDataMapper = dataMapper;
    }


    public MutableLiveData<Resource<UserModel>> getResultsUser() {
        if (results != null) {
            return results;
        }
        results = new MutableLiveData<>();
        mGetUserCore.execute(new GetUserLogin(), null);
        return results;
    }

    public LiveData<Resource<String>> getResourceLiveData() {
        if (mResourceLiveData != null) {
            return mResourceLiveData;
        }
        mResourceLiveData = new MutableLiveData<>();
        mGetUserCore.execute(new GetUserIdLogin());
        return mResourceLiveData;
    }


    private final class GetUserLogin extends DisposableSubscriber<UserEntity> {

        @Override
        protected void onStart() {
            super.onStart();
            Log.e(TAG, "onStart");
            results.setValue(Resource.loading(null));
        }

        @Override
        public void onNext(UserEntity userEntity) {
            Log.e(TAG, "onNext");
            results.setValue(Resource.success(mDataMapper.transform(userEntity)));
        }

        @Override
        public void onError(Throwable t) {
            results.setValue(Resource.error(t.getMessage(), null));
        }

        @Override
        public void onComplete() {
            Log.e(TAG, "onComplete");
        }
    }

    private final class GetUserIdLogin extends DisposableSingleObserver<String> {

        @Override
        public void onSuccess(String s) {
            Log.e(TAG, "GetUserIdLogin - " + s);
        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, "GetUserIdLogin - " + e.toString());
        }
    }

    public void removeUserLocal(View view) {
//        Toast.makeText(view.getContext(), "Remove Oki", Toast.LENGTH_SHORT).show();
        Log.e(TAG, "Click");
    }


    public void detach() {
        this.onCleared();
        this.mGetUserCore.dispose();
    }
}
