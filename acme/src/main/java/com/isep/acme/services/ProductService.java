package com.isep.acme.services;


import com.isep.acme.model.Product;
import com.isep.acme.model.ProductDTO;


public interface ProductService {

    ProductDTO create(final Product manager, final Long userId);

    void approveProduct(final String sku, final Long userId);
    
    ProductDTO updateBySku(final String sku, final Product product);
    
    void deleteBySku(final String sku);

}
