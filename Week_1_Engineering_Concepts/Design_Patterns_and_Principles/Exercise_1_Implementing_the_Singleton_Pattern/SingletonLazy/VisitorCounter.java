public class VisitorCounter {

    private static VisitorCounter instance;

    private int visitors = 0;

    private VisitorCounter() {
        System.out.println("VisitorCounter Created");
    }

    public static VisitorCounter getInstance() {

        if(instance == null) {
            instance = new VisitorCounter();
        }

        return instance;
    }

    public void addVisitor() {
        visitors++;
    }

    public int getVisitors() {
        return visitors;
    }
}