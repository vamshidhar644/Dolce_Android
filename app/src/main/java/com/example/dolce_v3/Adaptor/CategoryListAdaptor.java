package com.example.dolce_v3.Adaptor;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dolce_v3.Activities.ShowDetailsActivity;
import com.example.dolce_v3.Domain.CategoryListDomain;
import com.example.dolce_v3.R;

import java.util.ArrayList;

public class CategoryListAdaptor extends RecyclerView.Adapter<CategoryListAdaptor.ViewHolder> {
    ArrayList<CategoryListDomain> categoryListDomains;

    public CategoryListAdaptor(ArrayList<CategoryListDomain> categoryListDomains){
        this.categoryListDomains = categoryListDomains;
    }

    @Override
    public CategoryListAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(categoryListDomains.get(position).getTitle());
        holder.price.setText(String.valueOf(categoryListDomains.get(position).getPrice()));

        String picUrl = "";

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(categoryListDomains.get(position).getImage(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.popularImage);

        holder.ConsBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ShowDetailsActivity.class);
                intent.putExtra("object", categoryListDomains.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryListDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title, price, addBtn;
        ImageView popularImage;
        ConstraintLayout ConsBox;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.popularname);
            price = itemView.findViewById(R.id.popularprice);
            popularImage = itemView.findViewById(R.id.popularImage);
            addBtn = itemView.findViewById(R.id.addBtn);
            ConsBox = itemView.findViewById(R.id.popularBox);
        }
    }
}
