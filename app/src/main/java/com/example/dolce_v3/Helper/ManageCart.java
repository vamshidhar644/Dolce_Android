package com.example.dolce_v3.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.dolce_v3.Domain.PopularDomain;
import com.example.dolce_v3.Interface.ChangeQuantityListener;

import java.util.ArrayList;

public class ManageCart {
    private Context context;
    private TinyDB tinyDB;

    public ManageCart(Context context){
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void insertItem(PopularDomain item){
        ArrayList<PopularDomain> listItem = getListCart();
        boolean existAlready = false;

        int n = 0;
        for (int i=0; i<listItem.size(); i++){
            if(listItem.get(i).getTitle().equals(item.getTitle())){
                existAlready = true;
                n = i;
                break;
            }
        }
        if(existAlready){
            listItem.get(n).setNumberinCart(item.getNumberinCart());
        }else{
            listItem.add(item);
        }

        tinyDB.putListObject("CartList", listItem);
        Toast.makeText( context,"Added to Cart", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<PopularDomain> getListCart(){
        return tinyDB.getListObject("CartList");
    }

    public  void incrementItem(ArrayList<PopularDomain> listItem, int position, ChangeQuantityListener changeQuantityListener){
        listItem.get(position).setNumberinCart(listItem.get(position).getNumberinCart() + 1);
        tinyDB.putListObject("CartList", listItem);
        changeQuantityListener.changed();
    }

    public void decrementItem(ArrayList<PopularDomain> listItem, int position, ChangeQuantityListener changeQuantityListener){

        if(listItem.get(position).getNumberinCart() == 1){

            listItem.remove(position);
        }
        else{
            listItem.get(position).setNumberinCart(listItem.get(position).getNumberinCart() - 1);
        }
        tinyDB.putListObject("CartList", listItem);
        changeQuantityListener.changed();
    }

    public Double getTotalPrice(){
        ArrayList<PopularDomain> listItem = getListCart();
        double price = 0;
        for (int i=0; i<listItem.size(); i++){
            price = price + (listItem.get(i).getPrice() * listItem.get(i).getNumberinCart());
        }
        return price;
    }
}
