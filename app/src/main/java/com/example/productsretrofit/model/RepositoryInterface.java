package com.example.productsretrofit.model;

import androidx.lifecycle.LiveData;

import com.example.productsretrofit.network.NetwoerkConnection;

import java.util.List;

public interface RepositoryInterface {
    public LiveData<List<Product>> getStoredProducts();
    public void getAllProduct(NetwoerkConnection netwoerkConnection);
    public void insertProduct(Product product);
    public void deleteProduct(Product product);

}
