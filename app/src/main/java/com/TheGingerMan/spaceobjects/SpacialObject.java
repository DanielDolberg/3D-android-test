package com.TheGingerMan.spaceobjects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;

public class SpacialObject {

    Pivot pivot;
    Vertex[] vertices;
    Edge[] edges;
    Space localSpace;
    Paint red;
    Paint blue;


    public SpacialObject(Pivot pivot) {
        this.pivot = pivot;


        red = new Paint();
        red.setColor(Color.RED);
        red.setStrokeWidth(20);

        blue = new Paint();
        blue.setColor(Color.BLUE);
        blue.setStrokeWidth(20);
    }

    public void move(float dx, float dy,float dz)
    {
        pivot.vector.x+=dx;
        pivot.vector.y+=dy;
        pivot.vector.z+=dz;

        for (int i = 0; i < vertices.length ; i++) {
            vertices[i].x+=dx;
            vertices[i].y+=dy;
            vertices[i].z+=dz;
        }
    }

    public void rotateGlobalZ(float na)
    {
        float x1,x2,y1,y2,fx,fy,angle;
        x1 = pivot.vector.x;
        y1 = pivot.vector.y;
        float r;

        for (int i = 0; i < vertices.length; i++) {
            x2 = vertices[i].x;
            y2 = vertices[i].y;

            angle = Math.abs(y2/x2);
            angle = y2/x2;
            angle = (float)Math.atan(angle);

            r = (x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2);
            r = (float)Math.sqrt(r);
            }


    }


    public void draw(Canvas canvas, Space space) {

        for (int i = 0; i < edges.length ; i++) {
            edges[i].draw(canvas,red,space);
        }

        for (int i = 0; i < vertices.length; i++) {
            vertices[i].draw(canvas,blue,space);
        }

        //canvas.drawCircle(space.XinSpace(pivot.vector.x),space.YinSpace(pivot.vector.y),(float) Math.sqrt(((space.XinSpace(pivot.vector.x) -space.XinSpace(vertices[0].x))*(space.XinSpace(pivot.vector.x) - space.XinSpace(vertices[0].x)) + (space.YinSpace(pivot.vector.y) - space.YinSpace(vertices[0].y))*(space.YinSpace(pivot.vector.y) - space.YinSpace(vertices[0].y)))),red);
    }

}
