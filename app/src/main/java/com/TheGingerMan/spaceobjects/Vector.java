package com.TheGingerMan.spaceobjects;

public class Vector {

    float x, y, z;

    public Vector(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
        z=0;
    }

}
