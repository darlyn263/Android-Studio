package com.example.shopall.darl;

import android.icu.lang.UCharacter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopall.R;
import com.example.shopall.databinding.ActivityHomePageBinding;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity implements HomeInterface {


    private ActivityHomePageBinding binding;

    SearchView searchView;
    RecyclerView recyclerView;

    ArrayList<HomeModel> list,list2;
    HomeAdapter homeAdapter,homeAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        searchView = binding.searchView;
        recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(HomePage.this));
        recyclerView.setHasFixedSize(true);



        list = new ArrayList<>();
        list.add(new HomeModel("Joy", 23.8f, R.drawable.ic_menu_camera));
                list.add(new HomeModel("Moses", 23.8f, R.drawable.ic_menu_camera));
                list.add(new HomeModel("Junior",50.5f, R.drawable.ic_menu_camera ));

        homeAdapter = new HomeAdapter(list,this,this);
        recyclerView.setAdapter(homeAdapter);
        homeAdapter.notifyDataSetChanged();
        SearchView();


        list2 = new ArrayList<>(list);

        homeAdapter2 = new HomeAdapter(list2, this, this);
        recyclerView.setAdapter(homeAdapter2);





    }

    @Override
    public void ClickListener(HomeModel darl) {

        Toast.makeText(this, darl.getName().toString(), Toast.LENGTH_SHORT).show();

    }




    public void SearchView(){
        searchView = binding.searchView;

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                FiltedList(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                FiltedList(newText);
                return false;
            }
        });
    }








    public void FiltedList(String myDarl){
        String query = myDarl.toLowerCase();

        list2 = new ArrayList<HomeModel>();



        for (HomeModel object: list){

            if(object.getName().toLowerCase().contains(myDarl.toLowerCase())){

                list2.add(object);
            }
        }


        if (list2.isEmpty()) {

            Toast.makeText(this, "Not Found", Toast.LENGTH_SHORT).show();



        }else{

            homeAdapter2 = new HomeAdapter(list2,this,this);
            recyclerView.setAdapter(homeAdapter2);
            homeAdapter2.notifyDataSetChanged();
        }
    }







}

