package com.example.dolce_v3.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.dolce_v3.Domain.CategoryDomain;
import com.example.dolce_v3.R;
public class CategoryActivity extends AppCompatActivity {
    private TextView CategoryTitle;
    private CategoryDomain object;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

//        TextView CategoryTitle;
        CategoryTitle = findViewById(R.id.CategoryTitle);
        object = (CategoryDomain) getIntent().getSerializableExtra("object");
//        CategoryTitle.setText(object.getTitle());

//        recyclerView = findViewById(R.id.coneCategory);
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));


    }
}