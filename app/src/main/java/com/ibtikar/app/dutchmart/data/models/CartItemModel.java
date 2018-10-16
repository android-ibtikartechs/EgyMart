package com.ibtikar.app.dutchmart.data.models;

public class CartItemModel {
    private String productName;
    private Integer quantity;
    private Integer priceForTotalQuantity;
    private String ImageUrl;
    private String id;
    private Integer priceForUnit;

    public CartItemModel(String productName, Integer priceForUnit, Integer quantity, String ImageUrl, String id) {
        this.productName = productName;
        this.quantity = quantity;
        this.ImageUrl = ImageUrl;
        this.id = id;
        this.priceForUnit = priceForUnit;
    }

    public Integer getPriceForUnit() {
        return priceForUnit;
    }



    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPriceForTotalQuantity(Integer priceForTotalQuantity) {
        this.priceForTotalQuantity = priceForTotalQuantity;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getPriceForTotalQuantity() {
        return getQuantity() * getPriceForUnit();
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public String getId() {
        return id;
    }
}
