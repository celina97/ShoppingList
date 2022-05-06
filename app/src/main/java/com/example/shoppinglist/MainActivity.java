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
    LinearLayoutManager layoutManager;
    List<ShoppingList> shoppingListList;
    Adapter adapter;
    private Adapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initRecyclerView();


    }

    private void initData() {

        shoppingListList = new ArrayList<>();

        shoppingListList.add(new ShoppingList(R.drawable.apple, "Apple", "5 pieces", "____________________________"));
        shoppingListList.add(new ShoppingList(R.drawable.chocolate, "Chocolate", "Nougat", "____________________________"));
        shoppingListList.add(new ShoppingList(R.drawable.water, "Water", "3 bottles", "____________________________"));

    }

    private void initRecyclerView() {

        setOnClickListener();


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
                intent.putExtra("productname", shoppingListList.get(position).getTextview());
                startActivity(intent);
            }
        };


    }

}