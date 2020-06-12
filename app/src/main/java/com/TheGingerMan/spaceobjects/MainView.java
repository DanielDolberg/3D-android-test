package com.TheGingerMan.spaceobjects;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

public class MainView extends View {

    double width,height;
    Space space;
    Vertex[] cubeVertices;
    Edge[] cubeEdges;
    SpacialObject cube;

    Vertex[] lineVertices;
    Edge[] lineEdges;
    SpacialObject line;



    float timeStep;

    public MainView(Context context, double width, double height) {
        super(context);
        this.width=width;
        this.height=height;

        space = new Space(width,height);


        lineVertices = new Vertex[2];
        lineEdges = new Edge[1];

        lineVertices[0] = new Vertex(4,4,0);
        lineVertices[1] = new Vertex(-4,-4,0);

        lineEdges[0] = new Edge(lineVertices[0], lineVertices[1]);

        line = new SpacialObject(new Pivot(new Vector(0,0,0)));
        line.vertices = lineVertices;
        line.edges = lineEdges;

        cubeVertices = new Vertex[8];
        cubeEdges = new Edge[8];



        cubeVertices[0] = new Vertex(-5,5,1);// /\----------
        cubeVertices[1] = new Vertex(5,5,1); // ----------/\
        cubeVertices[2] = new Vertex(-5,-5,1);// \/----------
        cubeVertices[3] = new Vertex(5,-5,1);// ----------\/

        cubeVertices[4] = new Vertex(-5,5,-1);// /\----------
        cubeVertices[5] = new Vertex(5,5,-1); // ----------/\
        cubeVertices[6] = new Vertex(-5,-5,-1);// \/----------
        cubeVertices[7] = new Vertex(5,-5,-1);// ----------\/

        cubeEdges[0] = new Edge(cubeVertices[0],cubeVertices[1]);
        cubeEdges[1] = new Edge(cubeVertices[0],cubeVertices[2]);
        cubeEdges[2] = new Edge(cubeVertices[2],cubeVertices[3]);
        cubeEdges[3] = new Edge(cubeVertices[1],cubeVertices[3]);

        cubeEdges[4] = new Edge(cubeVertices[4],cubeVertices[5]);
        cubeEdges[5] = new Edge(cubeVertices[4],cubeVertices[6]);
        cubeEdges[6] = new Edge(cubeVertices[6],cubeVertices[7]);
        cubeEdges[7] = new Edge(cubeVertices[5],cubeVertices[7]);

        cube = new SpacialObject(new Pivot(new Vector(0,0,0)));
        cube.vertices = cubeVertices;
        cube.edges = cubeEdges;




    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        space.draw(canvas);
        //line.draw(canvas, space);
        cube.draw(canvas,space);

        invalidate();
    }



}
