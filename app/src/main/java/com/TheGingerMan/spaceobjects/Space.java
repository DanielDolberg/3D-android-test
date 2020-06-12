package com.TheGingerMan.spaceobjects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Space {

    double screenW,screenH;
    double X0,Y0,spacialX ,spacialY;
    double offsetX,offsetY;
    Paint red;


    public Space(double ScreenWidth,double ScreenHeight){

        screenW = ScreenWidth;
        screenH = ScreenHeight;

        X0 = ScreenWidth/2;
        Y0 = ScreenHeight/2;

        spacialX=ScreenWidth/20;
        spacialY=ScreenWidth/20;

        offsetX = 0;
        offsetY = 0;

        red = new Paint();
        red.setColor(Color.RED);
    }

    public void moveView(float OffsetX, float OffsetY){
        offsetX+=OffsetX;
        offsetY+=OffsetY;
    }



    public void draw(Canvas canvas) {

        for(int i=0;i<10;i++)
        {
         canvas.drawCircle((float)(offsetX+ X0 + i*spacialX),(float)(offsetY + Y0),20,red);
        }

        for(int i=1;i<10;i++)
        {
            canvas.drawCircle((float)(offsetX+ X0- i*spacialX),(float)(offsetY + Y0),20,red);
        }

        for(int i=0;i<10;i++)
        {
            canvas.drawCircle((float)(offsetX+X0),(float)(offsetY +Y0 + i*spacialY),20,red);
        }

        for(int i=1;i<10;i++)
        {
            canvas.drawCircle((float)(offsetX+X0),(float)(offsetY +Y0 - i*spacialY),20,red);
        }
    }

    public double XinSpace(double x) {
        return (offsetX+ X0 + spacialX*x);
    }

    public double YinSpace(double y) {
        return (offsetY + Y0 + spacialY*y);
    }
}
