package com.example.dolce_v3.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.dolce_v3.Adaptor.CategoryListAdaptor;
import com.example.dolce_v3.Adaptor.PopularAdaptor;
import com.example.dolce_v3.Domain.CategoryDomain;
import com.example.dolce_v3.Domain.CategoryListDomain;
import com.example.dolce_v3.Domain.PopularDomain;
import com.example.dolce_v3.R;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {
    private CategoryDomain object;

    private RecyclerView.Adapter categoryListAdaptor;
    private RecyclerView recyclerViewCategoriesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_category);

        TextView CategoryTitle;
        CategoryTitle = findViewById(R.id.CategoryTitle);

        object = (CategoryDomain) getIntent().getSerializableExtra("object");
        CategoryTitle.setText(object.getTitle()+" Ice creams");

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerViewCategoriesList = findViewById(R.id.ListCategory);
        recyclerViewCategoriesList.setLayoutManager(gridLayoutManager);

        category_1();
    }

    private void category_1(){
        ArrayList<CategoryListDomain> cat1_List = new ArrayList<>();
        cat1_List.add(new CategoryListDomain("Big - Belgian Chocolate", "belgian", "Bite into a rich, crunchy and chocolatey experience.", 45.00));
        cat1_List.add(new CategoryListDomain("Raspberry Chocolate Truffle", "choclate", "A divine combination of two flavours, guaranteed to delight you.", 40.00));

        categoryListAdaptor = new CategoryListAdaptor(cat1_List);
        recyclerViewCategoriesList.setAdapter(categoryListAdaptor);
    }


    private void category_2(){

    }
}