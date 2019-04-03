package com.xuanbang.me.piepxe.common.base.views.core;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.xuanbang.me.piepxe.common.base.views.modules.BaseFragmentModule;

import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerFragment;

/**
 * Abstract Fragment for all Fragments and child Fragments to extend. This contains some boilerplate
 * dependency injection code and activity {@link Context}.
 * <p>
 * <b>DEPENDENCY INJECTION</b>
 * We could extend {@link dagger.android.support.DaggerFragment} so we can get the boilerplate
 * dagger code for free. However, we want to avoid inheritance (if possible and it is in this case)
 * so that we have to option to inherit from something else later on if needed.
 * <p>
 * <b>VIEW BINDING</b>
 * This fragment handles view bind and unbinding.
 */
public abstract class BaseFragment extends DaggerFragment {

    private Unbinder unbinder;

    protected abstract void detach();

    /**
     * A reference to the activity Context is injected and used instead of the getter method. This
     * enables ease of mocking and verification in tests (in case Activity needs testing).
     * More importantly, the getter method (getContext()) is not available for API level below 23.
     * We could use getActivity() though since that is available since API 11. However, exposing the
     * Activity reference is less safe than just exposing the Context since a lot more can be done
     * with the Activity reference.
     * <p>
     * For more details, see https://github.com/vestrel00/android-dagger-butterknife-mvp/pull/52
     */
//    @Inject
//    protected Context activityContext;

    /**
     * A reference to the FragmentManager is injected and used instead of the getter method. This
     * enables ease of mocking and verification in tests (in case Fragment needs testing).
     * <p>
     * For more details, see https://github.com/vestrel00/android-dagger-butterknife-mvp/pull/52
     */
    // Note that this should not be used within a child fragment.
    @Inject
    @Named(BaseFragmentModule.CHILD_FRAGMENT_MANAGER)
    protected FragmentManager childFragmentManager;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, getView());
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    /**
     * The onViewStateRestored(Bundle) lifecycle method is only available beginning with API level 17.
     * Supporting API levels below 17 down to 14 requires the use of AppCompatActivity, support Fragment,
     * and dagger.android.support APIs.
     *
     * @param savedInstanceState
     */
    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        // Null check on getView() is not needed since onViewStateRestored() only gets called
        // when the View returned in onCreateView() is not null.

        /*
         * Bind the views here instead of in onViewCreated so that view state changed listeners
         * are not invoked automatically without user interaction.
         *
         * If we bind before this method (e.g. onViewCreated), then any checked changed
         * listeners bound by ButterKnife will be invoked during fragment recreation (since
         * Android itself saves and restores the views' states.
         *
         * The lifecycle order is as follows (same if added via xml or java or if retain
         * instance is true):
         *
         * onAttach
         * onCreateView
         * onViewCreated
         * onActivityCreated
         * onViewStateRestored
         * onResume
         */
        unbinder = ButterKnife.bind(this, Objects.requireNonNull(getView()));
    }


    @Override
    public void onDestroy() {
        // This lifecycle method still gets called even if onCreateView returns a null view.
        if (unbinder != null) {
            unbinder.unbind();
        }
        super.onDestroy();
        detach();
    }


    protected void addChildFragment(@IdRes int containerViewId, Fragment fragment) {
        childFragmentManager
                .beginTransaction()
                .add(containerViewId, fragment)
                .commit();
    }

    protected final void replaceChildFragment(@IdRes int containerViewId, Fragment fragment) {
        childFragmentManager
                .beginTransaction()
                .replace(containerViewId, fragment)
                .commit();
    }

    protected final void removeChildFragment(Fragment fragment) {
        childFragmentManager.beginTransaction().remove(fragment).commitNowAllowingStateLoss();
    }

    protected Activity getThis() {
        return getActivity();
    }

    protected final void addFragment(@IdRes int containerViewId, Fragment fragment) {
        if (getThis() instanceof BaseActivity) {
            ((BaseActivity) getThis()).addFragment(containerViewId, fragment);
        }
    }
}

