package com.neolab.canvasexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.neolab.canvasexample.views.CanvasView;

public class MainActivity extends AppCompatActivity {
    CanvasView mCanvasView;
    TextView mTvTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvTitle = (TextView) findViewById(R.id.tvTitle);
        mCanvasView = (CanvasView) findViewById(R.id.canvasView);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        Thread thread = new Thread(new Task());
//        thread.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.action_RGB:
                mCanvasView.changeTypeDraw(CanvasView.TypeDraw.RGB);
                break;
            case R.id.action_ARGB:
                mCanvasView.changeTypeDraw(CanvasView.TypeDraw.ARGB);
                break;
            case R.id.action_COLOR:
                mCanvasView.changeTypeDraw(CanvasView.TypeDraw.COLOR);
                break;
            case R.id.action_PAINT:
                mCanvasView.changeTypeDraw(CanvasView.TypeDraw.PAINT);
                break;
            case R.id.action_POINT:
                mCanvasView.changeTypeDraw(CanvasView.TypeDraw.POINT);
                break;
            case R.id.action_LINE:
                mCanvasView.changeTypeDraw(CanvasView.TypeDraw.LINE);
                break;
            case R.id.action_RECT:
                mCanvasView.changeTypeDraw(CanvasView.TypeDraw.RECT);
                break;
            case R.id.action_OVAL:
                mCanvasView.changeTypeDraw(CanvasView.TypeDraw.OVAL);
                break;
            case R.id.action_CIRCLE:
                mCanvasView.changeTypeDraw(CanvasView.TypeDraw.CIRCLE);
                break;
            case R.id.action_ARC:
                mCanvasView.changeTypeDraw(CanvasView.TypeDraw.ARC);
                break;
            case R.id.action_ROUND_RECT:
                mCanvasView.changeTypeDraw(CanvasView.TypeDraw.ROUND_RECT);
                break;
            case R.id.action_PATH:
                mCanvasView.changeTypeDraw(CanvasView.TypeDraw.PATH);
                break;
            case R.id.action_BITMAP:
                mCanvasView.changeTypeDraw(CanvasView.TypeDraw.BITMAP);
                break;
            case R.id.action_BITMAP_MESH:
//                mCanvasView.changeTypeDraw(CanvasView.TypeDraw.BITMAP_MESH);
                Intent intent = new Intent(MainActivity.this, BitmapMeshActivity.class);
                startActivity(intent);
                break;

            case R.id.action_TEXT:
                mCanvasView.changeTypeDraw(CanvasView.TypeDraw.TEXT);
                break;
            case R.id.action_POST_TEST:
                mCanvasView.changeTypeDraw(CanvasView.TypeDraw.POST_TEST);
                break;
            case R.id.action_TEXT_ON_PATH:
                mCanvasView.changeTypeDraw(CanvasView.TypeDraw.TEXT_ON_PATH);
                break;
            case R.id.action_PICTURE:
                mCanvasView.changeTypeDraw(CanvasView.TypeDraw.PICTURE);
                break;
            case R.id.action_TRANSLATE:
                mCanvasView.changeTypeDraw(CanvasView.TypeDraw.TRANSLATE);
                break;
            case R.id.action_SCALE:
                mCanvasView.changeTypeDraw(CanvasView.TypeDraw.SCALE);
                break;
            case R.id.action_ROTATE:
                mCanvasView.changeTypeDraw(CanvasView.TypeDraw.ROTATE);
                break;
            case R.id.action_SKEW:
                mCanvasView.changeTypeDraw(CanvasView.TypeDraw.SKEW);
                break;
            case R.id.action_SAVE_RESTORE:
                mCanvasView.changeTypeDraw(CanvasView.TypeDraw.SAVE_RESTORE);
                break;
            case R.id.action_SAVELAYER:
                mCanvasView.changeTypeDraw(CanvasView.TypeDraw.SAVELAYER);
                break;
            default:
                break;
        }
        mTvTitle.setText("Draw " + mCanvasView.getTypeDraw().toString());
        return super.onOptionsItemSelected(item);
    }

    class Task implements Runnable {

        @Override
        public void run() {
            mCanvasView.changeTypeDraw(CanvasView.TypeDraw.ROTATE);
        }
    }
}
