package com.xuanbang.me.piepxe.common.base.observe;
/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.xuanbang.me.piepxe.Resource;

import androidx.lifecycle.MutableLiveData;
import io.reactivex.observers.DisposableObserver;

/**
 * Default {@link DisposableObserver} base class to be used whenever you want default error handling.
 */
public class DefaultObserve<T> extends DisposableObserver<T> {

    private MutableLiveData<Resource<T>> results;

    public DefaultObserve(MutableLiveData<Resource<T>> results) {
        this.results = results;
    }

    @Override
    protected void onStart() {
        results.setValue(Resource.loading(null));
    }

    @Override
    public void onNext(T t) {
        results.setValue(Resource.success(t));
    }

    @Override
    public void onError(Throwable e) {
        results.setValue(Resource.error(e.getMessage(), null));
    }

    @Override
    public void onComplete() {

    }
}
