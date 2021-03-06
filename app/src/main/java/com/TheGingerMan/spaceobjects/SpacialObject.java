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
    ArrayList<Face> facesInDrawingOrder;
    Space globalSpace;
    Paint red;
    Paint blue;

    int state; //1=wireframe 2=solid 3=material only

    boolean candraw;


    public SpacialObject(Pivot pivot) {
        this.pivot = pivot;

        vertices = new ArrayList<>();
        edges = new ArrayList<>();
        faces = new ArrayList<>();
        facesInDrawingOrder = new ArrayList<>();


        red = new Paint();
        red.setColor(Color.RED);
        red.setStrokeWidth(20);
        red.setStyle(Paint.Style.STROKE);

        blue = new Paint();
        blue.setColor(Color.BLUE);
        blue.setStrokeWidth(20);

        state = 2;
    }

    public void move(float dx, float dy, float dz) {
        pivot.vector.x += dx;
        pivot.vector.y += dy;
        pivot.vector.z += dz;

        for (int i = 0; i < vertices.size(); i++) {
            vertices.get(i).x += dx;
            vertices.get(i).y += dy;
            vertices.get(i).z += dz;
        }
    }

    public void moveTo(float dx, float dy, float dz) {
        pivot.vector.x = dx;
        pivot.vector.y = dy;
        pivot.vector.z = dz;

        for (int i = 0; i < vertices.size(); i++) {
            vertices.get(i).x += pivot.vector.x;
            vertices.get(i).y += pivot.vector.y;
            vertices.get(i).z += pivot.vector.z;
        }
    }


    public void rotateGlobalX(double angle) {
        double z1, z2, y1, y2, o, ne;
        z1 = pivot.vector.z;
        y1 = pivot.vector.y;
        double r;

        for (int i = 0; i < vertices.size(); i++) {
            z2 = vertices.get(i).z;
            y2 = vertices.get(i).y;

            r = (z1 - z2) * (z1 - z2) + (y1 - y2) * (y1 - y2);
            r = Math.sqrt(r);

            o = Math.asin(y1 - y2 / r);

            if (z2 < z1)
                o = Math.PI - o;
            else if (y2 > y1)
                o = 2 * Math.PI + o;

            ne = Math.toRadians(angle);
            ne += o;

            vertices.get(i).z = r * Math.cos(ne);
            vertices.get(i).y = -r * Math.sin(ne);
        }
        // updateFaces();
    }

    public void rotateGlobalY(double angle) {
        double x1, x2, z1, z2, o, ne;
        x1 = pivot.vector.x;
        z1 = pivot.vector.z;
        double r;

        for (int i = 0; i < vertices.size(); i++) {
            x2 = vertices.get(i).x;
            z2 = vertices.get(i).z;

            r = (x1 - x2) * (x1 - x2) + (z1 - z2) * (z1 - z2);
            r = Math.sqrt(r);

            o = Math.asin(z1 + z2 / r);

            if (x2 < x1)
                o = Math.PI - o;
            else if (z2 < z1)
                o = 2 * Math.PI + o;

            ne = Math.toRadians(angle);
            ne += o;

            vertices.get(i).x = r * Math.cos(ne);
            vertices.get(i).z = r * Math.sin(ne);
        }
        //updateFaces();
    }

    public void rotateGlobalZ(double angle) {
        double x1, x2, y1, y2, o, ne;
        x1 = pivot.vector.x;
        y1 = pivot.vector.y;
        double r;

        for (int i = 0; i < vertices.size(); i++) {
            x2 = vertices.get(i).x;
            y2 = vertices.get(i).y;

            r = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
            r = Math.sqrt(r);

            o = Math.asin(y1 - y2 / r);

            if (x2 < x1)
                o = Math.PI - o;
            else if (y2 > y1)
                o = 2 * Math.PI + o;

            ne = Math.toRadians(angle);
            ne += o;

            vertices.get(i).x = r * Math.cos(ne);
            vertices.get(i).y = -r * Math.sin(ne);
        }
        //updateFaces();
    }




    public void updateFaces() {


        for (int i = 0; i < faces.size(); i++) {
            faces.get(i).setPath(globalSpace);
        }

        /*
        facesInDrawingOrder = new ArrayList<>();
        for (int i = 0; i < faces.size(); i++) {
            facesInDrawingOrder.add(null);
        }

        Face f;
        int c;

        for (int i = 0; i < faces.size(); i++) {
            f = faces.get(i);
            c = 0;
            f.setPath(globalSpace);
            for (int j = 0; j < faces.size(); j++) {
                if (f.z > faces.get(j).z)
                    c++;
            }
            facesInDrawingOrder.set(c, f);
        }

         */

    } //REQUIRES SERIOUS TWEAKING

    public void draw(Canvas canvas, Space space) {
        updateFaces();
        if(state!=1) {
            for (int i = 0; i < faces.size(); i++) {
                faces.get(i).draw(canvas);
            }
        }

        if(state!=3) {
            for (int i = 0; i < edges.size(); i++) {
                edges.get(i).draw(canvas, red, space);
            }

            for (int i = 0; i < vertices.size(); i++) {
                vertices.get(i).draw(canvas, blue, space);
            }
        }



        //canvas.drawCircle((float)(space.XinSpace(pivot.vector.x)),(float)(space.YinSpace(pivot.vector.y)),(float) Math.sqrt(((space.XinSpace(pivot.vector.x) -space.XinSpace(vertices.get(0).x))*(space.XinSpace(pivot.vector.x) - space.XinSpace(vertices.get(0).x)) + (space.YinSpace(pivot.vector.y) - space.YinSpace(vertices.get(0).y))*(space.YinSpace(pivot.vector.y) - space.YinSpace(vertices.get(0).y)))),red);
    }

}
