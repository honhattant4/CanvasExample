package com.neolab.canvasexample.path;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Copyright © 2016 AsianTech Inc.
 * Created by TanHN on 8/10/16.
 */
public class CropActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(new FreeCropView(CropActivity.this));
    }
}
