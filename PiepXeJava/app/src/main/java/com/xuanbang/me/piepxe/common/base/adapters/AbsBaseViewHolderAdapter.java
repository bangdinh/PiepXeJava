package com.xuanbang.me.piepxe.common.base.adapters;

import android.content.Context;
import android.view.View;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class AbsBaseViewHolderAdapter<I> extends RecyclerView.ViewHolder {
    public AbsBaseViewHolderAdapter(@NonNull View itemView) {
        super(itemView);
    }

    public abstract void bind(List<I> data);

    public abstract void bind(I data);

    protected Context getContext() {
        return itemView.getContext();
    }
}
