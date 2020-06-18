package com.TheGingerMan.spaceobjects;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.ArrayList;

public class MainView extends View implements Runnable{

    double width,height;
    Paint BackGroundColor;
    Space space;

///////////////////////////// for testing purposes
    SpacialObject cube;
    SpacialObject tri;
    SpacialObject circle;
    SpacialObject shap;
    SpacialObject plane;
    SpacialObject sphere;
    SpacialObject test;

    ArrayList<Vertex> lineVertices;
    ArrayList<Edge> lineEdges;
    SpacialObject line;



    boolean rotLeft,rotRight,rotUp,rotDown;
///////////////////////////////////////////////////



    Thread runthread;


    float timeStep;

    public MainView(Context context, double width, double height) {
        super(context);
        this.width=width;
        this.height=height;

        space = new Space(width,height);
        BackGroundColor = new Paint(Color.GRAY);

/////////////////////////////////////////////////////////////////
        lineVertices = new ArrayList<>();
        lineEdges = new ArrayList<>();

        lineVertices.add(new Vertex(width/320,-width/320,0));
        lineVertices.add(new Vertex(width/320,-width/320,0));

        lineEdges.add(new Edge(lineVertices.get(0), lineVertices.get(1)));

        line = new SpacialObject(new Pivot(new Vector(0,0,0)));
        line.vertices = lineVertices;
        line.edges = lineEdges;
/////////////////////////////////////////////////////////////////////////////////////////

        cube = DefShapes.CUBE(width,height);
        tri = DefShapes.TRIANGLE(width,height);
        circle = DefShapes.CIRCLE(width,height);
        plane = DefShapes.PLANE(width,height);
        //sphere = DefShapes.SPHERE(width,height);

        shap = DefShapes.TEST(width,height);



///////////////////////////////////////////////////////////////////////////

        test = shap;

        rotDown=rotLeft=rotRight=rotUp=false;

        runthread = new Thread(this, "runthread");
        runthread.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //canvas.drawRect(0,0,(float)width,(float)height,black); //draws the black background


        space.draw(canvas);
        //line.draw(canvas, space);
        //cube.draw(canvas,space);
        //tri.draw(canvas,space);
        test.draw(canvas,space);

        invalidate();
    }


    @Override
    public void run() {
        while (true) {

            if(rotLeft)
                test.rotateGlobalY(.1f);
            if(rotRight)
                test.rotateGlobalY(-.1f);

            if(rotUp)
                test.rotateGlobalX(-.1f);
            if(rotDown)
                test.rotateGlobalX(.1f);

                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

