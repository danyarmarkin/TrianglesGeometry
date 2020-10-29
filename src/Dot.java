public class Dot {
    private long mX;
    private long mY;

    public void setX(long x) {
        mX = x;
    }

    public void setY(long y) {
        mY = y;
    }

    Dot(long x, long y){
        mX = x;
        mY = y;
    }

    public long getX() {
        return mX;
    }

    public long getY() {
        return mY;
    }
}
