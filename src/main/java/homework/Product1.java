package homework;

import java.time.LocalDateTime;

public class Product1 {
    public int id;
    public String type;
    public double price;
    public boolean discount;
    public LocalDateTime dateTime;

    public Product1(int id, String type, double price, boolean discount, LocalDateTime dateTime) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isDiscount() {
        return discount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
