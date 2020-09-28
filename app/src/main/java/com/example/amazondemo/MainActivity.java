package com.example.amazondemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.amazondemo.Adapter.BottomAdapter;
import com.example.amazondemo.Adapter.CategoryAdapter;
import com.example.amazondemo.Models.itemModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView, recyclerSpecial ;
    ArrayList<itemModel> arrayList;
    int icons[] = {R.drawable.pantry,R.drawable.mobiles,R.drawable.fashion,R.drawable.home,
            R.drawable.electronics,R.drawable.appliances};
    String iconsName[] ={"Pantry","Mobiles","Fashion","Home","Electronics","Appliances"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.home_toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerView);
        arrayList = new ArrayList<>();

        LinearLayoutManager horizontal = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(horizontal);
        for (int i = 0; i < icons.length; i++) {
            itemModel itemModel = new itemModel();
            itemModel.setImage(icons[i]);
            itemModel.setName(iconsName[i]);
            arrayList.add(itemModel);
        }

        CategoryAdapter adapter = new CategoryAdapter(getApplicationContext(), arrayList);
        recyclerView.setAdapter(adapter);


        //Bottom category
        recyclerSpecial = findViewById(R.id.bottom_recycler);
        LinearLayoutManager hori = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerSpecial.setLayoutManager(hori);
        recyclerSpecial.setAdapter(new BottomAdapter());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id =item.getItemId();

        if(id == R.id.basket_menu){
            Intent basketIntent = new Intent(MainActivity.this, CartActivity.class);
            startActivity(basketIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}