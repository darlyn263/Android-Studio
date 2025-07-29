package com.example.shopall;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.example.shopall.ui.checkout.CheckoutFragment;
import com.example.shopall.ui.gallery.GalleryFragment;
import com.example.shopall.ui.home.HomeFragment;
import com.example.shopall.ui.profile.ProfileFragment;
import com.example.shopall.ui.shop.shopFragment;
import com.example.shopall.ui.shorts.Shorts;
import com.example.shopall.ui.slideshow.SlideshowFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shopall.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{


    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawer;

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .setAnchorView(R.id.fab).show();
            }
        });


        toolbar = binding.appBarMain.toolbar;
        setSupportActionBar(toolbar);
        drawer = binding.drawerLayout;
        navigationView = binding.navView;

        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);

        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
public boolean onOptionsItemSelected(@NonNull MenuItem item) {

    if (R.id.nav_home == item.getItemId()) {

    }


    return super.onOptionsItemSelected(item);
}

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {




        if (R.id.nav_home == item.getItemId()) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);


        } else if (R.id.nav_gallery == item.getItemId()) {
//            FirebaseAuth.getInstance().signOut();
//            Intent  intent = new Intent(this, Login.class);
//            startActivity(intent);
            Toast.makeText(this, "Darling", Toast.LENGTH_SHORT).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,new GalleryFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_gallery);


        } else if (R.id.nav_slideshow == item.getItemId()) {
//
            Toast.makeText(this, "Darling", Toast.LENGTH_SHORT).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,new SlideshowFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_slideshow);


        } else if (R.id.nav_checkout == item.getItemId()) {
//
            Toast.makeText(this, "Darling", Toast.LENGTH_SHORT).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,new CheckoutFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_checkout);


        } else if (R.id.nav_shorts == item.getItemId()) {
//
            Toast.makeText(this, "Darling", Toast.LENGTH_SHORT).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,new Shorts()).commit();
            navigationView.setCheckedItem(R.id.nav_shorts);


        } else if (R.id.nav_profile == item.getItemId()) {
//
            Toast.makeText(this, "Darling", Toast.LENGTH_SHORT).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,new ProfileFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_profile);


        } else if (R.id.nav_shop == item.getItemId()) {
//
            Toast.makeText(this, "Darling", Toast.LENGTH_SHORT).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,new shopFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_shop);


        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();




    }



}