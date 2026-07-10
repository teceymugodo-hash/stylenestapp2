package com.example.stylenest;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.stylenest.ui.cart.CartFragment;
import com.example.stylenest.ui.categories.CategoriesFragment;
import com.example.stylenest.ui.home.HomeFragment;
import com.example.stylenest.ui.profile.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private final Fragment homeFragment = new HomeFragment();
    private final Fragment categoriesFragment = new CategoriesFragment();
    private final Fragment cartFragment = new CartFragment();
    private final Fragment profileFragment = new ProfileFragment();
    private final FragmentManager fm = getSupportFragmentManager();
    private Fragment active = homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BottomNavigationView navView = findViewById(R.id.bottom_navigation);

        findViewById(R.id.btn_menu).setOnClickListener(v -> 
            Toast.makeText(this, "Menu coming soon!", Toast.LENGTH_SHORT).show()
        );

        findViewById(R.id.logo_text).setOnClickListener(v -> {
            fm.beginTransaction().hide(active).show(homeFragment).commit();
            active = homeFragment;
            navView.setSelectedItemId(R.id.navigation_home);
        });

        findViewById(R.id.btn_notifications).setOnClickListener(v -> 
            Toast.makeText(this, "No new notifications", Toast.LENGTH_SHORT).show()
        );

        findViewById(R.id.btn_cart_header).setOnClickListener(v -> {
            fm.beginTransaction().hide(active).show(cartFragment).commit();
            active = cartFragment;
            navView.setSelectedItemId(R.id.navigation_cart);
        });

        fm.beginTransaction().add(R.id.nav_host_fragment, profileFragment, "4").hide(profileFragment).commit();
        fm.beginTransaction().add(R.id.nav_host_fragment, cartFragment, "3").hide(cartFragment).commit();
        fm.beginTransaction().add(R.id.nav_host_fragment, categoriesFragment, "2").hide(categoriesFragment).commit();
        fm.beginTransaction().add(R.id.nav_host_fragment, homeFragment, "1").commit();

        navView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.navigation_home) {
                findViewById(R.id.header).setVisibility(View.VISIBLE);
                fm.beginTransaction().hide(active).show(homeFragment).commit();
                active = homeFragment;
                return true;
            } else if (itemId == R.id.navigation_categories) {
                findViewById(R.id.header).setVisibility(View.VISIBLE);
                fm.beginTransaction().hide(active).show(categoriesFragment).commit();
                active = categoriesFragment;
                return true;
            } else if (itemId == R.id.navigation_cart) {
                findViewById(R.id.header).setVisibility(View.VISIBLE);
                fm.beginTransaction().hide(active).show(cartFragment).commit();
                active = cartFragment;
                return true;
            } else if (itemId == R.id.navigation_profile) {
                findViewById(R.id.header).setVisibility(View.GONE);
                fm.beginTransaction().hide(active).show(profileFragment).commit();
                active = profileFragment;
                return true;
            }
            return false;
        });
    }
}