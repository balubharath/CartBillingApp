package com.aloneliontech.cartnew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.aloneliontech.cartnew.Fragements.CartFragment;
import com.aloneliontech.cartnew.Fragements.ProductFragment;
import com.aloneliontech.cartnew.Fragements.UpdateFragment;
import com.aloneliontech.cartnew.Fragements.addFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    Fragment fragment;
    private SearchView searchView;

    BottomNavigationView navigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        bottomNavigation();
        fragment = new ProductFragment();
        loadFragment(fragment);
        navigation.setSelectedItemId(R.id.products);
    }

    private void bottomNavigation() {
        navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.products:
                    fragment = new ProductFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.add:
                    fragment = new addFragment();
                     loadFragment(fragment);
                    return true;
                case R.id.update:
                    fragment = new UpdateFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.cart:
                    fragment = new CartFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };


    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }



}