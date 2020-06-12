package com.TheGingerMan.spaceobjects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Space {

    float screenW,screenH;
    float X0,Y0,spacialX ,spacialY;
    float offsetX,offsetY;
    Paint red;


    public Space(float ScreenWidth,float ScreenHeight){

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
         canvas.drawCircle(offsetX+ X0 + i*spacialX,offsetY + Y0,20,red);
        }

        for(int i=1;i<10;i++)
        {
            canvas.drawCircle(offsetX+ X0- i*spacialX,offsetY + Y0,20,red);
        }

        for(int i=0;i<10;i++)
        {
            canvas.drawCircle(offsetX+X0,offsetY +Y0 + i*spacialY,20,red);
        }

        for(int i=1;i<10;i++)
        {
            canvas.drawCircle(offsetX+X0,offsetY +Y0 - i*spacialY,20,red);
        }
    }

    public float XinSpace(float x) {
        return (offsetX+ X0 + spacialX*x);
    }

    public float YinSpace(float y) {
        return (offsetY + Y0 + spacialY*y);
    }
}
