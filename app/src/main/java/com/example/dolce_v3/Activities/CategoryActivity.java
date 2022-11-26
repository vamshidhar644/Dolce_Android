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

        if(CategoryTitle.getText().equals("Cone Ice creams")){
            category_1();
        }
        else if(CategoryTitle.getText().equals("Stick Ice creams")){
            category_2();
        }
        if(CategoryTitle.getText().equals("Scoops Ice creams")){
            category_3();
        }
        else if(CategoryTitle.getText().equals("Bar Ice creams")){
            category_4();
        }
        if(CategoryTitle.getText().equals("Sundae Ice creams")){
            category_5();
        }
        else if(CategoryTitle.getText().equals("Galeto Ice creams")){
            category_6();
        }
    }

    private void category_1(){
        ArrayList<PopularDomain> cat1_List = new ArrayList<>();
        cat1_List.add(new PopularDomain("Belgian Chocolate", "belgian", "Bite into a rich, crunchy and chocolatey experience.", 45.00));
        cat1_List.add(new PopularDomain("Chocolate Truffle", "truffle", "A divine combination of two flavours, guaranteed to delight you.", 40.00));
        cat1_List.add(new PopularDomain("Belgian Chocolate", "belgian", "Bite into a rich, crunchy and chocolatey experience.", 45.00));
        cat1_List.add(new PopularDomain("Chocolate Truffle", "truffle", "A divine combination of two flavours, guaranteed to delight you.", 40.00));
        cat1_List.add(new PopularDomain("Belgian Chocolate", "belgian", "Bite into a rich, crunchy and chocolatey experience.", 45.00));
        cat1_List.add(new PopularDomain("Chocolate Truffle", "truffle", "A divine combination of two flavours, guaranteed to delight you.", 40.00));
        cat1_List.add(new PopularDomain("Belgian Chocolate", "belgian", "Bite into a rich, crunchy and chocolatey experience.", 45.00));
        cat1_List.add(new PopularDomain("Chocolate Truffle", "truffle", "A divine combination of two flavours, guaranteed to delight you.", 40.00));

        categoryListAdaptor = new PopularAdaptor(cat1_List);
        recyclerViewCategoriesList.setAdapter(categoryListAdaptor);
    }

    private void category_2(){
        ArrayList<PopularDomain> cat1_List = new ArrayList<>();
        cat1_List.add(new PopularDomain("Frosticks", "frostick", "A choclate centre wrapped in real milk choclate ice cream.", 15.00));
        cat1_List.add(new PopularDomain("Probiotic (20)", "probiotic", "20 Sticks of 60ml each. Tastier and healthier than ice cream.", 300.00));
        cat1_List.add(new PopularDomain("Frosticks", "frostick", "A choclate centre wrapped in real milk choclate ice cream.", 15.00));
        cat1_List.add(new PopularDomain("Probiotic (20)", "probiotic", "20 Sticks of 60ml each. Tastier and healthier than ice cream.", 300.00));
        cat1_List.add(new PopularDomain("Frosticks", "frostick", "A choclate centre wrapped in real milk choclate ice cream.", 15.00));
        cat1_List.add(new PopularDomain("Probiotic (20)", "probiotic", "20 Sticks of 60ml each. Tastier and healthier than ice cream.", 300.00));
        cat1_List.add(new PopularDomain("Frosticks", "frostick", "A choclate centre wrapped in real milk choclate ice cream.", 15.00));
        cat1_List.add(new PopularDomain("Probiotic (20)", "probiotic", "20 Sticks of 60ml each. Tastier and healthier than ice cream.", 300.00));

        categoryListAdaptor = new PopularAdaptor(cat1_List);
        recyclerViewCategoriesList.setAdapter(categoryListAdaptor);
    }

    private void category_3(){
        ArrayList<PopularDomain> cat1_List = new ArrayList<>();
        cat1_List.add(new PopularDomain("Fruit Ninzaa", "ninzaa", "made with the finest fruits so that it is rich and creamy.", 210.00));
        cat1_List.add(new PopularDomain("Caramel Nuts", "caramel", "Scoops Caramel Nuts Tub is decadent creamy ice cream.", 330.00));
        cat1_List.add(new PopularDomain("Fruit Ninzaa", "ninzaa", "made with the finest fruits so that it is rich and creamy.", 210.00));
        cat1_List.add(new PopularDomain("Caramel Nuts", "caramel", "Scoops Caramel Nuts Tub is decadent creamy ice cream.", 330.00));
        cat1_List.add(new PopularDomain("Fruit Ninzaa", "ninzaa", "made with the finest fruits so that it is rich and creamy.", 210.00));
        cat1_List.add(new PopularDomain("Caramel Nuts", "caramel", "Scoops Caramel Nuts Tub is decadent creamy ice cream.", 330.00));
        cat1_List.add(new PopularDomain("Fruit Ninzaa", "ninzaa", "made with the finest fruits so that it is rich and creamy.", 210.00));
        cat1_List.add(new PopularDomain("Caramel Nuts", "caramel", "Scoops Caramel Nuts Tub is decadent creamy ice cream.", 330.00));

        categoryListAdaptor = new PopularAdaptor(cat1_List);
        recyclerViewCategoriesList.setAdapter(categoryListAdaptor);
    }

    private void category_4(){
        ArrayList<PopularDomain> cat1_List = new ArrayList<>();
        cat1_List.add(new PopularDomain("Choclate Bar", "bar", "Our rich industry experience in this domain helped us to offer a broad range of Chocolate Ice Cream Bar for our reputed clients.", 25.00));
        cat1_List.add(new PopularDomain("Laviche Chocochip", "laviche", "It’s made with loads of love, chocolate and milk to give you soft and nourished skin.", 50.00));
        cat1_List.add(new PopularDomain("Choclate Bar", "bar", "Our rich industry experience in this domain helped us to offer a broad range of Chocolate Ice Cream Bar for our reputed clients.", 25.00));
        cat1_List.add(new PopularDomain("Laviche Chocochip", "laviche", "It’s made with loads of love, chocolate and milk to give you soft and nourished skin.", 50.00));
        cat1_List.add(new PopularDomain("Choclate Bar", "bar", "Our rich industry experience in this domain helped us to offer a broad range of Chocolate Ice Cream Bar for our reputed clients.", 25.00));
        cat1_List.add(new PopularDomain("Laviche Chocochip", "laviche", "It’s made with loads of love, chocolate and milk to give you soft and nourished skin.", 50.00));
        cat1_List.add(new PopularDomain("Choclate Bar", "bar", "Our rich industry experience in this domain helped us to offer a broad range of Chocolate Ice Cream Bar for our reputed clients.", 25.00));
        cat1_List.add(new PopularDomain("Laviche Chocochip", "laviche", "It’s made with loads of love, chocolate and milk to give you soft and nourished skin.", 50.00));

        categoryListAdaptor = new PopularAdaptor(cat1_List);
        recyclerViewCategoriesList.setAdapter(categoryListAdaptor);
    }

    private void category_5(){
        ArrayList<PopularDomain> cat1_List = new ArrayList<>();
        cat1_List.add(new PopularDomain("Sandae Regular", "sundae1", "Chocolate Sundaes Isolated on a White Background", 65.00));
        cat1_List.add(new PopularDomain("Selena Sundae", "sundae", "It’s made with loads of love, chocolate and milk to give you soft and nourished skin.", 50.00));
        cat1_List.add(new PopularDomain("Sandae Regular", "sundae1", "Chocolate Sundaes Isolated on a White Background", 65.00));
        cat1_List.add(new PopularDomain("Selena Sundae", "sundae", "It’s made with loads of love, chocolate and milk to give you soft and nourished skin.", 50.00));
        cat1_List.add(new PopularDomain("Sandae Regular", "sundae1", "Chocolate Sundaes Isolated on a White Background", 65.00));
        cat1_List.add(new PopularDomain("Selena Sundae", "sundae", "It’s made with loads of love, chocolate and milk to give you soft and nourished skin.", 50.00));
        cat1_List.add(new PopularDomain("Sandae Regular", "sundae1", "Chocolate Sundaes Isolated on a White Background", 65.00));
        cat1_List.add(new PopularDomain("Selena Sundae", "sundae", "It’s made with loads of love, chocolate and milk to give you soft and nourished skin.", 50.00));

        categoryListAdaptor = new PopularAdaptor(cat1_List);
        recyclerViewCategoriesList.setAdapter(categoryListAdaptor);
    }

    private void category_6(){
        ArrayList<PopularDomain> cat1_List = new ArrayList<>();
        cat1_List.add(new PopularDomain("Choclate Bar", "bar", "Our rich industry experience in this domain helped us to offer a broad range of Chocolate Ice Cream Bar for our reputed clients.", 25.00));
        cat1_List.add(new PopularDomain("Laviche Chocochip", "laviche", "It’s made with loads of love, chocolate and milk to give you soft and nourished skin.", 50.00));
        cat1_List.add(new PopularDomain("Choclate Bar", "bar", "Our rich industry experience in this domain helped us to offer a broad range of Chocolate Ice Cream Bar for our reputed clients.", 25.00));
        cat1_List.add(new PopularDomain("Laviche Chocochip", "laviche", "It’s made with loads of love, chocolate and milk to give you soft and nourished skin.", 50.00));
        cat1_List.add(new PopularDomain("Choclate Bar", "bar", "Our rich industry experience in this domain helped us to offer a broad range of Chocolate Ice Cream Bar for our reputed clients.", 25.00));
        cat1_List.add(new PopularDomain("Laviche Chocochip", "laviche", "It’s made with loads of love, chocolate and milk to give you soft and nourished skin.", 50.00));
        cat1_List.add(new PopularDomain("Choclate Bar", "bar", "Our rich industry experience in this domain helped us to offer a broad range of Chocolate Ice Cream Bar for our reputed clients.", 25.00));
        cat1_List.add(new PopularDomain("Laviche Chocochip", "laviche", "It’s made with loads of love, chocolate and milk to give you soft and nourished skin.", 50.00));

        categoryListAdaptor = new PopularAdaptor(cat1_List);
        recyclerViewCategoriesList.setAdapter(categoryListAdaptor);
    }
}