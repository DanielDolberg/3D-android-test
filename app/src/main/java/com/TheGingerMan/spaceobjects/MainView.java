package com.TheGingerMan.spaceobjects;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

public class MainView extends View implements Runnable{

    double width,height;
    Space space;
    Vertex[] cubeVertices;
    Edge[] cubeEdges;
    SpacialObject cube;

    Vertex[] lineVertices;
    Edge[] lineEdges;
    SpacialObject line;

    Vertex[] triVertices;
    Edge[] triEdges;
    SpacialObject tri;


    Thread runthread;


    float timeStep;

    public MainView(Context context, double width, double height) {
        super(context);
        this.width=width;
        this.height=height;

        space = new Space(width,height);

/////////////////////////////////////////////////////////////////
        lineVertices = new Vertex[2];
        lineEdges = new Edge[1];

        lineVertices[0] = new Vertex(width/320,-width/320,0);
        lineVertices[1] = new Vertex(width/320,-width/320,0);

        lineEdges[0] = new Edge(lineVertices[0], lineVertices[1]);

        line = new SpacialObject(new Pivot(new Vector(0,0,0)));
        line.vertices = lineVertices;
        line.edges = lineEdges;
/////////////////////////////////////////////////////////////////////////////////////////
        cubeVertices = new Vertex[8];
        cubeEdges = new Edge[12];



        cubeVertices[0] = new Vertex(-width/256,width/256,width/1280);// /\----------
        cubeVertices[1] = new Vertex(width/256,width/256,width/1280); // ----------/\
        cubeVertices[2] = new Vertex(-width/256,-width/256,width/1280);// \/----------
        cubeVertices[3] = new Vertex(width/256,-width/256,width/1280);// ----------\/

        cubeVertices[4] = new Vertex(-width/256,width/256,-width/1280);// /\----------
        cubeVertices[5] = new Vertex(width/256,width/256,-width/1280); // ----------/\
        cubeVertices[6] = new Vertex(-width/256,-width/256,-width/1280);// \/----------
        cubeVertices[7] = new Vertex(width/256,-width/256,-width/1280);// ----------\/

        cubeEdges[0] = new Edge(cubeVertices[0],cubeVertices[1]);
        cubeEdges[1] = new Edge(cubeVertices[0],cubeVertices[2]);
        cubeEdges[2] = new Edge(cubeVertices[2],cubeVertices[3]);
        cubeEdges[3] = new Edge(cubeVertices[1],cubeVertices[3]);

        cubeEdges[4] = new Edge(cubeVertices[4],cubeVertices[5]);
        cubeEdges[5] = new Edge(cubeVertices[4],cubeVertices[6]);
        cubeEdges[6] = new Edge(cubeVertices[6],cubeVertices[7]);
        cubeEdges[7] = new Edge(cubeVertices[5],cubeVertices[7]);

        cubeEdges[8] = new Edge(cubeVertices[0],cubeVertices[4]);
        cubeEdges[9] = new Edge(cubeVertices[1],cubeVertices[5]);
        cubeEdges[10] = new Edge(cubeVertices[2],cubeVertices[6]);
        cubeEdges[11] = new Edge(cubeVertices[3],cubeVertices[7]);

        cube = new SpacialObject(new Pivot(new Vector(0,0,0)));
        cube.vertices = cubeVertices;
        cube.edges = cubeEdges;

        ///////////////////////////////////////////////////////////////////////////

        triVertices = new Vertex[5];
        triVertices[0] = new Vertex(0,-width/256,0);
        triVertices[1] = new Vertex(-width/640,width/640,width/640);
        triVertices[2] = new Vertex(-width/640,width/640,-width/640);
        triVertices[3] = new Vertex(width/640,width/640,-width/640);
        triVertices[4] = new Vertex(width/640,width/640,width/640);

        triEdges = new Edge[8];
        triEdges[0] = new Edge(triVertices[1],triVertices[0]);
        triEdges[1] = new Edge(triVertices[2],triVertices[0]);
        triEdges[2] = new Edge(triVertices[3],triVertices[0]);
        triEdges[3] = new Edge(triVertices[4],triVertices[0]);
        triEdges[4] = new Edge(triVertices[1],triVertices[2]);
        triEdges[5] = new Edge(triVertices[2],triVertices[3]);
        triEdges[6] = new Edge(triVertices[3],triVertices[4]);
        triEdges[7] = new Edge(triVertices[1],triVertices[4]);

        tri = new SpacialObject(new Pivot(new Vector(0,0,0)));
        tri.vertices = triVertices;
        tri.edges = triEdges;

        ///////////////////////////////////////////////////////////////////////////
        runthread = new Thread(this, "runthread");
        runthread.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        space.draw(canvas);
        //line.draw(canvas, space);
        //cube.draw(canvas,space);
        tri.draw(canvas,space);

        invalidate();
    }


    @Override
    public void run() {
        while (true) {

           tri.rotateGlobalX(0.1f);
           tri.rotateGlobalY(0.1f);
           tri.rotateGlobalZ(0.1f);

                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

