package com.xuanbang.me.piepxe.common.binding;

import android.os.Build;
import android.widget.ScrollView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;
import dagger.Reusable;

@Reusable
public class ScrollViewBindingAdapters {

    @InverseBindingAdapter(attribute = "scrollY")
    public static int getScrollY(ScrollView scrollView) {
        return scrollView.getScrollY();
    }


    @BindingAdapter(value = {"scrollListener", "scrollYAttrChanged"}, requireAll = false)
    public static void setScrollListeners(ScrollView scrollView,
                                          ScrollView.OnScrollChangeListener scrollListener,
                                          InverseBindingListener inverseBindingListener) {

        ScrollView.OnScrollChangeListener newListener;

        if (inverseBindingListener == null) {
            newListener = scrollListener;
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                newListener = (v, scrollX, scrollY, oldX, oldY) -> {
                    if (scrollListener != null) {
                        scrollListener.onScrollChange(v, scrollX, scrollY, oldX, oldY);
                    }
                    inverseBindingListener.onChange();
                };
                scrollView.setOnScrollChangeListener(newListener);
            }

        }

    }
}
