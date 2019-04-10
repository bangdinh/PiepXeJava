package com.xuanbang.me.piepxe.ui.nulls.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.xuanbang.me.piepxe.R;
import com.xuanbang.me.piepxe.common.base.views.BaseActivityMVVM;
import com.xuanbang.me.piepxe.databinding.ActivityNullMainBinding;
import com.xuanbang.me.piepxe.ui.nulls.viewmodels.NullMainActivityViewModel;

import org.reactivestreams.Subscription;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class NullMainActivity extends BaseActivityMVVM<ActivityNullMainBinding, NullMainActivityViewModel> {

    final static String TAG = NullMainActivity.class.getSimpleName();

    @Override
    public int getLayoutId() {
        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(NullMainActivityViewModel.class);
        return R.layout.activity_null_main;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        doSomeWork();

        mViewDataBinding.setViewmodelNull(mViewModel);
        configureScreenFetchData();

    }

    private void configureScreenFetchData() {
        mViewModel.getResultsUser().observe(this, userModelResource -> {
            Log.e(TAG, userModelResource.toString());

            mViewDataBinding.setResource(userModelResource);
            mViewDataBinding.executePendingBindings();

//            if (userModelResource.data != null && userModelResource.status == Status.SUCCESS) {
//                Intent intent = new Intent(NullMainActivity.this, MainActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
//                startActivityForResult(intent, 100);
//                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
//            } else {
//                Intent intent = new Intent(NullMainActivity.this, LoginAccountActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
//                startActivityForResult(intent, 101);
//                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
//            }


        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e(TAG, "---- " + requestCode);
        if (requestCode == 100) {
            mViewModel.detach();
            finish();
        } else if (requestCode == 101) {
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        Log.e(TAG, "onBackPressed() " + isTaskRoot());


//        moveTaskToBack(true);
        super.onBackPressed();
    }


    //
    private SingleObserver<Integer> getSingleObserver() {
        return new SingleObserver<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "onSubscribe(): " + d.isDisposed());
            }

            @Override
            public void onSuccess(Integer integer) {
                Log.e(TAG, "onSuccess(): " + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError(): " + e.toString());
            }
        };
    }

    private Observer<Integer> getObserver() {
        return new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "onSubscribe(): " + d.isDisposed());
            }

            @Override
            public void onNext(Integer integer) {
                Log.e(TAG, "onNext(): " + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError(): " + e.toString());
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete(): ");
            }
        };
    }


    private MaybeObserver<Integer> getMaybeObserver(){
        return new MaybeObserver<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG,"onSubscribe(): "+d.isDisposed());
            }

            @Override
            public void onSuccess(Integer integer) {
                Log.e(TAG,"onSuccess() "+integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG,"onError() "+e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.e(TAG,"onComplete()");
            }
        };
    }

    private FlowableSubscriber<Integer> getFlowableSubscriber(){
        return new FlowableSubscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                Log.e(TAG,"onSubscribe() "+s);
            }

            @Override
            public void onNext(Integer integer) {
                Log.e(TAG,"onNext() "+integer);
            }

            @Override
            public void onError(Throwable t) {
                Log.e(TAG,"onError() "+t.getMessage());
            }

            @Override
            public void onComplete() {
                Log.e(TAG,"onComplete()");
            }
        };
    }
    private void doSomeWork() {
        Flowable<Integer> observable = Flowable.just(1, 2, 3, 4, 5);

//        observable.reduce((integer, integer2) -> {
//            Log.e(TAG, "apply: >> integer: " + integer + " --- integer2: " + integer2);
//            return integer + integer2;
//        }).subscribe(getMaybeObserver());

    }
}
