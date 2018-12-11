package com.mine.zhuo.learnandroid.imageloader;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.DrawableRes;

import java.io.FileDescriptor;

/**
 * Created by Administrator on 2018/12/11.
 */

public class ImageResizer {

    private static final String TAG = "ImageResizer";

    public ImageResizer() {

    }

    public Bitmap decodeSampleBitmapFromResource(Resources resources, @DrawableRes int
            drawableId, int requestWidth, int requestHeigjt) {

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, drawableId, options);
        options.inSampleSize = caculateSampleSize(options, requestWidth, requestHeigjt);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, drawableId, options);

    }

    public Bitmap decodeSampleBitmapFromFileDescriptor(FileDescriptor descriptor, int requestWidth, int requestHeigjt) {

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(descriptor, null, options);
        options.inSampleSize = caculateSampleSize(options, requestWidth, requestHeigjt);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFileDescriptor(descriptor, null, options);

    }


    public int caculateSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        if (reqHeight == 0 || reqWidth == 0) {
            return 0;
        }

        int w = options.outWidth;
        int h = options.outHeight;

        int sampleSize = 1;

        while (w / reqWidth > sampleSize && h / reqHeight > sampleSize) {
            sampleSize *= 2;
        }

        return sampleSize;


    }


}
