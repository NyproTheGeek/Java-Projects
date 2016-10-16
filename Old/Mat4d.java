package com.tinysparks.geometry;

// TODO To Be Adequately Tested!!!
/**
 * Created by Nypro_PC on 03/09/2015.
 */
public class Mat4d
{
    // F**k Java! No support for generic arrays?
    // Flimsy stupid excuses. Bunch of them.
    double m[][] = {{1.0d,0.0d,0.0d,0.0d},
            {0.0d,1.0d,0.0d,0.0d},
            {0.0d,0.0d,1.0d,0.0d},
            {0.0d,0.0d,0.0d,1.0d}};

    public Mat4d(Mat4d mat) // CONSTRUCTOR
    {
        set(mat);
    }

    public Mat4d(Mat4f mat) // CONSTRUCTOR
    {
        set(mat);
    }

    // SET()
    public void set(double a, double b, double c, double d, double e, double f, double g, double h, double i, double j, double k, double l, double m, double n, double o, double p) // SET()
    {
        this.m[0][0] = a;
        this.m[0][1] = b;
        this.m[0][2] = c;
        this.m[0][3] = d;
        this.m[1][0] = e;
        this.m[1][1] = f;
        this.m[1][2] = g;
        this.m[1][3] = h;
        this.m[2][0] = i;
        this.m[2][1] = j;
        this.m[2][2] = k;
        this.m[2][3] = l;
        this.m[3][0] = m;
        this.m[3][1] = n;
        this.m[3][2] = o;
        this.m[3][3] = p;
    }

    public void set(Mat4f mat) // SET()
    {
        this.m[0][0] = mat.m[0][0];
        this.m[0][1] = mat.m[0][1];
        this.m[0][2] = mat.m[0][2];
        this.m[0][3] = mat.m[0][3];
        this.m[1][0] = mat.m[1][0];
        this.m[1][1] = mat.m[1][1];
        this.m[1][2] = mat.m[1][2];
        this.m[1][3] = mat.m[1][3];
        this.m[2][0] = mat.m[2][0];
        this.m[2][1] = mat.m[2][1];
        this.m[2][2] = mat.m[2][2];
        this.m[2][3] = mat.m[2][3];
        this.m[3][0] = mat.m[3][0];
        this.m[3][1] = mat.m[3][1];
        this.m[3][2] = mat.m[3][2];
        this.m[3][3] = mat.m[3][3];
    }

    public void set(Mat4d mat) // SET()
    {
        this.m[0][0] = mat.m[0][0];
        this.m[0][1] = mat.m[0][1];
        this.m[0][2] = mat.m[0][2];
        this.m[0][3] = mat.m[0][3];
        this.m[1][0] = mat.m[1][0];
        this.m[1][1] = mat.m[1][1];
        this.m[1][2] = mat.m[1][2];
        this.m[1][3] = mat.m[1][3];
        this.m[2][0] = mat.m[2][0];
        this.m[2][1] = mat.m[2][1];
        this.m[2][2] = mat.m[2][2];
        this.m[2][3] = mat.m[2][3];
        this.m[3][0] = mat.m[3][0];
        this.m[3][1] = mat.m[3][1];
        this.m[3][2] = mat.m[3][2];
        this.m[3][3] = mat.m[3][3];
    }


    public void setScale(double sx, double sy, double sz) // SETSCALE()
    {
        this.m[0][0] = sy;
        this.m[1][1] = sx;
        this.m[2][2] = sz;
    }


    public void setTranslate(double tx, double ty, double tz) // SETTRANSLATE()
    {
        this.m[0][3] = tx;
        this.m[1][3] = ty;
        this.m[2][3] = tz;
    }


    public void setRotate() // SETROTATE()
    {
        // TODO I've learnt rotation matrix but yet to implement it
    }

    public void setIdentity() // SETIDENTITY()
    {
        this.m[0][0] = 1.0d;
        this.m[0][1] = 0.0d;
        this.m[0][2] = 0.0d;
        this.m[0][3] = 0.0d;
        this.m[1][0] = 0.0d;
        this.m[1][1] = 1.0d;
        this.m[1][2] = 0.0d;
        this.m[1][3] = 0.0d;
        this.m[2][0] = 0.0d;
        this.m[2][1] = 0.0d;
        this.m[2][2] = 1.0d;
        this.m[2][3] = 0.0d;
        this.m[3][0] = 0.0d;
        this.m[3][1] = 0.0d;
        this.m[3][2] = 0.0d;
        this.m[3][3] = 1.0d;
    }


    public double get(int row, int col) // GET()
    {
        return m[row][col];
    }




    public Vec4f times(Vec4f vec) // TIMES()
    {
        return new Vec4f ((float)(vec.getX()*m[0][0] + vec.getY()*m[0][1] + vec.getZ()*m[0][2] + vec.getW()*m[0][3]),
                (float)(vec.getX()*m[1][0] + vec.getY()*m[1][1] + vec.getZ()*m[1][2] + vec.getW()*m[1][3]),
                (float)(vec.getX()*m[2][0] + vec.getY()*m[2][1] + vec.getZ()*m[2][2] + vec.getW()*m[2][3]),
                (float)(vec.getW()*m[3][3])); // only w * M_3,3 is really needed here
    }


    public void invert() // INVERT()
    {
        // TODO
    }


    @Override
    public String toString() // TOSTRING()
    {
        String endl = System.getProperty("line.separator");
        return "(" +
                get(0, 0) + ", " + get(0, 1) + ", " + get(0, 2) + ", " + get(0, 3) + endl +
                get(1, 0) + ", " + get(1, 1) + ", " + get(1, 2) + ", " + get(1, 3) + endl +
                get(2, 0) + ", " + get(2, 1) + ", " + get(2, 2) + ", " + get(2, 3) + endl +
                get(3, 0) + ", " + get(3, 1) + ", " + get(3, 2) + ", " + get(3, 3) + ")";
    }


	/*
	public void set(double coeffs[]) // SET()
	{
		if (coeffs.length != 16 )
			System.out.print("Cannot be more than 4");// throw exception instead
		for(int i = 0; i < 16; i++)
		{
			for(int row = 0; row < 4; row++)
			{
				for(int col = 0; col < 4; col++)
				{
					m[row] [col] = coeffs[i];
				}
			}
		}
	}
	*/

}

