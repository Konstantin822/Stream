package homework;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductList {
    public List<Product1> getExpensiveBooks(List<Product1> product1s) {
        return product1s.stream()
                .filter(product1 -> product1.getType().equals("Book") && product1.getPrice() > 250)
                .collect(Collectors.toList());
    }

    public List<Product2> getDiscountedBooks(List<Product2> product1s) {
        return product1s.stream()
                .filter(product2 -> product2.getType().equals("Book") && product2.isDiscount())
                .map(product2 -> new Product2(product2.getType(), product2.getPrice() * 0.9, product2.isDiscount()))
                .collect(Collectors.toList());
    }

    public Product1 getCheapesBook(List<Product1> product1s) throws Exception {
        return product1s.stream()
                .filter(product1 -> product1.getType().equals("Book"))
                .min(Comparator.comparing(Product1::getPrice))
                .orElseThrow(() -> new Exception("Продукт [категорія: ім'я_категорії] не знайдено"));
    }

    public List<Product1> getLastThreeProducts(List<Product1> product1s) {
        return product1s.stream()
                .sorted(Comparator.comparing(Product1::getDateTime).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    public double totalPriceCalculation(List<Product1> product1s) {
        LocalDate localDate = LocalDate.now();
        return product1s.stream()
                .filter(product1 -> product1.getType().equals("Book"))
                .filter(product1 -> product1.getPrice() <= 75)
                .filter(product1 -> product1.getDateTime().getYear() == localDate.getYear())
                .mapToDouble(product1 -> product1.isDiscount() ? product1.getPrice() * 0.9 : product1.getPrice())
                .sum();
    }

    public Map<String, List<Product1>> groupByType(List<Product1> product1s) {
        return product1s.stream()
                .collect(Collectors.groupingBy(Product1::getType));
    }
}
