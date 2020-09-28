package com.example.amazondemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.amazondemo.Adapter.ListAdapter;

public class ProductListActivity extends AppCompatActivity {

    RecyclerView recyclerViewList ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        recyclerViewList = findViewById(R.id.recycler_list);

        recyclerViewList.setLayoutManager(new LinearLayoutManager(ProductListActivity.this));
        recyclerViewList.setAdapter(new ListAdapter(this));

    }
}