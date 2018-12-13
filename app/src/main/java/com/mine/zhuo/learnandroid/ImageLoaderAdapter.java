package com.mine.zhuo.learnandroid;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mine.zhuo.learnandroid.imageloader.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2018/11/27.
 */

public class ImageLoaderAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    private Context context;
    public ImageLoaderAdapter(@Nullable List<String> data, Context context) {
        super(R.layout.item_recycler,data);
        this.context = context;

    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

        ImageView imageView = helper.getView(R.id.imageView);
        ImageLoader.build(context).bindBitmap(item,imageView,200,200);

    }
}
