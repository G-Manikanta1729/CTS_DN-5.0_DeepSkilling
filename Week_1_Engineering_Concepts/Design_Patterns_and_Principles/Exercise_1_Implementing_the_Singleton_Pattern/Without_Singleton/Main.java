public class Main {

    public static void main(String[] args) {

        VisitorCounter counter1 = new VisitorCounter();
        VisitorCounter counter2 = new VisitorCounter();

        counter1.addVisitor();
        counter1.addVisitor();

        counter2.addVisitor();

        System.out.println("Counter1 Visitors: "
                + counter1.getVisitors());

        System.out.println("Counter2 Visitors: "
                + counter2.getVisitors());

        System.out.println(counter1);
        System.out.println(counter2);
    }
}