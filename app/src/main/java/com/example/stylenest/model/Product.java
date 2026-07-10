package com.example.stylenest.model;

public class Product {
    private String id;
    private String name;
    private String price;
    private int imageResource;
    private String rating;
    private String originalPrice;
    private String discount;
    private String reviewCount;
    private String description;
    private String category;

    public Product(String id, String name, String price, int imageResource) {
        this(id, name, price, imageResource, "4.5", "No description available.");
    }

    public Product(String id, String name, String price, int imageResource, String rating) {
        this(id, name, price, imageResource, rating, "No description available.");
    }

    public Product(String id, String name, String price, int imageResource, String rating, String description) {
        this(id, name, price, imageResource, rating, description, "Other");
    }

    public Product(String id, String name, String price, int imageResource, String rating, String description, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageResource = imageResource;
        this.rating = rating;
        this.description = description;
        this.category = category;
    }

    public Product(String id, String name, String price, String originalPrice, String discount, int imageResource, String rating, String reviewCount, String description) {
        this(id, name, price, originalPrice, discount, imageResource, rating, reviewCount, description, "Other");
    }

    public Product(String id, String name, String price, String originalPrice, String discount, int imageResource, String rating, String reviewCount, String description, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.originalPrice = originalPrice;
        this.discount = discount;
        this.imageResource = imageResource;
        this.rating = rating;
        this.reviewCount = reviewCount;
        this.description = description;
        this.category = category;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getPrice() { return price; }
    public int getImageResource() { return imageResource; }
    public String getRating() { return rating; }
    public String getOriginalPrice() { return originalPrice; }
    public String getDiscount() { return discount; }
    public String getReviewCount() { return reviewCount; }
    public String getDescription() { return description; }
    public String getCategory() { return category; }
}
