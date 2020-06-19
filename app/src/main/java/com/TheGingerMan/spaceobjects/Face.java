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
        }

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
