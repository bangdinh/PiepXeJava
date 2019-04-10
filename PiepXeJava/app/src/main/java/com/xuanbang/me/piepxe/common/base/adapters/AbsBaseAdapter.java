package com.xuanbang.me.piepxe.common.base.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xuanbang.me.util.Checker;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class AbsBaseAdapter<I, VH extends AbsBaseViewHolderAdapter<I>> extends RecyclerView.Adapter<VH> {

    protected List<I> mListData;

    public abstract int getLayoutId();

    public abstract VH getViewHolder(View view);

    protected boolean isBindList() {
        return false;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(getLayoutId(), parent, false);
        return getViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        if (!Checker.isEmpty(this.mListData)) {
            if (isBindList()) {
                holder.bind(mListData);
            } else {
                I item = mListData.get(position);
                if (item != null) {
                    holder.bind(item);
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return mListData != null ? mListData.size() : 0;
    }
}
