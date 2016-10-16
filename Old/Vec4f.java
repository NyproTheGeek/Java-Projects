package com.tinysparks.geometry;

// TODO To Be Adequately Tested!!!
/**
 * Created by Nypro_PC on 03/09/2015.
 */
public class Vec4f
{
    private float x, y, z, w;

    // 10/07/15
    public Vec4f() // CONSTRUCTOR
    {
        x = 0.0f;
        y = 0.0f;
        z = 0.0f;
        w = 1.0f;
    }

    public Vec4f(final float xx) // CONSTRUCTOR
    {
        x = xx;
        y = xx;
        z = xx;
        w = 1.0f;
    }


    public Vec4f(float x, float y, float z, float w) // CONSTRUCTOR
    {
        set(x, y, z, w);
    }

    public Vec4f(Vec4f vec) // CONSTRUCTOR
    {
        set(vec);
    }

    public Vec4f(Vec3f vec) // CONSTRUCTOR
    {
        set(vec);
    }

    public void set(float x, float y, float z, float w) // SET();
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public void set(Vec4f vec) // SET();
    {
        this.x = vec.getX();
        this.y = vec.getY();
        this.z = vec.getZ();
        this.w = vec.getW();
    }

    public void set(Vec3f vec) // SET();
    {
        this.x = vec.getX();
        this.y = vec.getY();
        this.z = vec.getZ();
        this.w = 1.0f;
    }

    public void setX(float x) // SETX();
    {
        this.x = x;
    }

    public void setY(float y) // SETY();
    {
        this.y = y;
    }

    public void setZ(float z) // SETZ();
    {
        this.z = z;
    }

    public void setW(boolean w) // SETW();
    {
        if (w == true)
            this.w = 1.0f;
        else
            this.w = 0.0f;

    }

    public float getX() // GETX();
    { return x; }

    public float getY() // GETY();
    { return y; }

    public float getZ() // GETZ();
    { return z; }

    public float getW() // GETW();
    { return w; }


    public boolean equals(Vec4f vec) // EQUALS();
    {
        if(x ==  vec.getX() && y == vec.getY() && z == vec.getZ() && w == vec.w)
            return true;
        else return false;
    }

    public boolean equals(Vec3f vec) // EQUALS();
    {
        if(x ==  vec.getX() && y == vec.getY() && z == vec.getZ())
            return true;
        else return false;
    }


    public float length() // LENGTH();
    {
        float len = (float)Math.sqrt(((x*x) + (y*y) + (z*z)));
        return len;
    }


    public void normalize() // NORMALIZE();
    {
        float len = length();
        if (len > 0 || len == 1)
        {
            float invLen =  1/len;
            x *= invLen;
            y *= invLen;
            z *= invLen;
        }
    }

    public Vec4f getNormal() // GETNORMAL();
    {
        Vec4f vec = new Vec4f();
        float len = length();
        if (len > 0 || len == 1)
        {
            float invLen =  1/len;
            vec.setX(x * invLen);
            vec.setY(y * invLen);
            vec.setZ(z * invLen);
        }
        return vec;
    }


    public float dot(Vec4f vec) // DOT();
    {
        return ((x*vec.getX()) + (y*vec.getY() )+ (z*vec.getZ()));
    }

    public float dot(Vec3f vec) // DOT();
    {
        return ((x*vec.getX()) + (y*vec.getY() )+ (z*vec.getZ()));
    }

    public Vec4f cross(Vec4f vec) // CROSS();
    {
        return new Vec4f(
                (y * vec.getZ()) - (z * vec.getY()),
                (z * vec.getX()) - (x * vec.getZ()),
                (x * vec.getY()) - (y * vec.getX()),
                0.0f); // note new w is 0.0 bcos most ops are vec * vec = vec (DIRECTION!)
    }

    public Vec3f cross(Vec3f vec) // CROSS();
    {
        return new Vec3f(
                (y * vec.getZ()) - (z * vec.getY()),
                (z * vec.getX()) - (x * vec.getZ()),
                (x * vec.getY()) - (y * vec.getX()));
    }

    public Vec4f plus(Vec4f vec) // PLUS();
    { return new Vec4f(x + vec.getX(), y + vec.getY(), z + vec.getZ(),  w + vec.getW()); /* note new w is the addition of both */ }

    public Vec3f plus(Vec3f vec) // PLUS();
    { return new Vec3f(x + vec.getX(), y + vec.getY(), z + vec.getZ());}

    public Vec4f minus(Vec4f vec) // MINUS();
    { return new Vec4f(x - vec.getX(), y - vec.getY(), z - vec.getZ(), w + vec.getW()); /* note new w is the addition of both */ }

    public Vec3f minus(Vec3f vec) // MINUS();
    { return new Vec3f(x - vec.getX(), y - vec.getY(), z - vec.getZ());}

    public void times(float scalar) // TIMES();
    {
        x *= scalar;
        y *= scalar;
        z *= scalar;
    }

    @Override
    public String toString() // TOSTRING();
    {
        return "x = " + x
                + "\ny = " + y
                + "\nz = " + z
                + "\nw = " + w
                + "\nlength = " + length();
    }
}
