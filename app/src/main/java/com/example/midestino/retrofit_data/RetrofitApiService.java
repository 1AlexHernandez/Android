package com.example.midestino.retrofit_data;



import com.example.midestino.model.ItemList;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.Call;

public interface RetrofitApiService {
    @GET("gettemsDB.php")
    Call<List<ItemList>> gettemsDB();
}
