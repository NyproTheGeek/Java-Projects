package com.tinysparks.geometry;

// TODO To Be Adequately Tested!!!
/**
 * Created by Nypro_PC on 03/09/2015.
 */
public class Vec2f
{
    private float x, y;

    public Vec2f() // CONSTRUCTOR
    {
        x = 0.0f;
        y = 0.0f;
    }

    public Vec2f(float x, float y) // CONSTRUCTOR
    {
        set(x, y);
    }

    public Vec2f(Vec2f vec) // CONSTRUCTOR // Another Vec2f
    {
        set(vec);
    }

    public void set(float x, float y) // SET();
    {
        this.x = x;
        this.y = y;
    }

    public void set(Vec2f vec) // SET(); // Another Vec2f
    {
        if(this != vec)
        {
            this.x = vec.getX();
            this.y = vec.getY();
        }
    }

    public void setX(float x) // SETX();
    {
        this.x = x;
    }

    public void setY(float y) // SETY();
    {
        this.y = y;
    }

    public float getX() // GETX();
    {
        return x;
    }

    public float getY() // GETY();
    {
        return y;
    }


    public boolean equals(Vec2f vec) // EQUALS();
    {
        if(x ==  vec.getX() && y == vec.getY())
            return true;
        else return false;
    }

    public float length() // LENGTH();
    {
        return (float) Math.sqrt((x*x) + (y*y));
    }


    public void normalize() // NORMALIZE();
    {
        float len = length();
        if (len > 0 || len == 1)
        {
            float invLen =  1/len;
            x *= invLen;
            y *= invLen;
        }
    }

    public Vec2f getNormal() // GETNORMAL();
    {
        Vec2f vec = new Vec2f();
        float len = length();
        if (len > 0 || len == 1)
        {
            float invLen =  1/len;
            vec.setX(x * invLen);
            vec.setY(y * invLen);
        }
        return vec;
    }


    public float dot(Vec2f vec) // DOT();
    {
        return ((x*vec.getX()) + (y*vec.getY()));
    }

    public Vec2f plus(Vec2f vec) // PLUS();
    { return new Vec2f(x + vec.getX(), y + vec.getY()); }

    public Vec2f minus(Vec2f vec) // MINUS();
    { return new Vec2f(x - vec.getX(), y - vec.getY()); }


    public void times(float scalar) // TIMES();
    {
        x *= scalar;
        y *= scalar;
    }


    @Override
    public String toString() // TOSTRING();
    {
        return "x = " + x
                + "\ny = " + y
                + "\nlength = " + length();
    }
}
