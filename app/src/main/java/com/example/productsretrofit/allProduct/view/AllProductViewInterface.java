package com.example.productsretrofit.allProduct.view;

import com.example.productsretrofit.model.Product;

import java.util.List;

public interface AllProductViewInterface {
    public void showData(List<Product> product);
    public void addProduct(Product product);
}
