package com.capstone.AninPringleOfori.model.item;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class TShirt implements Item {
    public int id;

    @Min(value = 0, message = "price cannot be negative.")
    public double price;

    @Min(value = 0, message = "quantity cannot be negative.")
    public int quantity;

    @NotNull(message = "size must be specified.")
    public String size;

    @NotNull(message = "color must be specified.")
    public String color;

    public String description;

    public TShirt() {
    }

    public TShirt(int tShirtId, String size, String color, String description, double price, int quantity) {
        this.id = tShirtId;
        this.size = size;
        this.color = color;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TShirt tShirt = (TShirt) o;
        return Double.compare(tShirt.getPrice(), getPrice()) == 0 &&
                getQuantity() == tShirt.getQuantity() &&
                getSize().equals(tShirt.getSize()) &&
                getColor().equals(tShirt.getColor()) &&
                getDescription().equals(tShirt.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSize(), getColor(), getDescription(), getPrice(), getQuantity());
    }
}
