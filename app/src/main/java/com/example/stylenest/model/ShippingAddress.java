package com.example.stylenest.model;

public class ShippingAddress {
    private String type;
    private String userName;
    private String details;
    private String phone;
    private int iconRes;
    private boolean isDefault;
    private boolean isSelected;

    public ShippingAddress(String type, String userName, String details, String phone, int iconRes, boolean isDefault, boolean isSelected) {
        this.type = type;
        this.userName = userName;
        this.details = details;
        this.phone = phone;
        this.iconRes = iconRes;
        this.isDefault = isDefault;
        this.isSelected = isSelected;
    }

    public String getType() { return type; }
    public String getUserName() { return userName; }
    public String getDetails() { return details; }
    public String getPhone() { return phone; }
    public int getIconRes() { return iconRes; }
    public boolean isDefault() { return isDefault; }
    public boolean isSelected() { return isSelected; }
    public void setSelected(boolean selected) { isSelected = selected; }
}