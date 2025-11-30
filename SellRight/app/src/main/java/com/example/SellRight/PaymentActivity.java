package com.example.SellRight;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PaymentActivity extends AppCompatActivity {

    Button payBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        payBtn = findViewById(R.id.payBtn);

        payBtn.setOnClickListener(v -> Toast.makeText(PaymentActivity.this, "Payment Successful", Toast.LENGTH_SHORT).show());
    }
}
