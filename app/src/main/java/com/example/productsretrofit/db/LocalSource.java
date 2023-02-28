package com.example.productsretrofit.db;

import androidx.lifecycle.LiveData;

import com.example.productsretrofit.model.Product;

import java.util.List;

public interface LocalSource {
    void insertProduct(Product product);
    void deleteProduct(Product product);

    LiveData<List<Product>> getAllStoredProducts();
}
