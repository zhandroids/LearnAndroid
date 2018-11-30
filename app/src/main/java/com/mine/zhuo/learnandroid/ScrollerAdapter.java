package com.mine.zhuo.learnandroid;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2018/11/27.
 */

public class ScrollerAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public ScrollerAdapter(@Nullable List<String> data) {
        super(R.layout.item_recycler,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
