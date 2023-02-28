package com.example.productsretrofit.allProduct.presenter;

import com.example.productsretrofit.allProduct.view.AllProductViewInterface;
import com.example.productsretrofit.model.Product;
import com.example.productsretrofit.model.Repository;
import com.example.productsretrofit.network.NetwoerkConnection;

import java.util.List;

public class AllProductPresenter implements AllProductPresenterInterface, NetwoerkConnection {

    private AllProductViewInterface _view;
    private Repository repo;

    public AllProductPresenter(AllProductViewInterface _view,Repository repo){
            this.repo=repo;
            this._view=_view;
    }
    @Override
    public void getProduct() {
        repo.getAllProduct(this);
    }

    @Override
    public void addToFav(Product product) {
        repo.insertProduct(product);
    }

    @Override
    public void onSuccessResulr(List<Product> products) {
        _view.showData(products);
    }

    @Override
    public void onFailureResult(String errMsg) {

    }
}
