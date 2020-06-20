package com.TheGingerMan.spaceobjects;

import android.graphics.Color;

import java.util.ArrayList;

import javax.crypto.Cipher;

public class DefShapes {

    ////////colors
    //orange.....ish =  255, 151, 0
    //nice warm blue....I dont remember how this color is called = 0, 255, 240
    //purple = 189, 0, 255
    //nice green = 26, 188, 156
    //emo phaze =  52, 73, 94
    //ya like jazz? =  244, 208, 63

    static double radius4Circles = 4;

    public static SpacialObject PLANE(double width,double height)
    {
        ArrayList<Vertex> planeVertices;
        ArrayList<Edge> planeEdges;
        Face face;

        SpacialObject plane;



        planeVertices = new ArrayList<>();
        planeEdges = new ArrayList<>();

        double x = 5;

        planeVertices.add(new Vertex(-x,x,0));// /\----------   0
        planeVertices.add(new Vertex(x,x,0)); // ----------/\   1
        planeVertices.add(new Vertex(-x,-x,0));// \/----------  2
        planeVertices.add(new Vertex(x,-x,0));// ----------\/   3


        planeEdges.add(new Edge(planeVertices.get(0),planeVertices.get(1)));
        planeEdges.add(new Edge(planeVertices.get(0),planeVertices.get(2)));
        planeEdges.add(new Edge(planeVertices.get(2),planeVertices.get(3)));
        planeEdges.add(new Edge(planeVertices.get(1),planeVertices.get(3)));

        face = new Face(Color.BLUE);
        face.vertices.add(planeVertices.get(0));
        face.vertices.add(planeVertices.get(1));
        face.vertices.add(planeVertices.get(3));
        face.vertices.add(planeVertices.get(2));




        plane = new SpacialObject(new Pivot(new Vector(0,0,0)));
        plane.vertices = planeVertices;
        plane.edges = planeEdges;
        plane.faces.add(face);

        return plane;
    }

    public static SpacialObject CUBE(double width,double height)
    {
        ArrayList<Vertex> cubeVertices;
        ArrayList<Edge> cubeEdges;
        ArrayList<Face> cubeFaces;
        SpacialObject cube;
        Face f;

        cubeVertices = new ArrayList<>();
        cubeEdges = new ArrayList<>();
        cubeFaces = new ArrayList<>();



        double x = 5;


        /////////////////////////////////////////////////////////////////vertecies
        cubeVertices.add(new Vertex(-x,-x,x));// /\---------- 0
        cubeVertices.add(new Vertex(x,-x,x)); // ----------/\ 1
        cubeVertices.add(new Vertex(-x,x,x));// \/---------- 2
        cubeVertices.add(new Vertex(x,x,x));// ----------\/ 3

        cubeVertices.add(new Vertex(-x,-x,-x));// /\---------- 4
        cubeVertices.add(new Vertex(x,-x,-x)); // ----------/\ 5
        cubeVertices.add(new Vertex(-x,x,-x));// \/---------- 6
        cubeVertices.add(new Vertex(x,x,-x));// ----------\/ 7
        /////////////////////////////////////////////////////////////////vertecies

        /////////////////////////////////////////////////////////////////edges
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
        /////////////////////////////////////////////////////////////////edges


        /////////////////////////////////////////////////////////////////faces
        cubeFaces.add(new Face(Color.BLACK));
        f = cubeFaces.get(0);
        f.vertices.add(cubeVertices.get(0));
        f.vertices.add(cubeVertices.get(1));
        f.vertices.add(cubeVertices.get(3));
        f.vertices.add(cubeVertices.get(2));

        cubeFaces.add(new Face(Color.RED));
        f = cubeFaces.get(1);
        f.vertices.add(cubeVertices.get(0));
        f.vertices.add(cubeVertices.get(4));
        f.vertices.add(cubeVertices.get(6));
        f.vertices.add(cubeVertices.get(2));

        cubeFaces.add(new Face(Color.rgb(255, 151, 0)));
        f = cubeFaces.get(2);
        f.vertices.add(cubeVertices.get(1));
        f.vertices.add(cubeVertices.get(5));
        f.vertices.add(cubeVertices.get(7));
        f.vertices.add(cubeVertices.get(3));

        cubeFaces.add(new Face(Color.BLUE));
        f = cubeFaces.get(3);
        f.vertices.add(cubeVertices.get(4));
        f.vertices.add(cubeVertices.get(5));
        f.vertices.add(cubeVertices.get(7));
        f.vertices.add(cubeVertices.get(6));

        cubeFaces.add(new Face(Color.rgb(189, 0, 255)));
        f = cubeFaces.get(4);
        f.vertices.add(cubeVertices.get(0));
        f.vertices.add(cubeVertices.get(1));
        f.vertices.add(cubeVertices.get(5));
        f.vertices.add(cubeVertices.get(4));

        cubeFaces.add(new Face(Color.YELLOW));
        f = cubeFaces.get(5);
        f.vertices.add(cubeVertices.get(2));
        f.vertices.add(cubeVertices.get(3));
        f.vertices.add(cubeVertices.get(7));
        f.vertices.add(cubeVertices.get(6));
        /////////////////////////////////////////////////////////////////faces

        cube = new SpacialObject(new Pivot(new Vector(0,0,0)));
        cube.vertices = cubeVertices;
        cube.edges = cubeEdges;
        cube.faces = cubeFaces;

        return cube;
    }

    public static SpacialObject TRIANGLE(double width,double height)
    {
        ArrayList<Vertex> triVertices;
        ArrayList<Edge> triEdges;
        SpacialObject tri;

        double x,x2;
        x=4;
        x2=4;

        triVertices = new ArrayList<>();
        triVertices.add(new Vertex(0,x2,0));
        triVertices.add(new Vertex(-x,-x,x));
        triVertices.add(new Vertex(-x,-x,-x));
        triVertices.add(new Vertex(x,-x,-x));
        triVertices.add(new Vertex(x,-x,x));

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

        double r = DefShapes.radius4Circles;

        int vertSize = 30;

        for (int i = 0; i < vertSize; i++) {

            circle.vertices.add(new Vertex(r,0,0));

            if(i!=0)
                circle.edges.add(new Edge(circle.vertices.get(i-1),circle.vertices.get(i)));

            if(i==vertSize-1)
                circle.edges.add(new Edge(circle.vertices.get(i),circle.vertices.get(0)));

            circle.rotateGlobalZ(360/vertSize);
        }


        /*
        for (int i = 0; i < circle.vertices.size(); i++) {
            circle.vertices.get(i).y = -circle.vertices.get(i).y;
            circle.vertices.get(i).x = -circle.vertices.get(i).x;
        }
         */


        return circle;
    }

    public static SpacialObject SPHERE(double width,double height)
    {
        SpacialObject sphere;

        sphere = new SpacialObject(new Pivot(new Vector(0,0,0)));

        double r = DefShapes.radius4Circles;

        int vertSize = 10;

        for (int j = 0; j < vertSize; j++) {
            for (int i = 0; i < vertSize; i++) {

                sphere.vertices.add(new Vertex(r, 0, 0));

                if (i != 0)
                    sphere.edges.add(new Edge(sphere.vertices.get(i - 1), sphere.vertices.get(i)));

                if (i == vertSize - 1)
                    sphere.edges.add(new Edge(sphere.vertices.get(i), sphere.vertices.get(0)));

                sphere.rotateGlobalZ(360 / vertSize);
            }
            sphere.rotateGlobalY(360 / vertSize);
        }


        return  sphere;

    }

    public static SpacialObject TEST(double width,double height)
    {
        ArrayList<Vertex> triVertices;
        ArrayList<Edge> triEdges;
        SpacialObject tri;
        Pivot p = new Pivot(new Vector(0,0,0));

        tri = new SpacialObject(p);


        return  tri;
    }





}
