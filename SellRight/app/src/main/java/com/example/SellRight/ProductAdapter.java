package com.example.SellRight;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter implements Filterable {

    private Context context;
    private ArrayList<Product> products;
    private ArrayList<Product> filteredProducts;
    private ArrayList<Product> cart;

    public ProductAdapter(Context context, ArrayList<Product> products, ArrayList<Product> cart) {
        this.context = context;
        this.products = products;
        this.filteredProducts = new ArrayList<>(products);
        this.cart = cart;
    }

    @Override
    public int getCount() { return filteredProducts.size(); }

    @Override
    public Object getItem(int position) { return filteredProducts.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        }

        ImageView image = convertView.findViewById(R.id.productImage);
        TextView name = convertView.findViewById(R.id.productName);
        TextView price = convertView.findViewById(R.id.productPrice);
        Button addBtn = convertView.findViewById(R.id.addToCartBtn);

        Product product = filteredProducts.get(position);
        image.setImageResource(product.imageRes);
        name.setText(product.name);
        price.setText("$" + product.price);

        addBtn.setOnClickListener(v -> {
            cart.add(product);
            Toast.makeText(context, product.name + " added to cart", Toast.LENGTH_SHORT).show();
        });

        return convertView;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                ArrayList<Product> filtered = new ArrayList<>();
                if (constraint == null || constraint.length() == 0) {
                    filtered.addAll(products);
                } else {
                    String filterPattern = constraint.toString().toLowerCase().trim();
                    for (Product p : products) {
                        if (p.name.toLowerCase().contains(filterPattern)) {
                            filtered.add(p);
                        }
                    }
                }
                FilterResults results = new FilterResults();
                results.values = filtered;
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredProducts.clear();
                filteredProducts.addAll((ArrayList<Product>) results.values);
                notifyDataSetChanged();
            }
        };
    }
}
