package com.mine.zhuo.learnandroid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.DrawableRes;
import android.util.Log;

/**
 * Created by Administrator on 2018/11/27.
 */

public class BitmapUtils {


    public static Bitmap getBitmap(Context context, @DrawableRes int resId, int requestWidth, int
            requestHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(context.getResources(), resId, options);
        options.inSampleSize = calculateSimpleSize(options, requestWidth, requestHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(context.getResources(), resId, options);
    }

    public static int calculateSimpleSize(BitmapFactory.Options options, int width, int height) {
        int simpleSize = 1;

        int outWidth = options.outWidth;
        int outHeight = options.outHeight;



        if (outHeight > height || outWidth > width) {
            while (outHeight / simpleSize > height && outWidth / simpleSize > width) {
                simpleSize *= 2;
            }
        }
        Log.e("asker","outWidth = "+outWidth+"    outHeight = "+outHeight);
        Log.e("asker","simpleSize = "+simpleSize);

        return simpleSize;

    }


}
