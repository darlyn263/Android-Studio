package com.example.shopnice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


 ImageView imageView;
 Button button,button1;
 TextView textView1,textView2,textView3,textView4,textView5;
 CheckBox checkbox;

 RelativeLayout relativeLayout;

 EditText mail;

    int i = 0;
    String MyMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.MyDear);
        textView1 = findViewById(R.id.MyEverything);
        textView2 = findViewById(R.id.myEverything1);
        textView3 = findViewById(R.id.myEverything2);
        textView4 = findViewById(R.id.myEverything3);
        textView5 = findViewById(R.id.myEverything4);
        button = findViewById(R.id.button2);
        checkbox = findViewById(R.id.checkbox);
        mail = findViewById(R.id.mail);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                MyMail= mail.getText().toString();

                Toast.makeText(MainActivity.this, MyMail, Toast.LENGTH_SHORT).show();

                textView1.setText(MyMail);

                textView2.setText("0");

                textView3.setText("0");

                textView4.setText("0");

                textView5.setText(MyMail);

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);

            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                i++;
                textView1.setText("Cici " +i);
                i++;
                textView2.setText("Cici " +i);
                i++;
                textView3.setText("Cici " +i);
                i++;
                textView4.setText("Cici " +i);
                i++;
                textView5.setText("Cici " +i);


            }
        });




        checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                i++;
                textView1.setText("Cici " +i);
                i++;
                textView2.setText("Cici " +i);
                i++;
                textView3.setText("Cici " +i);
                i++;
                textView4.setText("Cici " +i);
                i++;
                textView5.setText("Cici " +i);


            }
        });

    }

    public void mydarl(View a){




    }



}