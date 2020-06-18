package com.TheGingerMan.spaceobjects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Space {

    double screenW,screenH;
    double Xcenter, Ycenter,spacialX ,spacialY;
    double offsetX,offsetY;
    Paint red;
    int radiusVert;


    public Space(double ScreenWidth,double ScreenHeight){

        screenW = ScreenWidth;
        screenH = ScreenHeight;

        radiusVert = (int)screenW/64;

        Xcenter = ScreenWidth/2;
        Ycenter = ScreenHeight/2;

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

        for (int i = -10; i <=10 ; i++) {
            canvas.drawCircle((float)XinSpace(i),(float)YinSpace(0),radiusVert,red);
        }

        for (int i = -10; i <=10 ; i++) {
            canvas.drawCircle((float) XinSpace(0),(float) YinSpace(i),radiusVert,red);
        }
    }

    public double XinSpace(double x) {
        return (offsetX + Xcenter + spacialX*x);
    }

    public double YinSpace(double y) {
        return (offsetY + Ycenter + spacialY*-y);
    }

}
