import java.util.*;
public class Main {

    public static void main(String[] args) {

        // Unsorted Product Array
        Product[] products = {

                new Product(102, "Phone", "Electronics"),
                new Product(105, "Keyboard", "Electronics"),
                new Product(104, "Watch", "Accessories"),
                new Product(101, "Laptop", "Electronics"),
                new Product(103, "Shoes", "Fashion")

        };

        Scanner sc = new Scanner(System.in);

        // Create SearchEngine object
        SearchEngine searchEngine = new SearchEngine();

        // Product to search
        System.out.print("Enter the product name to search: ");
        String searchKey = sc.nextLine();

        // Perform Binary Search
        Product result = searchEngine.binarySearch(products, searchKey);

        // Display Result
        if (result != null) {

            System.out.println("Product Found");
            System.out.println("------------------------");
            System.out.println(result);

        } else {

            System.out.println("Product Not Found");

        }
    }
}