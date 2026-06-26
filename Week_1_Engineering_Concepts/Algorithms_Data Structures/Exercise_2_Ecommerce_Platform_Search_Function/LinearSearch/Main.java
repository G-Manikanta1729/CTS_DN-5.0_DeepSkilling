import java.util.*;
public class Main {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Phone", "Electronics"),
                new Product(103, "Shoes", "Fashion"),
                new Product(104, "Watch", "Accessories"),
                new Product(105, "Keyboard", "Electronics")
        };

        SearchEngine searchEngine = new SearchEngine();

        System.out.print("Enter the product name to search: ");
        String searchKey = sc.nextLine();

        Product result = searchEngine.linearSearch(products, searchKey);

        if (result != null) {

            System.out.println("Product Found");
            System.out.println("----------------");
            System.out.println(result);

        } else {

            System.out.println("Product Not Found");

        }

    }
}