package com.sunshine.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    private String id;
    private Date createDate;
    private Date modifyDate;
    private String productName;
    private String productTitle;
    private BigDecimal productPrice;
    private int productCount;
    private String productType;
    private String productColor;
    private double productWeight;
    private int productStatus;

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                ", productName='" + productName + '\'' +
                ", productTitle='" + productTitle + '\'' +
                ", productPrice=" + productPrice +
                ", productCount=" + productCount +
                ", productType='" + productType + '\'' +
                ", productColor='" + productColor + '\'' +
                ", productWeight=" + productWeight +
                ", productStatus=" + productStatus +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public double getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(double productWeight) {
        this.productWeight = productWeight;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }
}