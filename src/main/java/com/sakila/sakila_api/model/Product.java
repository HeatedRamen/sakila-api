package com.sakila.sakila_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue
    private Long productId;

    private String productName;

    private Long supplierId;
    private Long categoryId;

    private String quantityPerUnit;
    private double unitPrice;
    private Long unitsInStock;
    private Long unitsOnOrder;
    private Long reorderLevel;
    private boolean discontinued;

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public boolean isDiscontinued() { return discontinued; }
    public void setDiscontinued(boolean discontinued) { this.discontinued = discontinued; }

    public Long getReorderLevel() { return reorderLevel; }
    public void setReorderLevel(Long reorderLevel) { this.reorderLevel = reorderLevel; }

    public Long getUnitsOnOrder() { return unitsOnOrder; }
    public void setUnitsOnOrder(Long unitsOnOrder) { this.unitsOnOrder = unitsOnOrder; }

    public Long getUnitsInStock() { return unitsInStock; }
    public void setUnitsInStock(Long unitsInStock) { this.unitsInStock = unitsInStock; }

    public double getUnitPrice() { return unitPrice; }
    public void setUnitPrice(double unitPrice) { this.unitPrice = unitPrice; }

    public String getQuantityPerUnit() { return quantityPerUnit; }
    public void setQuantityPerUnit(String quantityPerUnit) { this.quantityPerUnit = quantityPerUnit; }

    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }

    public Long getSupplierId() { return supplierId; }
    public void setSupplierId(Long supplierId) { this.supplierId = supplierId; }
}
