package com.example.SellRight;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    private ListView cartListView;
    private TextView tvTotal;



    ItemAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartListView = findViewById(R.id.cartListView);
        tvTotal = findViewById(R.id.tvTotal);

//        ArrayList<Product> cart = (ArrayList<Product>) getIntent().getSerializableExtra("cartList");
//
//        ArrayList<String> displayList = new ArrayList<>();
//        int total = 0;
//        if (cart != null) {
//            for (Product p : cart) {
//                displayList.add(p.name + " - $" + p.price);
//                total += p.price;
//            }
//        }

//        ListView listView = findViewById(R.id.listView);

        List<ItemModel> list = new ArrayList<>();
        list.add(new ItemModel(R.drawable.apple, "Apples", "1kg", 15.00));
        list.add(new ItemModel(R.drawable.milk, "Milk", "1L", 12.00));
        list.add(new ItemModel(R.drawable.tomato, "Tomatoes", "500g", 8.00));

         adapter = new ItemAdapter(this, list);
        cartListView.setAdapter(adapter);


//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, displayList);
//        cartListView.setAdapter(adapter);

        tvTotal.setText("Total: $" + total);
    }
}
