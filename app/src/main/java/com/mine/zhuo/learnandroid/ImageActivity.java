package com.mine.zhuo.learnandroid;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.mine.zhuo.learnandroid.imageloader.BitmapUtils;

/**
 *
 * @author Administrator
 * @date 2018/11/27
 */

public class ImageActivity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_image);

        ImageView imageView = findViewById(R.id.imageView1);
        ImageView imageView2 = findViewById(R.id.imageView2);

        imageView.setImageBitmap(BitmapUtils.getBitmap(getApplicationContext(),R.mipmap.image1,100,100));
//        imageView2.setImageBitmap(BitmapUtils.getBitmap(getApplicationContext(),R.mipmap.image2,50,100));
    }
}
