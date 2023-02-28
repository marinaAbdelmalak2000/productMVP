package com.example.productsretrofit.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.productsretrofit.model.Product;

import java.util.List;

@Dao
public interface ProductDAO {

    //operation
    @Query("select * from products")
    LiveData<List<Product>>getAllProdects();

    @Query("Select * from products where title=:title")
    LiveData<List<Product>> getProductByTitle(String title);

    @Query("select id from products")
    LiveData<List<Integer>> getAllProdectsById();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertProduct(Product product);

    @Delete
    void deleteProduct(Product product);

}
