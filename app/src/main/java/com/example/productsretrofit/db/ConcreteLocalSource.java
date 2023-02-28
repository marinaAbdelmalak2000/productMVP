package com.example.productsretrofit.db;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.productsretrofit.model.Product;

import java.util.List;

public class ConcreteLocalSource implements LocalSource{

    private ProductDAO dao;
    private static ConcreteLocalSource localSource = null;
    private LiveData<List<Product>> storedProduct;

    private ConcreteLocalSource(Context context){
        AppDataBase db=AppDataBase.getInstance(context.getApplicationContext());
        dao=db.productDAO();
        storedProduct=dao.getAllProdects();
    }

    public static ConcreteLocalSource getInstance(Context context){
        if(localSource == null){
            localSource=new ConcreteLocalSource(context);
        }
        return localSource;
    }
    @Override
    public void insertProduct(Product product) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                dao.insertProduct(product);
            }
        }).start();
    }

    @Override
    public void deleteProduct(Product product) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                dao.deleteProduct(product);
            }
        }).start();
    }

    @Override
    public LiveData<List<Product>> getAllStoredProducts() {
        return storedProduct;
    }
}
