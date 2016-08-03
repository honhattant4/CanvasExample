package com.neolab.canvasexample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Copyright © 2016 AsianTech Inc.
 * Created by TanHN on 8/1/16.
 */
public class CanvasView extends View {
    private TypeDraw mTypeDraw=TypeDraw.ARC;
    Paint mPaint;
    public CanvasView(Context context) {
        super(context);
        mPaint = new Paint();
        mPaint.setTextSize(30);
        mPaint.setColor(Color.RED);
    }

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
    }

    public CanvasView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
    }

    public void changeTypeDraw(TypeDraw typeDraw) {
        this.mTypeDraw = typeDraw;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        switch (mTypeDraw) {
            case RGB:
                drawRGB(canvas);
                break;
            case ARGB:
                drawARGB(canvas);
                break;
            case COLOR:
                drawColor(canvas);
                break;
            case PAINT:
                drawPaint(canvas);
                break;
            case POINT:
                drawPoint(canvas);
                break;
            case LINE:
                drawLine(canvas);
                break;
            case RECT:
                drawRect(canvas);
                break;
            case OVAL:
                drawOval(canvas);
                break;
            case CIRCLE:
                drawCircle(canvas);
                break;
            case ARC:
                drawArc(canvas);
                break;
            case ROUND_RECT:
                drawRoundRect(canvas);
                break;
            case PATH:
                drawPath(canvas);
                break;
            case BITMAP:
                drawBitmap(canvas);
                break;
            case BITMAP_MESH:
                drawBitmapMesh(canvas);
                break;
            case VERTICES:
                drawVertices(canvas);
                break;
            case TEXT_RUN:
                drawTextRun(canvas);
                break;
            case POST_TEST:
                drawPosText(canvas);
                break;
            case TEXT_ON_PATH:
                drawTextOnPath(canvas);
                break;
            case PICTURE:
                drawPicture(canvas);
                break;
            default:
                break;

        }
    }

    private void drawRGB(Canvas canvas) {

    }

    private void drawARGB(Canvas canvas) {

    }

    private void drawColor(Canvas canvas) {

    }

    private void drawPaint(Canvas canvas) {

    }

    private void drawPoint(Canvas canvas) {

    }

    private void drawLine(Canvas canvas) {

    }

    private void drawRect(Canvas canvas) {

    }

    private void drawOval(Canvas canvas) {

    }

    private void drawCircle(Canvas canvas) {

    }

    private void drawArc(Canvas canvas) {

    }

    private void drawRoundRect(Canvas canvas) {

    }

    private void drawPath(Canvas canvas) {

    }

    private void drawBitmap(Canvas canvas) {

    }

    private void drawBitmapMesh(Canvas canvas) {

    }

    private void drawVertices(Canvas canvas) {

    }

    private void drawTextRun(Canvas canvas) {

    }

    private void drawPosText(Canvas canvas) {

    }

    private void drawTextOnPath(Canvas canvas) {

    }

    private void drawPicture(Canvas canvas) {

    }

    private void drawText(Canvas canvas) {
        canvas.drawText("Ahihi", 0, 0, mPaint);
        canvas.drawText("Ahihi", 100, 100, mPaint);
        canvas.drawLine(0, 0, 100, 100, mPaint);
        canvas.drawColor(Color.BLACK);
    }

    public enum TypeDraw {
        RGB,
        ARGB,
        COLOR,
        PAINT,
        POINT,
        LINE,
        RECT,
        OVAL,
        CIRCLE,
        ARC,
        ROUND_RECT,
        PATH,
        BITMAP,
        BITMAP_MESH,
        VERTICES,
        TEXT_RUN,
        POST_TEST,
        TEXT_ON_PATH,
        PICTURE
    }


}
