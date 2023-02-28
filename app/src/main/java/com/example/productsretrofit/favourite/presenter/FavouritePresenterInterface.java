package com.example.productsretrofit.favourite.presenter;

import androidx.lifecycle.LiveData;

import com.example.productsretrofit.model.Product;

import java.util.List;

public interface FavouritePresenterInterface {

    public void deleteToFav(Product product);
    public LiveData<List<Product>> getProductFav();
}
