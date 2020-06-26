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
    ArrayList<SpacialObject> rubcube;
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

        rubcube = new ArrayList<>();

        int c = -1;

        for (int i = -1; i < 2; i++) { //y
            for (int j = -1; j < 2; j++) { // x
                c++;
                rubcube.add(DefShapes.TEST(width, height, j, i, 0, 1));
                rubcube.get(c).state = 3;
                rubcube.get(c).globalSpace = space;
            }
        }

        test = DefShapes.TEST(width,height,0,0,0,1);
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


        for (int i = 0; i < rubcube.size(); i++) {
            rubcube.get(i).updateFaces();
        }

        ray = -20;
        boolean pass = false;
        Face lastdrawn = null;

        for (int i = 0; i < rubcube.size(); i++) {
            pass= false;
            ray = -20;
            lastdrawn = null;
            while (ray < rayLimit && !pass) {
                for (int j = 0; j < rubcube.get(i).faces.size(); j++) {
                    if (aprox(rubcube.get(i).faces.get(j).z, ray, 1)) {
                        if (lastdrawn != rubcube.get(i).faces.get(j)) {
                            lastdrawn = rubcube.get(i).faces.get(j);
                            lastdrawn.draw(canvas);
                        }
                    }
                }
                ray += 0.1;
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

            if (rotLeft) {
                //test.rotateGlobalY(.1f);

                for (int i = 0; i < rubcube.size(); i++) {
                    rubcube.get(i).rotateGlobalY(.1f);
                }
            }
            if (rotRight) {
                //test.rotateGlobalY(-.1f);
                for (int i = 0; i < rubcube.size(); i++) {
                    rubcube.get(i).rotateGlobalY(-.1f);
                }
            }

            if (rotUp) {
                //test.rotateGlobalX(-.1f);
                for (int i = 0; i < rubcube.size(); i++) {
                    rubcube.get(i).rotateGlobalX(-.1f);
                }
            }
            if (rotDown){
               //test.rotateGlobalX(.1f);

                for (int i = 0; i < rubcube.size(); i++) {
                    rubcube.get(i).rotateGlobalX(.1f);
                }
            }


            try {
                Thread.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
