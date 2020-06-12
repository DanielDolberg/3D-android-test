package com.TheGingerMan.spaceobjects;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Edge {
    Vertex v1,v2;

    public Edge(Vertex v1, Vertex v2)
    {
        this.v1 = v1;
        this.v2 =v2;
    }


    public void draw(Canvas canvas, Paint p,Space space)
    {
        canvas.drawLine(space.XinSpace(v1.x),space.YinSpace(v1.y),space.XinSpace(v2.x),space.YinSpace(v2.y),p);
    }
}
