package com.example.SellRight;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {

    ListView productList;
    SearchView searchView;
    Button btnGoToCart;

    ArrayList<Product> products; // all products
    ArrayList<Product> cart;     // items added to cart

    ProductAdapter adapter;      // custom adapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        productList = findViewById(R.id.productList);
        searchView = findViewById(R.id.searchView);
        btnGoToCart = findViewById(R.id.btnGoToCart);

        cart = new ArrayList<>();
        products = new ArrayList<>();

        // Add sample products
        // Add products with actual images in drawable
        products.add(new Product("Rice", 5, R.drawable.rice,""));
        products.add(new Product("Milk", 3, R.drawable.milk,""));
        products.add(new Product("Tomato", 2, R.drawable.tomato,""));
        products.add(new Product("Apple", 4, R.drawable.apple,""));
        products.add(new Product("Banana", 4, R.drawable.banana,""));
        products.add(new Product("Carrot", 2, R.drawable.carrot,""));
        products.add(new Product("Yam", 6, R.drawable.yam,""));
        products.add(new Product("Grapes", 4, R.drawable.grapes,""));

        // Set adapter
        adapter = new com.example.SellRight.ProductAdapter(this, products, cart);
        productList.setAdapter(adapter);

        // Search/filter products
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override public boolean onQueryTextSubmit(String query) { return false; }
            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        // Go to Cart button
        btnGoToCart.setOnClickListener(v -> {
            if (cart.isEmpty()) {
                Toast.makeText(this, "Cart is empty", Toast.LENGTH_SHORT).show();
                return;
            }
            Intent intent = new Intent(ProductActivity.this, CartActivity.class);
            intent.putExtra("cartList", cart); // pass cart products
            startActivity(intent);
        });
    }
}
