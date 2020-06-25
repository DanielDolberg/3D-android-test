package com.TheGingerMan.spaceobjects;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.ArrayList;

public class rubixCubeView extends View implements Runnable {

    double width, height,ray;
    final float rayLimit = 10;
    Paint BackGroundColor;
    Space space;

    SpacialObject test;

    ArrayList<Vertex> lineVertices;
    ArrayList<Edge> lineEdges;
    SpacialObject line;


    boolean rotLeft, rotRight, rotUp, rotDown;

    Thread runthread;


    float timeStep;

    public rubixCubeView(Context context, double width, double height) {
        super(context);
        this.width = width;
        this.height = height;

        space = new Space(width, height);
        BackGroundColor = new Paint(Color.GRAY);

        test = DefShapes.TEST(width,height);
        test.state = 3;
        test.globalSpace = space;
        test.updateFaces();

        rotDown = rotLeft = rotRight = rotUp = false;

        runthread = new Thread(this, "runthread");
        runthread.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);



        test.updateFaces();

        ray = -20;
        boolean pass = false;
        Face lastdrawn = null;

        while (ray < rayLimit && !pass) {
            for (int j = 0; j < test.faces.size(); j++) {
                if (aprox(test.faces.get(j).z, ray, 1)) {
                    if(lastdrawn != test.faces.get(j)){
                        lastdrawn = test.faces.get(j);
                        lastdrawn.draw(canvas);
                    }
                }
            }
            ray += 0.1;
        }


        space.draw(canvas);
        //test.draw(canvas, space);
        //test.faces.get(0).draw(canvas);

        invalidate();
    }

    public boolean aprox(double d1, double d2, double epproximation)
    {
        if(d1 < (d2 + epproximation) && d1 > (d2 - epproximation))
            return true;

        return  false;
    }


    @Override
    public void run() {
        while (true) {


            try {
                Thread.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
