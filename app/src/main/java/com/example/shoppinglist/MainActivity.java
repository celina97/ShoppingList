package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<ShoppingList> shoppingListList;
    Adapter adapter;
    private Adapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        initData();
        initRecyclerView();


    }

    private void initData() {

        shoppingListList = new ArrayList<>();

        shoppingListList.add(new ShoppingList(R.drawable.apple, "Apple", "5 pieces", "____________________________"));
        shoppingListList.add(new ShoppingList(R.drawable.chocolate, "Chocolate", "Nougat", "____________________________"));
        shoppingListList.add(new ShoppingList(R.drawable.water, "Water", "3 bottles", "____________________________"));
        shoppingListList.add(new ShoppingList(R.drawable.coffee, "Coffee", "500g", "____________________________"));
        shoppingListList.add(new ShoppingList(R.drawable.salad, "Salad", "1 piece", "____________________________"));

    }

    private void initRecyclerView() {

        setOnClickListener();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(shoppingListList, listener);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private void setOnClickListener() {

        listener = new Adapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), ProductActivity.class);
                intent.putExtra("name", shoppingListList.get(position).getName());
                intent.putExtra("details", shoppingListList.get(position).getDetail());
                intent.putExtra("imageInt", shoppingListList.get(position).getImage());
                startActivity(intent);
            }
        };


    }

}