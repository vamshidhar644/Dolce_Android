package com.example.dolce_v3.Adaptor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dolce_v3.Domain.PopularDomain;
import com.example.dolce_v3.Helper.ManageCart;
import com.example.dolce_v3.Interface.ChangeQuantityListener;
import com.example.dolce_v3.R;

import java.util.ArrayList;

public class CartListAdaptor extends RecyclerView.Adapter<CartListAdaptor.ViewHolder> {
    private ArrayList<PopularDomain> popularDomains;
    private ManageCart manageCart;
    private ChangeQuantityListener changeQuantityListener;

    public CartListAdaptor(ArrayList<PopularDomain> popularDomains, Context context, ChangeQuantityListener changeQuantityListener) {
        this.popularDomains = popularDomains;
        this.manageCart = new ManageCart(context);
        this.changeQuantityListener = changeQuantityListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(popularDomains.get(position).getTitle());
        holder.priceEachItem.setText(String.valueOf(popularDomains.get(position).getPrice()));
        holder.totalEachItem.setText(String.valueOf((popularDomains.get(position).getNumberinCart() * popularDomains.get(position).getPrice() * 100)/100));
        holder.CartItemQuantity.setText(String.valueOf(popularDomains.get(position).getNumberinCart()));

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(popularDomains.get(position).getImage(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.CartImage);

        holder.increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               manageCart.incrementItem(popularDomains, position, new ChangeQuantityListener() {
                   @Override
                   public void changed() {
                       notifyDataSetChanged();
                       changeQuantityListener.changed();
                   }
               });
            }
        });

        holder.decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                manageCart.decrementItem(popularDomains, position, new ChangeQuantityListener() {
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        changeQuantityListener.changed();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return popularDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title, priceEachItem;
        ImageView CartImage;
        TextView totalEachItem, CartItemQuantity, increment, decrement;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.cartItemTitleTxt);
            priceEachItem = itemView.findViewById(R.id.EachitemPriceTxt);
            CartImage = itemView.findViewById(R.id.cartItemImage);
            totalEachItem = itemView.findViewById(R.id.itemsTotalPriceTxt);
            CartItemQuantity = itemView.findViewById(R.id.CartItemquantityTxt);
            increment = itemView.findViewById(R.id.inc_Btn);
            decrement = itemView.findViewById(R.id.dec_Btn);
        }
    }
}
