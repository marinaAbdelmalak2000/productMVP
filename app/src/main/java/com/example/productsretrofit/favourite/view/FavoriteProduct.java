package com.example.productsretrofit.favourite.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.productsretrofit.allProduct.presenter.AllProductPresenter;
import com.example.productsretrofit.db.ConcreteLocalSource;
import com.example.productsretrofit.favourite.presenter.FavouritePresenter;
import com.example.productsretrofit.favourite.presenter.FavouritePresenterInterface;
import com.example.productsretrofit.model.Product;
import com.example.productsretrofit.R;
import com.example.productsretrofit.model.Repository;
import com.example.productsretrofit.favourite.view.FavouritAdapter;
import com.example.productsretrofit.favourite.view.OnFavouriteClickLisener;
import com.example.productsretrofit.network.API_Client;

import java.util.ArrayList;
import java.util.List;

public class FavoriteProduct extends AppCompatActivity implements OnFavouriteClickLisener ,FavViewInterface {

    RecyclerView recyclerViewFavourit;
    FavouritAdapter myAdapter;
    List<Product> inputFav =new ArrayList<>();

    FavouritePresenterInterface allPresent;

   // LiveData<List<Product>> productsFav =MainActivity.products;

   // Repository repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_product);

        recyclerViewFavourit=findViewById(R.id.recycleFavourite);
        recyclerViewFavourit.setHasFixedSize(true);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerViewFavourit.setLayoutManager(layoutManager);
        myAdapter=new FavouritAdapter(this, inputFav,this);
        allPresent=new FavouritePresenter(this,Repository.getInstance(API_Client.getInstance(), ConcreteLocalSource.getInstance(this),this));
        allPresent.getProductFav().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                myAdapter.setData(products);
                myAdapter.notifyDataSetChanged();
            }
        });
        recyclerViewFavourit.setAdapter(myAdapter);
//        repo=new Repository(this);
//        repo.getStoreProduct().observe(this, new Observer<List<Product>>() {
//            @Override
//            public void onChanged(List<Product> products) {
//                myAdapter.setData(products);
//                myAdapter.notifyDataSetChanged();
//            }
//        });

       // myAdapter.notifyDataSetChanged();
        recyclerViewFavourit.setAdapter(myAdapter);
    }

    @Override
    public void onClick(Product product) {
       // repo.delete(product);
        deleteProduct(product);
        Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void deleteProduct(Product product) {
        allPresent.deleteToFav(product);
    }
}