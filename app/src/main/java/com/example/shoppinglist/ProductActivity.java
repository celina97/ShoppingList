package com.example.shoppinglist;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_activity);

        TextView textView3 = findViewById(R.id.textView3);
        TextView textView5 = findViewById(R.id.textView5);
        ImageView imageView = findViewById(R.id.imageView);

        Bundle extras = getIntent().getExtras();
        String nameText, detailText;
        int imageInt;
        if (extras != null) {
            nameText = extras.getString("name");
            textView3.setText(nameText);

            detailText = extras.getString("details");
            textView5.setText(detailText);

            imageInt = extras.getInt("imageInt");
            imageView.setImageResource(imageInt);
        }




        //initData();
        //initRecyclerView();


    }

}
