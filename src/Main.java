public class Main {

    private static Dot mA = new Dot(0,0);
    private static Dot mB;
    private static Dot mC;

    public static void main(String[] args) {
        mB = new Dot(0,0);
        mC = new Dot(0,0);
        long end = 1024;

        // Create first line
        for (long k1 = 1; k1 <= end; k1++){
            Line line1 = new Line(1/k1);

            // Create second line
            for (float k2 = end; k2 >= 1; k2--){
                Line line2 = new Line(k2);

                // Travel values on first line
                for (long x1 = k1; x1 <= end*end*k1; x1+=k1){
                    long y1 = (long) line1.getY(x1);

                    // Travel values on second line
                    for (long x2 = 1; x2<=end*k2; x2++){
                        long y2 = (long) line2.getY(x2);

                        // Init dots
                        mB.setX(x1);
                        mB.setY(y1);
                        mC.setX(x2);
                        mC.setY(y2);

                        // Create triangle
                        Triangle t = new Triangle(mA, mB, mC);

                        float ab = t.getAB();
                        float bc = t.getBC();
                        float ac = t.getAC();

                        if(ab % 1 == 0 && bc % 1 == 0 && ac % 1 == 0){
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
