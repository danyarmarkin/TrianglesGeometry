public class Main {


    public static void main(String[] args) {
        Dot a = new Dot(4,1);
        Dot b = new Dot(3,2);
        Dot c = new Dot(7,-9);
        Triangle t = new Triangle(a, b, c);
        System.out.println("AB = "+ t.getAB());
        System.out.println("BC = "+ t.getBC());
        System.out.println("AC = "+ t.getAC());
    }
}
