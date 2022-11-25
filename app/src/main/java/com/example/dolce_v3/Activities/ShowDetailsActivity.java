package com.example.dolce_v3.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dolce_v3.Domain.PopularDomain;
import com.example.dolce_v3.Helper.ManageCart;
import com.example.dolce_v3.MainActivity;
import com.example.dolce_v3.R;
import com.google.android.material.imageview.ShapeableImageView;

public class ShowDetailsActivity extends AppCompatActivity {
    private TextView addCartBtn;
    private TextView title, price, description, quantity;
    private TextView add, sub;
    private ShapeableImageView itemImage;
    private PopularDomain obj;
    int numberOrder = 1;
    private ManageCart manageCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_show_details);

        manageCart = new ManageCart(this);
        initView();
        getBundle();
    }

    private void initView(){
        addCartBtn = findViewById(R.id.addCartBtn);
        title = findViewById(R.id.titleTxt);
        price = findViewById(R.id.priceTxt);
        description = findViewById(R.id.descTxt);
        quantity = findViewById(R.id.qtyTxt);
        add = findViewById(R.id.incBtn);
        sub = findViewById(R.id.decBtn);
        itemImage = findViewById(R.id.itemImage);
    }

    private void getBundle(){
        obj = (PopularDomain) getIntent().getSerializableExtra("object");

        int drawableResourceId = this.getResources().getIdentifier(obj.getImage(), "drawable", this.getPackageName());
        Glide.with(this).load(drawableResourceId).into(itemImage);
        title.setText(obj.getTitle());
        price.setText("Rs. "+obj.getPrice());
        description.setText(obj.getDescription());
        quantity.setText(String.valueOf(numberOrder));
    }

    public void increment(View view) {
        numberOrder += 1;
        quantity.setText(String.valueOf(numberOrder));
    }

    public void decrement(View view) {

        if(numberOrder>1){
            numberOrder -= 1;
        }
//        else{
//            builder.setTitle("Are you sure ?").setMessage("Do you want to remove the item").setCancelable(true).setPositiveButton("Remove", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//
//                }
//            }).show();
//        }
        quantity.setText(String.valueOf(numberOrder));
    }

    public void AddCart(View view) {
        obj.setNumberinCart(numberOrder);
        manageCart.insertItem(obj);
    }

    public void goToCart(View view) {
        startActivity(new Intent(ShowDetailsActivity.this, CartActivity.class));
    }

    public void goTOHome(View view) {
        startActivity(new Intent(ShowDetailsActivity.this, MainActivity.class));
    }
}