package com.example.shopall.darl;

import androidx.recyclerview.widget.DiffUtil;

import com.example.shopall.darl.HomeModel;

import java.util.List;

public class HomeDiffCallback extends DiffUtil.Callback {
    private final List<HomeModel> oldList;
    private final List<HomeModel> newList;

    public HomeDiffCallback(List<HomeModel> oldList, List<HomeModel> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getId()
                .equals(newList.get(newItemPosition).getId());
    }


    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
    }
}
