package com.TheGingerMan.spaceobjects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;

public class SpacialObject {

    Pivot pivot;
    ArrayList<Vertex> vertices;
    ArrayList<Edge> edges;
    ArrayList<Face> faces;
    Space globalSpace;
    Space localSpace;
    Paint red;
    Paint blue;


    public SpacialObject(Pivot pivot) {
        this.pivot = pivot;

        vertices = new ArrayList<>();
        edges = new ArrayList<>();
        faces = new ArrayList<>();


        red = new Paint();
        red.setColor(Color.RED);
        red.setStrokeWidth(20);
        red.setStyle(Paint.Style.STROKE);

        blue = new Paint();
        blue.setColor(Color.BLUE);
        blue.setStrokeWidth(20);
    }

    public void move(float dx, float dy,float dz)
    {
        pivot.vector.x+=dx;
        pivot.vector.y+=dy;
        pivot.vector.z+=dz;

        for (int i = 0; i < vertices.size() ; i++) {
            vertices.get(i).x+=dx;
            vertices.get(i).y+=dy;
            vertices.get(i).z+=dz;
        }
    }

    public void rotateGlobalX(double angle) {
        double z1, z2, y1, y2,o,ne;
        z1 = pivot.vector.z;
        y1 = pivot.vector.y;
        double r;

        for (int i = 0; i < vertices.size(); i++) {
            z2 = vertices.get(i).z;
            y2 = vertices.get(i).y;

            r = (z1 - z2) * (z1 - z2) + (y1 - y2) * (y1 - y2);
            r = Math.sqrt(r);

            o = Math.asin(y1-y2/r);

            if(z2<z1)
                o = Math.PI - o;
            else if(y2>y1)
                o = 2*Math.PI + o;

            ne = Math.toRadians(angle);
            ne += o;

            vertices.get(i).z = r * Math.cos(ne);
            vertices.get(i).y = -r * Math.sin(ne);
        }
        updateFaces();
    }

    public void rotateGlobalY(double angle) {
        double x1, x2, z1, z2,o,ne;
        x1 = pivot.vector.x;
        z1 = pivot.vector.z;
        double r;

        for (int i = 0; i < vertices.size(); i++) {
            x2 = vertices.get(i).x;
            z2 = vertices.get(i).z;

            r = (x1 - x2) * (x1 - x2) + (z1 - z2) * (z1 - z2);
            r = Math.sqrt(r);

            o = Math.asin(z1+z2/r);

            if(x2<x1)
                o = Math.PI - o;
            else if(z2<z1)
                o = 2*Math.PI + o;

            ne = Math.toRadians(angle);
            ne += o;

            vertices.get(i).x =  r * Math.cos(ne);
            vertices.get(i).z =  r * Math.sin(ne);
        }
        updateFaces();
    }

    public void rotateGlobalZ(double angle) {
        double x1, x2, y1, y2,o,ne;
        x1 = pivot.vector.x;
        y1 = pivot.vector.y;
        double r;

        for (int i = 0; i < vertices.size(); i++) {
            x2 = vertices.get(i).x;
            y2 = vertices.get(i).y;

            r = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
            r = Math.sqrt(r);

            o = Math.asin(y1-y2/r);

            if(x2<x1)
                o = Math.PI - o;
            else if(y2>y1)
                o = 2*Math.PI + o;

            ne = Math.toRadians(angle);
            ne += o;

            vertices.get(i).x = r * Math.cos(ne);
            vertices.get(i).y = -r * Math.sin(ne);
        }
        updateFaces();
    }




    public void updateFaces(){

        for (int i = 0; i < faces.size(); i++) {
            faces.get(i).setPath(globalSpace);
        }
    }

    public void draw(Canvas canvas, Space space){

        for (int i = 0; i < faces.size(); i++) {
            faces.get(i).draw(canvas);
        }

        for (int i = 0; i < edges.size() ; i++) {
            edges.get(i).draw(canvas,red,space);
        }

        for (int i = 0; i < vertices.size(); i++) {
            vertices.get(i).draw(canvas,blue,space);
        }

        //canvas.drawCircle((float)(space.XinSpace(pivot.vector.x)),(float)(space.YinSpace(pivot.vector.y)),(float) Math.sqrt(((space.XinSpace(pivot.vector.x) -space.XinSpace(vertices.get(0).x))*(space.XinSpace(pivot.vector.x) - space.XinSpace(vertices.get(0).x)) + (space.YinSpace(pivot.vector.y) - space.YinSpace(vertices.get(0).y))*(space.YinSpace(pivot.vector.y) - space.YinSpace(vertices.get(0).y)))),red);
    }

}
