package com.example.SellRight;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CartAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Product> cartItems;

    public CartAdapter(Context context, ArrayList<Product> cartItems) {
        this.context = context;
        this.cartItems = cartItems;
    }

    @Override
    public int getCount() { return cartItems.size(); }

    @Override
    public Object getItem(int position) { return cartItems.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.cart_item, parent, false);
        }

        ImageView image = convertView.findViewById(R.id.cartProductImage);
        TextView name = convertView.findViewById(R.id.cartProductName);
        TextView price = convertView.findViewById(R.id.cartProductPrice);

        Product product = cartItems.get(position);
        image.setImageResource(product.imageRes);
        name.setText(product.name);
        price.setText("$" + product.price);

        return convertView;
    }
}
