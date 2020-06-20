package com.TheGingerMan.spaceobjects;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    MainView mainView;
    double width;
    double height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;

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

                if (x < width / 3)
                    mainView.rotLeft = true;
                if (x > width - width / 3)
                    mainView.rotRight = true;

                if (y < height / 3)
                    mainView.rotUp = true;
                if (y > height - height / 3)
                    mainView.rotDown = true;

                break;

            case MotionEvent.ACTION_MOVE:
                if (x < width / 3)
                    mainView.rotLeft = true;
                else
                    mainView.rotLeft = false;

                if (x > width - width / 3)
                    mainView.rotRight = true;
                else
                    mainView.rotRight = false;

                if (y < height / 3)
                    mainView.rotUp = true;
                else
                    mainView.rotUp = false;

                if (y > height - height / 3)
                    mainView.rotDown = true;
                else
                    mainView.rotDown = false;

                break;


            case MotionEvent.ACTION_UP:
                mainView.rotLeft = false;
                mainView.rotRight = false;
                mainView.rotUp = false;
                mainView.rotDown = false;
                break;
        }
        return true;
    }

}