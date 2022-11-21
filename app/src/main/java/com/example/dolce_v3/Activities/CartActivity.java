package com.example.dolce_v3.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.dolce_v3.Adaptor.CartListAdaptor;
import com.example.dolce_v3.Helper.ManageCart;
import com.example.dolce_v3.Interface.ChangeQuantityListener;
import com.example.dolce_v3.MainActivity;
import com.example.dolce_v3.R;
public class CartActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManageCart manageCart;
    TextView totalPriceTxt, taxTxt, deliveryTxt, totalTxt;
    LinearLayout EmptyActivity;
    private double tax;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_cart);


        manageCart = new ManageCart(this);

        recyclerViewList = findViewById(R.id.recyclerViewCart);
        totalPriceTxt = findViewById(R.id.subtotalPriceTxt);
        taxTxt = findViewById(R.id.taxPriceTxt);
        deliveryTxt = findViewById(R.id.deliveryChargesTxt);
        totalTxt = findViewById(R.id.totalPriceTxt);
        EmptyActivity = findViewById(R.id.EmptyAcivity);
        recyclerViewList = findViewById(R.id.recyclerViewCart);
        scrollView = findViewById(R.id.scrollView2);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter = new CartListAdaptor(manageCart.getListCart(), this,  new ChangeQuantityListener() {
            @Override
            public void changed() {
                Calculate();
            }
        });

        recyclerViewList.setAdapter(adapter);

        if(manageCart.getListCart().isEmpty()){
            EmptyActivity.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        }else{
            EmptyActivity.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }

        Calculate();
    }

    private void Calculate(){
        double percentTax = 0.02;
        double delivery = 10;

        tax = (manageCart.getTotalPrice() * percentTax);
        double total = (manageCart.getTotalPrice() + tax + delivery);
        double itemTotal = manageCart.getTotalPrice();

        totalPriceTxt.setText("Rs. "+itemTotal);
        taxTxt.setText("Rs. "+tax);
        deliveryTxt.setText("Rs. "+delivery);
        totalTxt.setText("Rs. "+total);
    }

    public void goTOHome(View view) {
        startActivity(new Intent(CartActivity.this, MainActivity.class));
    }
}