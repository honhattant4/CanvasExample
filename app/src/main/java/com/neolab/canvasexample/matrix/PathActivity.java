package com.neolab.canvasexample.matrix;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Copyright © 2016 AsianTech Inc.
 * Created by TanHN on 8/10/16.
 */
public class PathActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    class PathView extends View{

        public PathView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
        }
    }
}
