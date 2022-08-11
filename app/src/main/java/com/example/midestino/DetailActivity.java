package com.example.midestino;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.midestino.model.ItemList;
import com.example.midestino.model.ItemList;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    private ImageView imageItemDetail;
    private TextView tvnombreDetail;
    private TextView tvDescripcioDetail;
    private ItemList itemDetail;
    private String doamin_image = "http://10.0.2.2/canchas/media/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setTitle(getClass().getSimpleName());
        initViews();
        initValues();
    }

    private void initValues() {
        itemDetail = (ItemList) getIntent().getExtras().getSerializable("itemDetail");

        Picasso.get().load(doamin_image+itemDetail.getImageResource()).into(imageItemDetail);
        tvnombreDetail.setText(itemDetail.getnombre());
        tvDescripcioDetail.setText(itemDetail.getDescripcion());
    }

    private void initViews() {
        imageItemDetail = findViewById(R.id.imageItemDetail);
        tvnombreDetail = findViewById(R.id.tvnombreDetail);
        tvDescripcioDetail = findViewById(R.id.tvDescripcionDetail);
    }

}