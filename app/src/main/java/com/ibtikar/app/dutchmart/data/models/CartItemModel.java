package com.ibtikar.app.dutchmart.data.models;

public class CartItemModel {
    private String productName;
    private Integer quantity;
    private Integer priceForTotalQuantity;
    private String ImageUrl;
    private String id;

    public CartItemModel(String productName, Integer quantity, Integer priceForTotalQuantity, String ImageUrl, String id) {
        this.productName = productName;
        this.quantity = quantity;
        this.priceForTotalQuantity = priceForTotalQuantity;
        this.ImageUrl = ImageUrl;
        this.id = id;
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
        return priceForTotalQuantity;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public String getId() {
        return id;
    }
}
