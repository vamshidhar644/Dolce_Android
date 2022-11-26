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

        String stick = "Stick Ice creams";
        String cone = "Cone Ice creams";

        if(CategoryTitle.getText().equals(cone)){
            category_1();
        }
        else if(CategoryTitle.getText().equals(stick)){
            category_2();
        }
    }

    private void category_1(){
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerViewCategoriesList = findViewById(R.id.ListCategory);
        recyclerViewCategoriesList.setLayoutManager(gridLayoutManager);

        ArrayList<PopularDomain> cat1_List = new ArrayList<>();
        cat1_List.add(new PopularDomain("Belgian Chocolate", "belgian", "Bite into a rich, crunchy and chocolatey experience.", 45.00));
        cat1_List.add(new PopularDomain("Chocolate Truffle", "choclate", "A divine combination of two flavours, guaranteed to delight you.", 40.00));

        categoryListAdaptor = new PopularAdaptor(cat1_List);
        recyclerViewCategoriesList.setAdapter(categoryListAdaptor);
    }


    private void category_2(){
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerViewCategoriesList = findViewById(R.id.ListCategory);
        recyclerViewCategoriesList.setLayoutManager(gridLayoutManager);

        ArrayList<PopularDomain> cat1_List = new ArrayList<>();
        cat1_List.add(new PopularDomain("Frosticks", "frostick", "A choclate centre wrapped in real milk choclate ice cream.", 15.00));
        cat1_List.add(new PopularDomain("Probiotic (20)", "probiotic", "20 Sticks of 60ml each. Tastier and healthier than ice cream. Amul Pro-biotic Chocobar comes with the goodness of probiotic bacteria, real milk and choclate. ", 300.00));

        categoryListAdaptor = new PopularAdaptor(cat1_List);
        recyclerViewCategoriesList.setAdapter(categoryListAdaptor);
    }
}