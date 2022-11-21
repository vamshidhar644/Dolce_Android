package com.example.dolce_v3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.dolce_v3.Activities.CartActivity;
import com.example.dolce_v3.Adaptor.CategoryAdaptor;
import com.example.dolce_v3.Adaptor.PopularAdaptor;
import com.example.dolce_v3.Domain.CategoryDomain;
import com.example.dolce_v3.Domain.PopularDomain;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);


        recyclerViewCategory();
        recyclerViewPopular();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.cartImage);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CartActivity.class));
            }
        });
    }

    private void recyclerViewCategory(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.recyclerViewCategory);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categories = new ArrayList<>();
        categories.add(new CategoryDomain("Cone", "cat_1"));
        categories.add(new CategoryDomain("Stick", "cat_2"));
        categories.add(new CategoryDomain("Scoops", "cat_3"));
        categories.add(new CategoryDomain("Bar", "cat_4"));
        categories.add(new CategoryDomain("Sundae", "cat_5"));
        categories.add(new CategoryDomain("Galeto", "cat_6"));

        adapter = new CategoryAdaptor(categories);
        recyclerViewCategoryList.setAdapter(adapter);
    }

    private void recyclerViewPopular(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.recyclerViewPopular);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<PopularDomain> popularList = new ArrayList<>();
        popularList.add(new PopularDomain("Vanilla", "vanilla", "Vanilla bean, vanilla ice cream is delicious on its own but it’s often the flavor of choice when serving desserts.", 45.00));
        popularList.add(new PopularDomain("Choclate", "choclate", "Blending cocoa powder with eggs, cream, sugar, and vanilla.", 40.00));
        popularList.add(new PopularDomain("Strawberry", "strawberry", "Strawberry flavoring, fresh strawberries blended in with eggs, cream, sugar, and vanilla.", 50.00));
        popularList.add(new PopularDomain("Rocky Road", "rocky_road", "Chocolate ice cream, nuts, and marshmallows.", 120.00));
        popularList.add(new PopularDomain("Queso (Cheese)", "queso", "Combination of salty, sharp, creamy, and sweet.", 45.00));

        adapter2 = new PopularAdaptor(popularList);
        recyclerViewPopularList.setAdapter(adapter2);
    }
}