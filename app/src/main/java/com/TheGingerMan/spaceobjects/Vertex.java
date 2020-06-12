package com.TheGingerMan.spaceobjects;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Vertex extends Vector{

    public Vertex(float x, float y, float z) {
        super(x, y, z);
    }


    public void draw(Canvas canvas, Paint p, Space space){
        canvas.drawCircle(space.XinSpace(x),space.YinSpace(y),20,p);
    }
}
