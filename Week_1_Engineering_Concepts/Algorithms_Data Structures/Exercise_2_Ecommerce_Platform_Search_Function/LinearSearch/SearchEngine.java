public class SearchEngine {

    public Product linearSearch(Product[] products, String searchKey) {

        for (Product product : products) {

            if (product.getProductName().equalsIgnoreCase(searchKey)) {
                return product;
            }

        }

        return null;
    }
}