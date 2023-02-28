package com.example.productsretrofit.model;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.productsretrofit.db.AppDataBase;
import com.example.productsretrofit.db.LocalSource;
import com.example.productsretrofit.db.ProductDAO;
import com.example.productsretrofit.model.Product;
import com.example.productsretrofit.network.NetwoerkConnection;
import com.example.productsretrofit.network.RemoteSource;

import java.util.ArrayList;
import java.util.List;

public class Repository implements RepositoryInterface{

    private Context context;
    RemoteSource remoteSource;
    LocalSource localSource;
    private static Repository repo=null;

    public static Repository getInstance(RemoteSource remoteSource,LocalSource localSource,Context context){
        if (repo == null){
            repo=new Repository(remoteSource,localSource,context);

        }
        return repo;
    }
    private Repository(RemoteSource remoteSource,LocalSource localSource,Context context){
        this.remoteSource = remoteSource;
        this.localSource = localSource;
        this.context=context;
    }

//    private ProductDAO productDAO;
//    private LiveData<List<Product>> storeProduct;
//
//    private LiveData<List<Integer> >storeProductById;
//    private LiveData<List<Product>> storeProductByTitle;
//
//    boolean check=true;
//
//    public Repository(Context context) {
//        this.context = context;
//        AppDataBase db= AppDataBase.getInstance(context.getApplicationContext());
//        productDAO=db.productDAO();
//        storeProduct=productDAO.getAllProdects();
//
//        storeProductById=productDAO.getAllProdectsById();
//    }
//
//    //get product from db
//    public LiveData<List<Product>> getStoreProduct(){
//        return storeProduct;
//    }
//
//    public LiveData<List<Integer>> getStoreProductById(){
//        return storeProductById;
//    }
////    public List<Integer> getStoreProductById (){
////        new Thread(new Runnable(){
////            public void run(){
////                Log.i(TAG, "runnnnnnnn: ");
////            }
////        }).start();
////        return storeProductById;
////    }
//
//    public LiveData<List<Product>> getStoreProductByTitle(String title){
//        storeProductByTitle=productDAO.getProductByTitle(title);
//        return storeProductByTitle;
//    }
//
//    public void delete (Product product){
//        new Thread(new Runnable(){
//            public void run(){
//
//                productDAO.deleteProduct(product);
//
//            }
//        }).start();
//    }
//
//    public void insert(Product product){
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
////                for(int i=0;i<storeProductById;i++){
////                    if(product.getId()==storeProductById.get(i)){
////                        Log.i(TAG, "run aredy in fav: ");
////                    }
////                }
//                productDAO.insertProduct(product);
//
//            }
//        }).start();
//    }
//

    @Override
    public LiveData<List<Product>> getStoredProducts() {
        return localSource.getAllStoredProducts();
    }

    @Override
    public void getAllProduct(NetwoerkConnection netwoerkConnection) {
        remoteSource.enqueueCall(netwoerkConnection);
    }

    @Override
    public void insertProduct(Product product) {
        localSource.insertProduct(product);
    }

    @Override
    public void deleteProduct(Product product) {
        localSource.deleteProduct(product);
    }
}
