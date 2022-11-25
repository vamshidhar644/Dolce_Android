package com.example.dolce_v3.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.dolce_v3.Adaptor.PopularAdaptor;
import com.example.dolce_v3.Domain.CategoryDomain;
import com.example.dolce_v3.Domain.CategoryListDomain;
import com.example.dolce_v3.Domain.PopularDomain;
import com.example.dolce_v3.R;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {
//    private TextView CategoryTitle;
    private CategoryDomain object;
//    private RecyclerView recyclerView;

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

        coneCategory();
    }

    private void coneCategory(){
        ArrayList<PopularDomain> popularList = new ArrayList<>();
        popularList.add(new PopularDomain("Vanilla", "vanilla", "Vanilla bean, vanilla ice cream is delicious on its own but it’s often the flavor of choice when serving desserts.", 45.00));
        popularList.add(new PopularDomain("Choclate", "choclate", "Blending cocoa powder with eggs, cream, sugar, and vanilla.", 40.00));
        popularList.add(new PopularDomain("Strawberry", "strawberry", "Strawberry flavoring, fresh strawberries blended in with eggs, cream, sugar, and vanilla.", 50.00));
        popularList.add(new PopularDomain("Rocky Road", "rocky_road", "Chocolate ice cream, nuts, and marshmallows.", 120.00));
        popularList.add(new PopularDomain("Queso (Cheese)", "queso", "Combination of salty, sharp, creamy, and sweet.", 45.00));

        categoryListAdaptor = new PopularAdaptor(popularList);
        recyclerViewCategoriesList.setAdapter(categoryListAdaptor);
    }
}