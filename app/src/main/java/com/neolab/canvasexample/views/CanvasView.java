package com.neolab.canvasexample.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.neolab.canvasexample.R;

/**
 * Copyright © 2016 AsianTech Inc.
 * Created by TanHN on 8/1/16.
 */
public class CanvasView extends View {
    private TypeDraw mTypeDraw = TypeDraw.RGB;
    Paint mPaint;
    private static final String TAG = CanvasView.class.getSimpleName();
    public CanvasView(Context context) {
        super(context);
        initPaint();

    }

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public CanvasView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setTextSize(30);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(5);
    }

    public void changeTypeDraw(TypeDraw typeDraw) {
        this.mTypeDraw = typeDraw;
        invalidate(); //UI
//       postInvalidate();//NonUi
    }

    public TypeDraw getTypeDraw() {
        return mTypeDraw;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0, 0, 0, canvas.getHeight(), mPaint);
        canvas.drawLine(0, 0, canvas.getWidth(), 0, mPaint);
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
            case TEXT:
                drawText(canvas);
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
            case TRANSLATE:
                drawBitmap(canvas);
                canvas.translate(500, 500);
                drawBitmap(canvas);
                break;
            case SCALE:
                drawBitmap(canvas);
                canvas.scale(2, 2);
                //   canvas.translate(200, 200);
                drawBitmap(canvas);
                break;
            case ROTATE:
                drawBitmap(canvas);
                canvas.rotate(10);
                drawBitmap(canvas);
                break;
            case SKEW:
                drawBitmap(canvas);
                canvas.skew(0.5f, 0.5f);
                drawBitmap(canvas);
                break;
            case SAVE_RESTORE:
                saveAndRestore(canvas);
                break;
            case SAVELAYER:
                saveLayer(canvas);
                break;

            default:
                break;

        }
    }

    private void drawRGB(Canvas canvas) {
        canvas.drawRGB(0, 0, 0);
    }

    private void drawARGB(Canvas canvas) {
        canvas.drawARGB(100, 0, 0, 0);
    }

    private void drawColor(Canvas canvas) {
        canvas.drawColor(Color.BLUE);
    }

    private void drawPaint(Canvas canvas) {
        mPaint.setColor(Color.CYAN);
        canvas.drawPaint(mPaint);

    }

    private void drawPoint(Canvas canvas) {
        canvas.drawPoint(0, 0, mPaint);
        canvas.drawPoint(10, 10, mPaint);
        canvas.drawPoint(20, 20, mPaint);
        canvas.drawPoint(canvas.getHeight() / 2, canvas.getHeight() / 2, mPaint);
    }

    private void drawLine(Canvas canvas) {
        canvas.drawLine(0, 0, canvas.getWidth(), canvas.getHeight(), mPaint);
        canvas.drawLine(canvas.getWidth(), 0, 0, canvas.getHeight(), mPaint);
    }

    private void drawRect(Canvas canvas) {
        mPaint.setStrokeWidth(1);
        Rect rect = new Rect(0, 0, 500, 500);
        canvas.drawRect(rect, mPaint);
        mPaint.setColor(Color.BLACK);
        canvas.drawPoint(rect.centerX(), rect.centerY(), mPaint);
        canvas.drawPoint(rect.left, rect.top, mPaint);
        canvas.drawPoint(rect.right, rect.top, mPaint);
        canvas.drawPoint(rect.left, rect.bottom, mPaint);
        canvas.drawPoint(rect.right, rect.bottom, mPaint);
        Rect rect2 = new Rect(0, 0, 400, 400);
        mPaint.setColor(Color.WHITE);
        canvas.drawRect(rect2, mPaint);
        Log.d(TAG, "" + rect.contains(rect2));
    }

    private void drawOval(Canvas canvas) {
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Do something for Lollipop and above versions
            canvas.drawOval(0, 0, 100, 300, mPaint);
        } else {
            // do something for phones running an SDK before Lollipop
            RectF mRectF = new RectF(0, 0, 100, 300);
            canvas.drawOval(mRectF, mPaint);
        }
    }

    private void drawCircle(Canvas canvas) {
        canvas.drawCircle(canvas.getWidth() / 2, canvas.getHeight() / 2, 100, mPaint);
    }

    private void drawArc(Canvas canvas) {
        mPaint.setColor(Color.RED);
        RectF rectF = new RectF(0, 0, 500, 500);
        //     canvas.drawOval(rectF, mPaint);
        mPaint.setColor(Color.YELLOW);
        canvas.drawArc(rectF, 90, 300, true, mPaint);
        mPaint.setColor(Color.BLUE);
        canvas.drawCircle(rectF.centerX(), rectF.centerY() / 2, 30, mPaint);
//        mPaint.setColor(Color.WHITE);
//        canvas.drawArc (rectF, 0, 185, false, mPaint);
//        mPaint.setColor(Color.WHITE);
//        canvas.drawArc (rectF, 90, 45, true, mPaint);
//        mPaint.setColor(Color.BLUE);
//        canvas.drawArc (rectF, 180, 90, true, mPaint);
    }

    private void drawRoundRect(Canvas canvas) {
        RectF rectF = new RectF(0, 0, 500, 500);
        canvas.drawRoundRect(rectF, 200, 200, mPaint);

    }

    private void drawPath(Canvas canvas) {
        mPaint.setStyle(Paint.Style.FILL);
        Path path = new Path();
         path.moveTo(10, 10);
        path.lineTo(100,100);
        path.lineTo(200,200);
        path.lineTo(10,290);
        path.lineTo(50,490);
//        path.
        //  path.lineTo(0,0);

//        RectF rect = new RectF(10, 10, 100, 100);
//        //   path.arcTo(rect, 0, 90, false);
//
//        path.addOval(rect, Path.Direction.CW);
        canvas.drawPath(path, mPaint);
    }

    private void drawBitmap(Canvas canvas) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        canvas.drawBitmap(bitmap, 0, 0, null);
        canvas.drawBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), null);
    }



    private void drawPosText(Canvas canvas) {
        mPaint.setTextSize(50);
        char[] text = new char[]{'D', 'R', 'A', 'W', 'P', 'O', 'S'};
        float[] pos = new float[]{55, 55,
                111, 111,
                222, 222,
                333, 333,
                444, 444,
                555, 555,
                666, 166};
        canvas.drawPosText(text, 0, 6, pos, mPaint);
        //  canvas.drawPosText ( "drawPos" , POS, mPaint);
    }

    private void drawTextOnPath(Canvas canvas) {

        float width = (float) getWidth();

        float height = (float) getHeight();

        float radius;


        if (width > height) {

            radius = height / 4;

        } else {

            radius = width / 4;

        }


        Path path = new Path();

        path.addCircle(width / 2,

                height / 2, radius,

                Path.Direction.CW);


        Paint paint = new Paint();

        paint.setColor(Color.WHITE);

        paint.setStrokeWidth(5);

        paint.setStyle(Paint.Style.STROKE);

        paint.setTextSize(100);

        path.reset();
        path.moveTo(500, 500);
        path.lineTo(000, 000);

        canvas.drawPath(path, mPaint);
        canvas.drawTextOnPath("HO NHAT TAN", path, 0, 0, paint);

        path.reset();
        path.moveTo(000, 000);
        path.lineTo(500, 500);

        canvas.drawPath(path, mPaint);
        canvas.drawTextOnPath("HO NHAT TAN", path, 0, 0, paint);


    }

    private void drawPicture(Canvas canvas) {
        Picture picture = new Picture();
        picture.draw(canvas);
        canvas.drawPicture(new Picture());
    }

    private void drawText(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(50);
        canvas.drawText("Ahihi", 0, 0, mPaint);
        canvas.drawText("Ahihi", 100, 100, mPaint);
        canvas.drawLine(0, 0, 100, 100, mPaint);

    }


    private void saveAndRestore(Canvas canvas) {
        Log.i(TAG, "SAVECOUNT1 =" + canvas.getSaveCount());

        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        canvas.drawLine(100, 100, 500, 100, paint);
        canvas.save();
        Log.i(TAG, "SAVECOUNT2 =" + canvas.getSaveCount());

        paint.setColor(Color.WHITE);
        canvas.drawLine(500, 100, 800, 100, paint);
        canvas.save();
        Log.i(TAG, "SAVECOUNT3 =" + canvas.getSaveCount());

        ////// translate
        canvas.translate(100, 100);
        paint.setColor(Color.YELLOW);
        canvas.drawLine(100, 100, 500, 100, paint);
        //tương ứng  canvas.drawLine(200, 200, 600, 200, paint);
        canvas.save();
        Log.i(TAG, "SAVECOUNT4 =" + canvas.getSaveCount());

        ///// scale
        canvas.scale(0.5f, 0.5f);
        paint.setColor(Color.BLUE);
        //tương ứng  canvas.drawLine(150, 150, 300, 150, paint);
        canvas.drawLine(100, 100, 500, 100, paint);


     //  canvas.restoreToCount(1);
//        canvas.restoreToCount(2);
        canvas.restoreToCount(3);
//        canvas.restoreToCount(4);
//        canvas.restore();// restore tới mốc kế trước
        paint.setColor(Color.RED);
        canvas.drawLine(100, 100, 400, 100, paint);
        Log.i(TAG, "SAVECOUNT6 =" + canvas.getSaveCount());
    }

    private void saveLayer(Canvas canvas) {
        Log.i(TAG, "SAVECOUNT1 =" + canvas.getSaveCount());
        canvas.drawColor(Color.BLUE);
        RectF rectF1=new RectF(0, 0, 500, 500);
        canvas.saveLayer(rectF1, null);

        Log.i(TAG, "SAVECOUNT2 =" + canvas.getSaveCount());
        canvas.drawColor(Color.GRAY);
        //   canvas.saveLayer(100,100,200,200,mPaint);
        RectF rectF2=new RectF(0, 0, 500, 500);
        canvas.saveLayer(rectF2, null);
        canvas.drawColor(Color.RED);
        Log.i(TAG, "SAVECOUNT3 =" + canvas.getSaveCount());

        //   canvas.restoreToCount(1);
        canvas.restoreToCount(2);
        // canvas.restoreToCount(3);
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
        TEXT,
        POST_TEST,
        TEXT_ON_PATH,
        PICTURE,
        TRANSLATE,
        SCALE,
        ROTATE,
        SKEW,
        SAVE_RESTORE,
        SAVELAYER
    }
}
