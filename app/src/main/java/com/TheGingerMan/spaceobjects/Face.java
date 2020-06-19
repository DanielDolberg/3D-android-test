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

    public Face(int color)
    {

        vertices = new ArrayList<>();
        paint = new Paint(color);
        paint.setStyle(Paint.Style.FILL);
        path = new Path();

    }

    public void setPath(Space space){

        path.moveTo((float)space.XinSpace(vertices.get(0).x),(float)space.YinSpace(vertices.get(0).y));
        path.lineTo((float)space.XinSpace(vertices.get(1).x),(float)space.YinSpace(vertices.get(1).y));
        path.lineTo((float)space.XinSpace(vertices.get(2).x),(float)space.YinSpace(vertices.get(2).y));
        path.lineTo((float)space.XinSpace(vertices.get(3).x),(float)space.YinSpace(vertices.get(3).y));
        path.close();

        /*
        path.moveTo(500,500);
        path.lineTo(600,400);
        path.lineTo(700,500);
        path.lineTo(700,800);
        path.lineTo(500,800);
        path.lineTo(500,500);
        path.close();

         */
    }

    public void draw(Canvas canvas)
    {
        canvas.drawPath(path, paint);
    }
}
