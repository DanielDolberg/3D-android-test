package com.TheGingerMan.spaceobjects;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    MainView mainView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        float width = size.x;
        float height = size.y;

        mainView = new MainView(this, width, height);
        setContentView(mainView);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getX();
        int y = (int) event.getY();
        int eventaction = event.getAction();

        switch (eventaction) {
            case MotionEvent.ACTION_DOWN:
                mainView.line.rotateGlobalZ(.1f);
                //mainView.cube.move(1,1,0);
                break;

            case MotionEvent.ACTION_MOVE:
                break;




            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }

}