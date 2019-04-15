package com.xuanbang.me.piepxe.common.base.views.core;

import android.app.Activity;
import android.content.Context;

import com.xuanbang.me.piepxe.common.base.views.modules.BaseFragmentModule;

import javax.inject.Inject;
import javax.inject.Named;

import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
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


//    @Inject
//    protected AppCompatActivity activity;

    @Override
    public void onDetach() {
        super.onDetach();
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

