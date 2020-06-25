package com.TheGingerMan.spaceobjects;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import java.util.ArrayList;

public class rubixCubeView extends View implements Runnable {

    double width,height;
    Space space;
    ArrayList<SpacialObject> rubix;
    SpacialObject cube;
    Pivot worldPivot;
    Thread runthread;

    public rubixCubeView(Context context,double width,double height) {
        super(context);
        this.width =width;
        this.height = height;
        space = new Space(width,height);
        worldPivot = new Pivot(new Vector(0,0,0));
        rubix = new ArrayList<>();
        cube = DefShapes.CUBE(width,height);
        cube.globalSpace =space;
        cube.state = 3;


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                rubix.add(DefShapes.CUBE(width,height));
                rubix.get(j+i).globalSpace =space;
                rubix.get(j+i).state = 3;
            }

        }


        runthread = new Thread(this, "runthread");
        runthread.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        space.draw(canvas);

        for (int i = 0; i < rubix.size(); i++) {
            rubix.get(i).draw(canvas,space);
        }
        //cube.draw(canvas,space);

        invalidate();
    }

    @Override
    public void run() {
        while (true) {

            cube.rotateGlobalY(.1f);

            try {
                Thread.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



}
