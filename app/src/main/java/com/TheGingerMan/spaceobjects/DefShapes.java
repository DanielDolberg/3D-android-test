package com.TheGingerMan.spaceobjects;

import java.util.ArrayList;

public class DefShapes {


    public static SpacialObject CUBE(double width,double height)
    {
        ArrayList<Vertex> cubeVertices;
        ArrayList<Edge> cubeEdges;
        SpacialObject cube;

        cubeVertices = new ArrayList<>();
        cubeEdges = new ArrayList<>();


        double x = 5;

        cubeVertices.add(new Vertex(-x,-x,x));// /\----------
        cubeVertices.add(new Vertex(x,-x,x)); // ----------/\
        cubeVertices.add(new Vertex(-x,x,x));// \/----------
        cubeVertices.add(new Vertex(x,x,x));// ----------\/

        cubeVertices.add(new Vertex(-x,-x,-x));// /\----------
        cubeVertices.add(new Vertex(x,-x,-x)); // ----------/\
        cubeVertices.add(new Vertex(-x,x,-x));// \/----------
        cubeVertices.add(new Vertex(x,x,-x));// ----------\/

        cubeEdges.add(new Edge(cubeVertices.get(0),cubeVertices.get(1)));
        cubeEdges.add(new Edge(cubeVertices.get(0),cubeVertices.get(2)));
        cubeEdges.add(new Edge(cubeVertices.get(2),cubeVertices.get(3)));
        cubeEdges.add(new Edge(cubeVertices.get(1),cubeVertices.get(3)));

        cubeEdges.add(new Edge(cubeVertices.get(4),cubeVertices.get(5)));
        cubeEdges.add(new Edge(cubeVertices.get(4),cubeVertices.get(6)));
        cubeEdges.add(new Edge(cubeVertices.get(6),cubeVertices.get(7)));
        cubeEdges.add(new Edge(cubeVertices.get(5),cubeVertices.get(7)));

        cubeEdges.add(new Edge(cubeVertices.get(0),cubeVertices.get(4)));
        cubeEdges.add(new Edge(cubeVertices.get(1),cubeVertices.get(5)));
        cubeEdges.add(new Edge(cubeVertices.get(2),cubeVertices.get(6)));
        cubeEdges.add(new Edge(cubeVertices.get(3),cubeVertices.get(7)));

        cube = new SpacialObject(new Pivot(new Vector(0,0,0)));
        cube.vertices = cubeVertices;
        cube.edges = cubeEdges;

        return cube;
    }

    public static SpacialObject TRIANGLE(double width,double height)
    {
        ArrayList<Vertex> triVertices;
        ArrayList<Edge> triEdges;
        SpacialObject tri;


        triVertices = new ArrayList<>();
        triVertices.add(new Vertex(0,width/256,0));
        triVertices.add(new Vertex(-width/640,-width/640,width/640));
        triVertices.add(new Vertex(-width/640,-width/640,-width/640));
        triVertices.add(new Vertex(width/640,-width/640,-width/640));
        triVertices.add(new Vertex(width/640,-width/640,width/640));

        triEdges = new ArrayList<>();
        triEdges.add(new Edge(triVertices.get(1),triVertices.get(0)));
        triEdges.add(new Edge(triVertices.get(2),triVertices.get(0)));
        triEdges.add(new Edge(triVertices.get(3),triVertices.get(0)));
        triEdges.add(new Edge(triVertices.get(4),triVertices.get(0)));
        triEdges.add(new Edge(triVertices.get(1),triVertices.get(2)));
        triEdges.add(new Edge(triVertices.get(2),triVertices.get(3)));
        triEdges.add(new Edge(triVertices.get(3),triVertices.get(4)));
        triEdges.add(new Edge(triVertices.get(1),triVertices.get(4)));

        tri = new SpacialObject(new Pivot(new Vector(0,0,0)));
        tri.vertices = triVertices;
        tri.edges = triEdges;

        return  tri;
    }

    public static SpacialObject CIRCLE(double width,double height)
    {
        //ArrayList<Vertex> circleVertices;
        //ArrayList<Edge> circleEdges;
        SpacialObject circle;

        circle = new SpacialObject(new Pivot(new Vector(0,0,0)));
        circle.vertices = new ArrayList<>();
        circle.edges = new ArrayList<>();

        double r = 4;

        int vertSize = 32;

        for (int i = 0; i < vertSize; i++) {

            circle.vertices.add(new Vertex(r,0,0));

            circle.rotateGlobalZ(360/vertSize);
        }



        return circle;
    }

    public static SpacialObject TEST(double width,double height)
    {
        ArrayList<Vertex> triVertices;
        ArrayList<Edge> triEdges;
        SpacialObject tri;

        double y,x;

        y = 0;
        x = 4;

        triVertices = new ArrayList<>();
        triVertices.add(new Vertex(0,y,0));
        triVertices.add(new Vertex(-x,-y,x));
        triVertices.add(new Vertex(-x,-y,-x));
        triVertices.add(new Vertex(x,-y,-x));
        triVertices.add(new Vertex(x,-y,x));

        triEdges = new ArrayList<>();
        triEdges.add(new Edge(triVertices.get(1),triVertices.get(0)));
        triEdges.add(new Edge(triVertices.get(2),triVertices.get(0)));
        triEdges.add(new Edge(triVertices.get(3),triVertices.get(0)));
        triEdges.add(new Edge(triVertices.get(4),triVertices.get(0)));
        triEdges.add(new Edge(triVertices.get(1),triVertices.get(2)));
        triEdges.add(new Edge(triVertices.get(2),triVertices.get(3)));
        triEdges.add(new Edge(triVertices.get(3),triVertices.get(4)));
        triEdges.add(new Edge(triVertices.get(1),triVertices.get(4)));

        tri = new SpacialObject(new Pivot(new Vector(0,0,0)));
        tri.vertices = triVertices;
        tri.edges = triEdges;

        return  tri;
    }





}
