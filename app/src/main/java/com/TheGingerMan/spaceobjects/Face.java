package com.TheGingerMan.spaceobjects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;

import java.util.ArrayList;

public class Face {
    ArrayList<Vertex> vertices;
    Path path;
    Paint paint;
    Picture picture;

    double x,y,z;

    public Face(int color)
    {

        vertices = new ArrayList<>();
        paint = new Paint();
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL);
        path = new Path();

    }

    public void setPath(Space space){

        if(vertices != null) {
            path.rewind();
            path.moveTo((float) space.XinSpace(vertices.get(0).x), (float) space.YinSpace(vertices.get(0).y));
            for (int i = 1; i <vertices.size() ; i++) {
                path.lineTo((float) space.XinSpace(vertices.get(i).x), (float) space.YinSpace(vertices.get(i).y));
            }
            path.close();

            setAverages();
            System.out.println("deeeeee "+x+" "+y+" "+z);
        }
    }

    public void setAverages()
    {
        double c=0;
        for (int i = 0; i < vertices.size(); i++) {
            c+=vertices.get(i).x;
        }

        x = c/vertices.size();

        c=0;
        for (int i = 0; i < vertices.size(); i++) {
            c+=vertices.get(i).y;
        }
        y = c/vertices.size();

        c=0;
        for (int i = 0; i < vertices.size(); i++) {
            c+=vertices.get(i).z;
        }
        z = c/vertices.size();
    }

    public void draw(Canvas canvas)
    {
        canvas.drawPath(path, paint);
        //canvas.clipOutPath(path);
    }
}
