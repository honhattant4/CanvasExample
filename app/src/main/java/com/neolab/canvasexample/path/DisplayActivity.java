package com.neolab.canvasexample.path;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.neolab.canvasexample.R;

/**
 * Copyright © 2016 AsianTech Inc.
 * Created by TanHN on 8/10/16.
 */
public class DisplayActivity extends AppCompatActivity {
    ImageView mCompositeImageView;
    boolean mIsCrop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            mIsCrop = extras.getBoolean("crop");
        }


        mCompositeImageView = (ImageView) findViewById(R.id.our_imageview);

        Bitmap bitmapIn = BitmapFactory.decodeResource(getResources(),
                R.drawable.bg_test);

        Bitmap bitmapCropped = Bitmap.createBitmap(bitmapIn.getWidth(),
                bitmapIn.getHeight(), bitmapIn.getConfig());

        Canvas canvas = new Canvas(bitmapCropped);
        Paint paint = new Paint();
        paint.setAntiAlias(true);

        Path path = new Path();
        for (int i = 0; i < FreeCropView.mPoints.size(); i++) {
            path.lineTo(FreeCropView.mPoints.get(i).x, FreeCropView.mPoints.get(i).y);
        }
        canvas.drawPath(path, paint);
        if (mIsCrop) {
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        } else {
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
        }
        canvas.drawBitmap(bitmapIn, 0, 0, paint);
        mCompositeImageView.setImageBitmap(bitmapCropped);
    }
}

