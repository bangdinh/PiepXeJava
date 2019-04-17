package com.xuanbang.me.piepxe.common.binding;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.textfield.TextInputEditText;

import javax.inject.Inject;

import androidx.databinding.BindingConversion;
import dagger.Reusable;

/**
 * Created by garimajain on 16/08/17.
 */
@Reusable
public class BindingAdapter {

    private final RequestManager requestManager;

    @Inject
    public BindingAdapter(RequestManager requestManager) {
        this.requestManager = requestManager;
    }

    /**
     * Reference : https://medium.com/fueled-android/data-binding-adapter-write-bind-repeat-50e9c64fe806
     * Bind Glide with an ImageView.
     *
     * @param view        the ImageView to bind to Glide.
     * @param src         The URL of the image to load.
     * @param placeholder The placeholder icon.
     * @param error       The error icon.
     * @param blurValue   The blur radius value between 1 and 25.
     * @param cropCircle  Crop the image in a circle of not.
     */
    @SuppressLint("CheckResult")
    @SuppressWarnings("unchecked")
    @androidx.databinding.BindingAdapter(value = {"src", "placeholder", "error", "blur", "cropCircle"},
            requireAll = false)
    public void setImageUrl(ImageView view, String src, Drawable placeholder, Drawable error,
                            int blurValue, boolean cropCircle) {


        RequestOptions options = new RequestOptions();

        RequestBuilder<Drawable> glideBuilder = requestManager.load(src);


        if (placeholder != null) {
            options.placeholder(placeholder);
        }

        if (error != null) {
            options.error(error);
        }

        if (blurValue > 0) {
//            options.transform(new BlurTransformation(blurValue));
        }

        if (cropCircle) {
            options.circleCrop();
        }

        glideBuilder
                .apply(options)
                .into(view);
    }

    @androidx.databinding.BindingAdapter(value = {"formatString", "variable"})
    public void formatString(TextView textView, String stringFormat, String variable) {
        textView.setText(String.format(stringFormat, variable));
    }

    @androidx.databinding.BindingAdapter(value = {"formatInt", "variable"})
    public void formatInt(TextView textView, String stringFormat, int variable) {
        textView.setText(String.format(stringFormat, variable));
    }

    /**
     * android:visibility="@{false}"
     */
    @BindingConversion
    public static int convertBooleanToVisibility(boolean visible) {
        return visible ? View.VISIBLE : View.GONE;
    }

    @androidx.databinding.BindingAdapter("hideKeyboardOnInputDone")
    public void hideKeyboardOnInputDone(TextInputEditText view, Boolean enabled) {
        Log.e("Action: ", ">>> " + enabled);
        if (!enabled) {
            return;
        }
        try {
            final TextView.OnEditorActionListener actionListener = (v, actionId, event) -> {
                Log.e("Action: ", ">>> " + actionId);
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    view.clearFocus();
                    InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
                return false;
            };

            view.setOnEditorActionListener(actionListener);
        } catch (Exception ex) {
            Log.e("hideKeyboardOnInputDone: ", ">> Error");
        }

    }

}
