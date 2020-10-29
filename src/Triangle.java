public class Triangle {
    private Dot mA;
    private Dot mB;
    private Dot mC;
    private float mAB;
    private float mAC;
    private float mBC;

    Triangle(Dot a, Dot b, Dot c){
        mA = a;
        mB = b;
        mC = c;
        mAB = (float) Math.sqrt(Math.pow(mA.getX()-mB.getX(),2)+Math.pow(mA.getY()-mB.getY(),2));
        mAC = (float) Math.sqrt(Math.pow(mA.getX()-mC.getX(),2)+Math.pow(mA.getY()-mC.getY(),2));
        mBC = (float) Math.sqrt(Math.pow(mC.getX()-mB.getX(),2)+Math.pow(mC.getY()-mB.getY(),2));
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
}
