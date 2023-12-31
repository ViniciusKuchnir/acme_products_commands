package com.isep.acme.model;

public class ProductApprovals {
    private String sku;
    private Long userId;

    public ProductApprovals(){}

    public ProductApprovals(String sku, Long userId){
        this.sku = sku;
        this.userId = userId;
    }

    public String getSku(){
        return this.sku;
    }

    public Long getUserId(){
        return this.userId;
    }

    
}
