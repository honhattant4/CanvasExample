package com.neolab.canvasexample.path;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import com.neolab.canvasexample.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © 2016 AsianTech Inc.
 * Created by TanHN on 8/10/16.
 */
public class FreeCropView extends View implements OnTouchListener {
    private Paint mPaint;
    public static List<Point> mPoints;
    final int DIST = 2;
    boolean mFlagPathDraw = true;
    private Point mFirstPoint = null;
    boolean mIsFirstPoint = false;
    private Point mLastPoint = null;
    private Bitmap mBitmap = BitmapFactory.decodeResource(getResources(),
            R.drawable.bg_test);
    private Context mContext;
    private static final String TAG=FreeCropView.class.getSimpleName();

    public FreeCropView(Context c) {
        super(c);

        mContext = c;
        setFocusable(true);
        setFocusableInTouchMode(true);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setPathEffect(new DashPathEffect(new float[] { 10, 20 }, 0));
        mPaint.setStrokeWidth(5);
        mPaint.setColor(Color.WHITE);

        this.setOnTouchListener(this);
        mPoints = new ArrayList<Point>();

        mIsFirstPoint = false;
    }

    public FreeCropView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        setFocusable(true);
        setFocusableInTouchMode(true);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
        mPaint.setColor(Color.WHITE);

        this.setOnTouchListener(this);
        mPoints = new ArrayList<Point>();
        mIsFirstPoint = false;

    }

    public void onDraw(Canvas canvas) {
        canvas.drawBitmap(mBitmap, 0, 0, null);

        Path path = new Path();
        boolean first = true;

        for (int i = 0; i < mPoints.size(); i += 2) {
            Point point = mPoints.get(i);
            if (first) {
                first = false;
                path.moveTo(point.x, point.y);
            } else if (i < mPoints.size() - 1) {
                Point next = mPoints.get(i + 1);
                path.quadTo(point.x, point.y, next.x, next.y);
            } else {
                mLastPoint = mPoints.get(i);
                path.lineTo(point.x, point.y);
            }
        }
        canvas.drawPath(path, mPaint);
    }

    @SuppressLint("LongLogTag")
    public boolean onTouch(View view, MotionEvent event) {
        // if(event.getAction() != MotionEvent.ACTION_DOWN)
        // return super.onTouchEvent(event);

        Point point = new Point();
        point.x = (int) event.getX();
        point.y = (int) event.getY();

        if (mFlagPathDraw) {

            if (mIsFirstPoint) {

                if (comparepoint(mFirstPoint, point)) {
                    // mPoints.add(point);
                    mPoints.add(mFirstPoint);
                    mFlagPathDraw = false;
                    showcropdialog();
                } else {
                    mPoints.add(point);
                }
            } else {
                mPoints.add(point);
            }

            if (!(mIsFirstPoint)) {

                mFirstPoint = point;
                mIsFirstPoint = true;
            }
        }

        invalidate();
        Log.e(TAG, "Size: " + point.x + " " + point.y);

        if (event.getAction() == MotionEvent.ACTION_UP) {
            Log.d(TAG, "called");
            mLastPoint = point;
            if (mFlagPathDraw) {
                if (mPoints.size() > 12) {
                    if (!comparepoint(mFirstPoint, mLastPoint)) {
                        mFlagPathDraw = false;
                        mPoints.add(mFirstPoint);
                        showcropdialog();
                    }
                }
            }
        }

        return true;
    }

    private boolean comparepoint(Point first, Point current) {
        int left_range_x = (int) (current.x - 3);
        int left_range_y = (int) (current.y - 3);

        int right_range_x = (int) (current.x + 3);
        int right_range_y = (int) (current.y + 3);

        if ((left_range_x < first.x && first.x < right_range_x)
                && (left_range_y < first.y && first.y < right_range_y)) {
            if (mPoints.size() < 10) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    public void fillInPartOfPath() {
        Point point = new Point();
        point.x = mPoints.get(0).x;
        point.y = mPoints.get(0).y;

        mPoints.add(point);
        invalidate();
    }

    public void resetView() {
        mPoints.clear();
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Style.STROKE);
        mFlagPathDraw = true;
        invalidate();
    }

    private void showcropdialog() {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent;
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        // Yes button clicked
                        // mIsFirstPoint = false;

                        intent = new Intent(mContext, DisplayActivity.class);
                        intent.putExtra("mIsCrop", true);
                        mContext.startActivity(intent);
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        // No button clicked

                        intent = new Intent(mContext, DisplayActivity.class);
                        intent.putExtra("mIsCrop", false);
                        mContext.startActivity(intent);

                        mIsFirstPoint = false;
                        // resetView();

                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setMessage("Do you Want to save Crop or Non-Crop image?")
                .setPositiveButton("Crop", dialogClickListener)
                .setNegativeButton("Non-Crop", dialogClickListener).show()
                .setCancelable(false);
    }

}