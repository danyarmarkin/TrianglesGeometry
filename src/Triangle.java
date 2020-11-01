import java.util.Objects;

public class Triangle {
    private Dot mA;
    private Dot mB;
    private Dot mC;
    private float mAB;
    private float mAC;
    private float mBC;
    private boolean mIsIsosceles = false;
    private boolean mIsRectangular = false;
    private float mLongestSize;

    Triangle(Dot a, Dot b, Dot c){
        mA = a;
        mB = b;
        mC = c;
        mAB = (float) Math.sqrt(Math.pow(mA.getX()-mB.getX(),2)+Math.pow(mA.getY()-mB.getY(),2));
        mAC = (float) Math.sqrt(Math.pow(mA.getX()-mC.getX(),2)+Math.pow(mA.getY()-mC.getY(),2));
        mBC = (float) Math.sqrt(Math.pow(mC.getX()-mB.getX(),2)+Math.pow(mC.getY()-mB.getY(),2));
        if (mAB == mBC || mAB == mAC || mBC == mAC){
            mIsIsosceles = true;
        }
        if (Math.sqrt(Math.pow(mAB, 2) + Math.pow(mBC, 2)) == mAC ||
                Math.sqrt(Math.pow(mAB, 2) + Math.pow(mAC, 2)) == mBC ||
                Math.sqrt(Math.pow(mAC, 2) + Math.pow(mBC, 2)) == mAB ){
            mIsRectangular = true;
        }
        if (mAB > mBC && mAB > mAC){
            mLongestSize = mAB;
        } else if (mBC > mAC){
            mLongestSize = mBC;
        } else {
            mLongestSize = mAC;
        }
    }

    public Dot getA() {
        return mA;
    }

    public void setA(Dot a) {
        mA = a;
    }

    public Dot getB() {
        return mB;
    }

    public void setB(Dot b) {
        mB = b;
    }

    public Dot getC() {
        return mC;
    }

    public void setC(Dot c) {
        mC = c;
    }

    public float getAB() {
        return mAB;
    }

    public float getAC() {
        return mAC;
    }

    public float getBC() {
        return mBC;
    }

    public boolean isIsosceles() {
        return mIsIsosceles;
    }

    public boolean isRectangular() {
        return mIsRectangular;
    }

    public float getLongestSize() {
        return mLongestSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return (Float.compare(triangle.mAB, mAB) == 0 &&
                        Float.compare(triangle.mAC, mAC) == 0 &&
                        Float.compare(triangle.mBC, mBC) == 0)||
                (Float.compare(triangle.mAB, mBC) == 0 &&
                        Float.compare(triangle.mBC, mAC) == 0 &&
                        Float.compare(triangle.mAC, mAB) == 0)||
                (Float.compare(triangle.mAB, mAC) == 0 &&
                        Float.compare(triangle.mBC, mAB) == 0 &&
                        Float.compare(triangle.mAC, mBC) == 0)||
                (Float.compare(triangle.mAB, mAC) == 0 &&
                        Float.compare(triangle.mAC, mAB) == 0 &&
                        Float.compare(triangle.mBC, mBC) == 0)||
                (Float.compare(triangle.mAB, mBC) == 0 &&
                        Float.compare(triangle.mBC, mAB) == 0 &&
                        Float.compare(triangle.mAC, mAC) == 0)||
                (Float.compare(triangle.mAB, mAB) == 0 &&
                        Float.compare(triangle.mBC, mAC) == 0 &&
                        Float.compare(triangle.mAC, mBC) == 0);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mA, mB, mC, mAB, mAC, mBC, mIsIsosceles, mIsRectangular);
    }
}
