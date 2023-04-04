import homework.Product1;
import homework.Product2;
import homework.ProductList;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        List<Product1> products1 = new ArrayList<>();
        Product1 product1 = new Product1(1, "Book", 265, true, LocalDateTime.now().minusDays(1));
        Product1 product2 = new Product1(2, "TV", 243, false, LocalDateTime.now().minusDays(2));
        Product1 product3 = new Product1(3, "Book", 50, false, LocalDateTime.now().minusDays(3));
        Product1 product4 = new Product1(4, "PC", 736, false, LocalDateTime.now().minusDays(4));
        Product1 product5 = new Product1(4, "Book", 75, true, LocalDateTime.now().minusDays(4));

        products1.add(product1);
        products1.add(product2);
        products1.add(product3);
        products1.add(product4);
        products1.add(product5);

        List<Product2> products2 = new ArrayList<>();
        Product2 product6 = new Product2("Book", 100, true);
        Product2 product7 = new Product2("IPad", 1111, false);
        Product2 product8 = new Product2("Headphones", 236, true);

        products2.add(product6);
        products2.add(product7);
        products2.add(product8);

        ProductList productList = new ProductList();

        System.out.println("Expensive books");
        List<Product1> expensiveBooks = productList.getExpensiveBooks(products1);
        for (Product1 product : expensiveBooks) {
            System.out.println("Type: " + product.getType()
                    + ", price: " + product.getPrice());
        }

        System.out.println();

        System.out.println("Discounted books");
        List<Product2> discountedBooks = productList.getDiscountedBooks(products2);
        for (Product2 product : discountedBooks) {
            System.out.println("Type: " + product.getType() + ", price: " + product.getPrice() + ", discount: " + product.isDiscount());
        }

        System.out.println();

        System.out.println("Cheapest books");
        try {
            Product1 product = productList.getCheapesBook(products1);
            System.out.println("Type: " + product.getType() + ", price: " + product.getPrice() + ", discount: " + product.isDiscount());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        System.out.println("Last three products");
        List<Product1> lastThreeProducts = productList.getLastThreeProducts(products1);
        for (Product1 product : lastThreeProducts) {
            System.out.println("Type: " + product.getType() + ", price: " + product.getPrice() + ", discount: "
                    + product.isDiscount() + ", date of appearance: " + product.getDateTime());
        }

        System.out.println();
        double totalPrice = productList.totalPriceCalculation(products1);
        System.out.println("Total price: " + totalPrice);

        System.out.println();

        System.out.println("Products by type");
        Map<String, List<Product1>> productsByType = productList.groupByType(products1);
        for (Map.Entry<String, List<Product1>> entry : productsByType.entrySet()) {
            System.out.println(entry.getKey() + ": ");
            for (Product1 product : entry.getValue()) {
                System.out.println("Id: " + product.getId() + ", type: " + product.getType() + ", price: " + product.getPrice() +
                        ", discount: " + product.isDiscount() + ", date of appearance: " + product.getDateTime());
            }
        }
    }
}
