package com.neolab.canvasexample.matrix;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.neolab.canvasexample.R;

/**
 * Copyright © 2016 AsianTech Inc.
 * Created by TanHN on 8/10/16.
 */
public class MatrixActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TouchImageView touchImageView=new TouchImageView(this);
        touchImageView.setImageResource(R.drawable.bg_test);
        setContentView(touchImageView);

    }

}
