package com.example.shoppinglist;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_activity);

        TextView textView3 = findViewById(R.id.textView3);
        TextView textView5 = findViewById(R.id.textView5);

        String productname = "Productname not set";

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            productname = extras.getString(productname);
        }

        textView3.setText(productname);


        //initData();
        //initRecyclerView();


    }

}
