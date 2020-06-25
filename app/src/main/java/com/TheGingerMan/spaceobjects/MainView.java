package com.TheGingerMan.spaceobjects;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

import java.util.ArrayList;

public class MainView extends View implements Runnable {

    double width, height,ray;
    final float rayLimit = -20;
    Paint BackGroundColor;
    Space space;

    SpacialObject test;

    ArrayList<Vertex> lineVertices;
    ArrayList<Edge> lineEdges;
    SpacialObject line;


    boolean rotLeft, rotRight, rotUp, rotDown;

    Thread runthread;


    float timeStep;

    public MainView(Context context, double width, double height) {
        super(context);
        this.width = width;
        this.height = height;

        space = new Space(width, height);
        BackGroundColor = new Paint(Color.GRAY);

        test = DefShapes.CUBE(width,height);
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

                ray = 10;
                boolean pass = false;
                Face lastdrawn = null;


        for (int i = 0; i < width; i++)
        {
            while (ray > rayLimit && !pass) {
                pass = false;
                lastdrawn = null;
                for (int j = 0; j < test.faces.size(); j++) {
                    if (aprox(test.faces.get(j).z, ray, 1)) {
                        if (lastdrawn != test.faces.get(j)) {
                            lastdrawn = test.faces.get(j);
                            lastdrawn.draw(canvas);
                        }
                        pass = true;
                        j=test.faces.size()+1;
                    }
                }
                ray -= 0.1;
            }
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

            if (rotLeft)
                test.rotateGlobalY(.1f);
            if (rotRight)
                test.rotateGlobalY(-.1f);

            if (rotUp)
                test.rotateGlobalX(-.1f);
            if (rotDown)
                test.rotateGlobalX(.1f);

            try {
                Thread.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

