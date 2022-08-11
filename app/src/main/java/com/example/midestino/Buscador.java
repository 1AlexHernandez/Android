package com.example.midestino;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.widget.SearchView;
import android.widget.Toast;

import com.example.midestino.adaptador.RecyclerAdapter;
import com.example.midestino.model.ItemList;
import com.example.midestino.retrofit_data.RetrofitApiService;
import com.example.midestino.retrofit_data.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Buscador extends AppCompatActivity implements RecyclerAdapter.RecyclerItemClick, SearchView.OnQueryTextListener {
    private RecyclerView rvLista;
    private SearchView svSearch;
    private RecyclerAdapter adapter;
    private List<ItemList> items;
    private RetrofitApiService retrofitApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscador);

        initViews();
        initValues();
        initListener();
    }

    private void initListener() { svSearch.setOnQueryTextListener(this);
    }

    private void initValues() {
        retrofitApiService = RetrofitClient.getApiService();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvLista.setLayoutManager(manager);
        gettemsSQL();
    }

    private void gettemsSQL() {
        retrofitApiService.gettemsDB().enqueue(new Callback<List<ItemList>>() {
            @Override
            public void onResponse(Call<List<ItemList>> call, Response<List<ItemList>> response) {
                items = response.body();
                adapter = new RecyclerAdapter(items, Buscador.this);
                rvLista.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<ItemList>> call, Throwable t) {
                Toast.makeText(Buscador.this, "Error: ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initViews() {
        rvLista = (RecyclerView) findViewById(R.id.rvLista);
        svSearch = (SearchView) findViewById(R.id.svSearch);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.filter(newText);
        return false;
    }

    @Override
    public void itemClick(ItemList item) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra( "itemDetail", item);
        startActivity(intent);
    }
}