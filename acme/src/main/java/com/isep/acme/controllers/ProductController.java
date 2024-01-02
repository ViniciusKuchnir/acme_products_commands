package com.isep.acme.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.isep.acme.model.Product;
import com.isep.acme.model.ProductApprovals;
import com.isep.acme.model.ProductDTO;
import com.isep.acme.services.ProductService;



@Tag(name = "Product", description = "Endpoints for managing  products")
@RestController
@RequestMapping("/products")
class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService service;

    @Operation(summary = "creates a product")
    @PostMapping("/{userId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<ProductDTO> create(@RequestBody Product manager, @PathVariable Long userId) {
        try {
            final ProductDTO product = service.create(manager, userId);
            return new ResponseEntity<ProductDTO>(product, HttpStatus.ACCEPTED);
        }
        catch( Exception e ) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Product must have a unique SKU.");
        }
    }

    @Operation(summary = "Approve a product")
    @PostMapping("/approveProduct")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Product> approveProduct(@RequestBody ProductApprovals request){
            service.approveProduct(request.getSku(), request.getUserId());
            return ResponseEntity.accepted().build();
    }


    @Operation(summary = "updates a product")
    @PatchMapping(value = "/{sku}")
    public ResponseEntity<ProductDTO> Update(@PathVariable("sku") final String sku, @RequestBody final Product product) {

        final ProductDTO productDTO = service.updateBySku(sku, product);

        if( productDTO == null )
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Product not found.");
        else
            return ResponseEntity.accepted().body(productDTO);
    }

    @Operation(summary = "deletes a product")
    @DeleteMapping(value = "/{sku}")
    public ResponseEntity<Product> delete(@PathVariable("sku") final String sku ){

        service.deleteBySku(sku);
        return ResponseEntity.accepted().build();
    }
}