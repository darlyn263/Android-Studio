package com.example.SellRight;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private GridLayout productContainer;
    private EditText searchBar;
    private ImageView homeIcon, cartIcon;
    private ArrayList<Product> products;
    private ArrayList<Product> cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        productContainer = findViewById(R.id.productContainer);
        searchBar = findViewById(R.id.searchBar);
        homeIcon = findViewById(R.id.homeIcon);
        cartIcon = findViewById(R.id.cartIcon);

        cart = new ArrayList<>();
        products = new ArrayList<>();

        // Add products with actual images in drawable
        products.add(new Product("Rice", 5, R.drawable.rice,""));
        products.add(new Product("Milk", 3, R.drawable.milk,""));
        products.add(new Product("Tomato", 2, R.drawable.tomato,""));
        products.add(new Product("Apple", 4, R.drawable.apple,""));
        products.add(new Product("Banana", 4, R.drawable.banana,""));
        products.add(new Product("Carrot", 2, R.drawable.carrot,""));
        products.add(new Product("Yam", 6, R.drawable.yam,""));
        products.add(new Product("Grapes", 4, R.drawable.grapes,""));

        displayProducts(products);

        // Search functionality
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void afterTextChanged(Editable s) {}
            @Override
            public void onTextChanged(CharSequence query, int start, int before, int count) {
                ArrayList<Product> filtered = new ArrayList<>();
                for (Product p : products) {
                    if (p.name.toLowerCase().contains(query.toString().toLowerCase())) {
                        filtered.add(p);
                    }
                }
                displayProducts(filtered);
            }
        });

        // Cart button click
        cartIcon.setOnClickListener(v -> {
            if (cart.isEmpty()) {
                Toast.makeText(this, "Cart is empty", Toast.LENGTH_SHORT).show();
                return;
            }
            Intent intent = new Intent(HomeActivity.this, CartActivity.class);
            intent.putExtra("cartList", cart);
            startActivity(intent);
        });
    }

    private void displayProducts(ArrayList<Product> productList) {
        productContainer.removeAllViews();
        for (Product p : productList) {
            LinearLayout card = new LinearLayout(this);
            card.setOrientation(LinearLayout.VERTICAL);
            card.setPadding(16,16,16,16);
            card.setBackgroundColor(Color.parseColor("#F5F5F5"));
            card.setGravity(Gravity.CENTER_HORIZONTAL);

            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = 0;
            params.height = GridLayout.LayoutParams.WRAP_CONTENT;
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED,1f);
            params.setMargins(8,8,8,8);
            card.setLayoutParams(params);

            ImageView image = new ImageView(this);
            image.setImageResource(p.imageRes);
            LinearLayout.LayoutParams imgParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, 300);
            image.setLayoutParams(imgParams);
            card.addView(image);

            TextView name = new TextView(this);
            name.setText(p.name);
            name.setTextSize(16);
            name.setPadding(0,8,0,4);
            card.addView(name);

            TextView price = new TextView(this);
            price.setText("$" + p.price);
            price.setTextSize(14);
            price.setTextColor(Color.parseColor("#6200EE"));
            price.setPadding(0,0,0,8);
            card.addView(price);

            Button addToCart = new Button(this);
            addToCart.setText("Add to Cart");
            addToCart.setOnClickListener(v -> {
                cart.add(p);
                Toast.makeText(this, p.name + " added to cart", Toast.LENGTH_SHORT).show();
            });
            card.addView(addToCart);

            // Click product to view details
            card.setOnClickListener(v -> {
                Intent intent = new Intent(HomeActivity.this, ProductDetailActivity.class);
                intent.putExtra("product", p);
                startActivity(intent);
            });

            productContainer.addView(card);
        }
    }
}
