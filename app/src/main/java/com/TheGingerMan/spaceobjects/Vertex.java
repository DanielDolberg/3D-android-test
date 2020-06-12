package com.TheGingerMan.spaceobjects;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Vertex extends Vector{

    public Vertex(double x, double y, double z) {
        super(x, y, z);
    }


    public void draw(Canvas canvas, Paint p, Space space){
        canvas.drawCircle((float)(space.XinSpace(x)),(float)(space.YinSpace(y)),20,p);
    }
}
