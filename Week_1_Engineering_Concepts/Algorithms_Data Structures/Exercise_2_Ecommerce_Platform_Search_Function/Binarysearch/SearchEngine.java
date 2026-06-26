public class SearchEngine {

    // Bubble Sort based on Product Name
    private void sortProducts(Product[] products) {

        for (int i = 0; i < products.length - 1; i++) {

            for (int j = 0; j < products.length - i - 1; j++) {

                if (products[j].getProductName()
                        .compareToIgnoreCase(products[j + 1].getProductName()) > 0) {

                    // Swap the products
                    Product temp = products[j];
                    products[j] = products[j + 1];
                    products[j + 1] = temp;
                }
            }
        }
    }

    // Binary Search
    public Product binarySearch(Product[] products, String searchKey) {

        // Step 1: Sort the products
        sortProducts(products);

        // Step 2: Perform Binary Search
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            int comparison = products[mid]
                    .getProductName()
                    .compareToIgnoreCase(searchKey);

            if (comparison == 0) {

                return products[mid];

            } else if (comparison < 0) {

                left = mid + 1;

            } else {

                right = mid - 1;

            }
        }

        return null;
    }
}