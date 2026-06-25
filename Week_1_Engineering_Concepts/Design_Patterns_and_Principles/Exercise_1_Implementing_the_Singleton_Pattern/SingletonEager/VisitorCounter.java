public class VisitorCounter {

    // Single object created immediately
    private static VisitorCounter instance =
            new VisitorCounter();

    private int visitors = 0;

    // Private constructor
    private VisitorCounter() {
        System.out.println("VisitorCounter Created");
    }

    // Public method to access the object
    public static VisitorCounter getInstance() {
        return instance;
    }

    public void addVisitor() {
        visitors++;
    }

    public int getVisitors() {
        return visitors;
    }
}