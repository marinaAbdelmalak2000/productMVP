package com.example.productsretrofit.favourite.presenter;

import androidx.lifecycle.LiveData;

import com.example.productsretrofit.allProduct.view.AllProductViewInterface;
import com.example.productsretrofit.favourite.view.FavViewInterface;
import com.example.productsretrofit.model.Product;
import com.example.productsretrofit.model.RepositoryInterface;

import java.util.List;

public class FavouritePresenter implements FavouritePresenterInterface{
    private FavViewInterface _view;
    private RepositoryInterface repo;


    public FavouritePresenter(FavViewInterface _view, RepositoryInterface repo){
        this.repo=repo;
        this._view=_view;
    }


    @Override
    public void deleteToFav(Product product) {
        repo.deleteProduct(product);
    }

    @Override
    public LiveData<List<Product>> getProductFav() {
        return repo.getStoredProducts();
    }
}
