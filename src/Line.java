public class Line {
    private float mK;

    Line(float k){
        mK = k;
    }

    public float getK() {
        return mK;
    }

    public float getY(long x){
        return x*mK;
    }
}
