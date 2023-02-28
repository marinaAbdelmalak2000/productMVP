package com.example.productsretrofit.network;


import com.example.productsretrofit.model.Root;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API_Service {

@GET("products")
Call<Root> getProduct();
}
