import java.util.ArrayList;

public class Main {

    private static ArrayList<Triangle> mTriangles = new ArrayList<Triangle>();

    private static Dot mA = new Dot(0,0);
    private static Dot mB;
    private static Dot mC;

    public static boolean containsTriangle(ArrayList a, Triangle t){
        for(int i = 0; i < a.size(); i++){
            if (t.equals(a.get(i))){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        mB = new Dot(0,0);
        mC = new Dot(0,0);
        int end = 32;

        for (int x1 = 2; x1 <= end; x1++){
            for (int x2 = 1; x2 < end; x2++){
                for (int y1 = 1; y1 < x1; y1++){
                    for (int y2 = end; y2 > x2; y2--){

                        if(x1 == x2 || y1 == y2) continue;

                        mB.setX(x1);
                        mB.setY(y1);
                        mC.setX(x2);
                        mC.setY(y2);

                        Triangle t = new Triangle(mA, mB, mC);

                        if (containsTriangle(mTriangles, t)) continue;

                        float ab = t.getAB();
                        float bc = t.getBC();
                        float ac = t.getAC();

                        if(ab == Math.round(ab) && bc == Math.round(bc) && ac == Math.round(ac) && t.isIsosceles() == false && t.isRectangular() == false){
                            Dot d1 = new Dot(mC.getY(), mC.getX());
                            Dot d2 = new Dot(mB.getY(), mB.getX());
                            Triangle t1 = new Triangle(mA, d1, d2);
                            mTriangles.add(t);

                            System.out.println("A = ("+mA.getX()+";"+mA.getY()+")");
                            System.out.println("B = ("+mB.getX()+";"+mB.getY()+")");
                            System.out.println("C = ("+mC.getX()+";"+mC.getY()+")");

                            System.out.println("AB = "+ ab);
                            System.out.println("BC = "+ bc);
                            System.out.println("AC = "+ ac);
                            System.out.println("========================================");
                        }
                    }
                }
            }
        }
    }


}
