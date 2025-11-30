package com.example.SellRight;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailActivity extends AppCompatActivity {

    private ImageView productImage;
    private TextView productName, productPrice;
    private Button btnAddToCart;
    private int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        productImage = findViewById(R.id.productImage);
        productName = findViewById(R.id.productName);
        productPrice = findViewById(R.id.productPrice);
        btnAddToCart = findViewById(R.id.btnAddToCart);

        Product p = (Product) getIntent().getSerializableExtra("product");
        if (p != null) {
            productImage.setImageResource(p.imageRes);
            productName.setText(p.name);
            productPrice.setText("$" + p.price);
        }

        btnAddToCart.setOnClickListener(v ->
                Toast.makeText(this, "Added " + quantity + " " + p.name + " to cart (simulation)", Toast.LENGTH_SHORT).show()
        );
    }
}
