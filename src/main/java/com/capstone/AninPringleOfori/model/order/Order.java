package com.capstone.AninPringleOfori.model.order;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Order {
    @NotNull(message = "name must be specified.")
    public String name;

    @NotNull(message = "street must be specified.")
    public String street;

    @NotNull(message = "city must be specified.")
    public String city;

    @NotNull(message = "state must be specified.")
    public String state;

    @NotNull(message = "zipCode must be specified.")
    public String zipCode;

    @NotNull(message = "itemType must be specified.")
    public String itemType;

    @NotNull(message = "itemId must be specified.")
    public int itemId;

    @Min(value = 1, message = "Quantity cannot be less than 1.")
    public int quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
