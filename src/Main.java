import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Main {

    private static ArrayList<Triangle> mTriangles = new ArrayList<Triangle>();

    private static Dot mA = new Dot(0,0);
    private static Dot mB;
    private static Dot mC;
    private static int end = 512;
    private static int mFileIndex = 1;
    private static int mCurrentIndex = 1;

    private static PrintWriter mPrintWriter;

    public static boolean containsTriangle(ArrayList a, Triangle t){
        for(int i = 0; i < a.size(); i++){
            if (t.equals(a.get(i))){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        mPrintWriter = new PrintWriter("output1.txt", "UTF-8");

        mB = new Dot(0,0);
        mC = new Dot(0,0);


        for (int x1 = 2; x1 <= end; x1++){
            for (int x2 = 1; x2 < end; x2++){
                if (x1 == x2) continue;
                for (int y1 = 1; y1 < x1; y1++){
                    for (int y2 = end; y2 > 0; y2--){
                        if (x1/x2 == y1/y2) continue;
                        drawVirtualTriangle(x1, x2, y1, y2);
                    }
                }
            }
        }
        mPrintWriter.close();

    }

    public static void drawVirtualTriangle(int x1, int x2, int y1, int y2) throws FileNotFoundException, UnsupportedEncodingException {

        if(x1 == x2 || y1 == y2) return;

        mB.setX(x1);
        mB.setY(y1);
        mC.setX(x2);
        mC.setY(y2);

        Triangle t = new Triangle(mA, mB, mC);

        if (containsTriangle(mTriangles, t)) return;

        float ab = t.getAB();
        float bc = t.getBC();
        float ac = t.getAC();

        if(ab == Math.round(ab) && bc == Math.round(bc) && ac == Math.round(ac) && t.isIsosceles() == false && t.isRectangular() == false){
            float j;
            if (x1 % 3 == 0 && y1 % 3 == 0 && x2 % 3 == 0 && y2 % 3 == 0 && ab % 3 == 0 && bc % 3 == 0 && ac % 3 == 0 ){
                j = 1/3f;
            } else {
                j = 1;
            }
            for (int i = 1; i <= Math.round(end/t.getLongestSize())+1; i+=j){
                Dot d1 = new Dot(mB.getX()*i, mB.getY()*i);
                Dot d2 = new Dot(mC.getX()*i, mC.getY()*i);
                Triangle t1 = new Triangle(mA, d1, d2);
                mTriangles.add(t1);
            }

            if (mCurrentIndex == 146){
                mPrintWriter.close();
                mFileIndex++;
                mPrintWriter = new PrintWriter("output"+mFileIndex+".txt", "UTF-8");
            }

            System.out.println("A = ("+mA.getX()+";"+mA.getY()+")");
            System.out.println("B = ("+mB.getX()+";"+mB.getY()+")");
            System.out.println("C = ("+mC.getX()+";"+mC.getY()+")");

            System.out.println("AB = "+ ab);
            System.out.println("BC = "+ bc);
            System.out.println("AC = "+ ac);
            System.out.println("========================================");

            mPrintWriter.println("A = ("+mA.getX()+";"+mA.getY()+")");
            mPrintWriter.println("B = ("+mB.getX()+";"+mB.getY()+")");
            mPrintWriter.println("C = ("+mC.getX()+";"+mC.getY()+")");

            mPrintWriter.println("AB = "+ ab);
            mPrintWriter.println("BC = "+ bc);
            mPrintWriter.println("AC = "+ ac);
            mPrintWriter.println("========================================");

            mCurrentIndex++;
        }
    }
}
