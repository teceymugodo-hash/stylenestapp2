package com.example.stylenest.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.stylenest.CategoryProductsActivity;
import com.example.stylenest.R;
import com.example.stylenest.SubCategoryActivity;
import com.example.stylenest.model.Product;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    
    private final List<Product> allProducts = new ArrayList<>();
    private ProductAdapter searchAdapter;
    private RecyclerView searchResultsRecyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        
        initializeAllProducts();

        // Search Setup
        EditText searchEditText = root.findViewById(R.id.edit_search);
        searchResultsRecyclerView = root.findViewById(R.id.recycler_view_search_results);
        searchResultsRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        searchAdapter = new ProductAdapter(new ArrayList<>());
        searchResultsRecyclerView.setAdapter(searchAdapter);

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterProducts(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Banner Button
        View shopNowBtn = root.findViewById(R.id.btn_banner_shop_now);
        if (shopNowBtn != null) {
            shopNowBtn.setOnClickListener(v -> {
                Intent intent = new Intent(getContext(), CategoryProductsActivity.class);
                intent.putExtra("category", "Summer Collection");
                intent.putExtra("mainCategory", "All");
                startActivity(intent);
            });
        }

        // Category Clicks
        root.findViewById(R.id.cat_women).setOnClickListener(v -> openSubCategory("Women"));
        root.findViewById(R.id.cat_men).setOnClickListener(v -> openSubCategory("Men"));
        root.findViewById(R.id.cat_kids).setOnClickListener(v -> openSubCategory("Kids"));
        root.findViewById(R.id.cat_shoes).setOnClickListener(v -> openCategoryProducts("Shoes"));
        root.findViewById(R.id.cat_bags).setOnClickListener(v -> openCategoryProducts("Bags"));
        root.findViewById(R.id.cat_accessories).setOnClickListener(v -> openCategoryProducts("Accessories"));

        // New Arrivals RecyclerView
        RecyclerView arrivalsRecyclerView = root.findViewById(R.id.recycler_view_new_arrivals);
        arrivalsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        arrivalsRecyclerView.setAdapter(new ProductAdapter(getNewArrivals()));

        // Flash Sale RecyclerView
        RecyclerView flashSaleRecyclerView = root.findViewById(R.id.recycler_view_flash_sale);
        flashSaleRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        flashSaleRecyclerView.setAdapter(new ProductAdapter(getFlashSaleProducts()));

        // View All Clicks
        root.findViewById(R.id.text_new_arrivals_view_all).setOnClickListener(v -> showToast("New Arrivals"));
        root.findViewById(R.id.text_flash_sale_view_all).setOnClickListener(v -> showToast("Flash Sale"));
        root.findViewById(R.id.text_brands_view_all).setOnClickListener(v -> showToast("Brands"));

        return root;
    }

    private void initializeAllProducts() {
        allProducts.clear();
        // New Arrivals
        allProducts.add(new Product("na1", "Floral Dress", "KSh 2,800", R.drawable.maxi_dress, "4.8", 
            "A beautiful floral maxi dress perfect for summer outings. Made with breathable cotton for all-day comfort.", "Dresses"));
        allProducts.add(new Product("na2", "Linen Shirt", "KSh 2,200", R.drawable.linen_shirt, "4.7", 
            "Classic men's linen shirt in a relaxed fit. Ideal for both casual and semi-formal occasions in warm weather.", "Shirts"));
        allProducts.add(new Product("na3", "Oversized Hoodie", "KSh 3,200", R.drawable.mens_oversized_hoodie, "4.9", 
            "Premium quality oversized hoodie with a soft fleece interior. Features a kangaroo pocket and adjustable drawstring hood.", "Hoodies"));
        allProducts.add(new Product("na4", "Pleated Skirt", "KSh 2,000", R.drawable.pleated_skirt, "4.6", 
            "Elegant pleated midi skirt with a high-waist design. Versatile piece that can be dressed up or down.", "Skirts"));

        // Flash Sale
        allProducts.add(new Product("fs1", "Hoodie", "KSh 2,000", "KSh 3,000", "33%", R.drawable.women_hoodie, "4.5", "50", 
            "Comfortable women's hoodie available in multiple colors. Great for light workouts or lounging at home.", "Hoodies"));
        allProducts.add(new Product("fs2", "T-Shirt", "KSh 1,200", "KSh 2,000", "40%", R.drawable.kids_plain_tshirt, "4.4", "80", 
            "Simple and durable kids' plain t-shirt. 100% cotton material ensures comfort for active children.", "T-shirts"));
        allProducts.add(new Product("fs3", "Jeans", "KSh 2,500", "KSh 3,800", "34%", R.drawable.straight_leg_jeans, "4.7", "120", 
            "Classic straight-leg jeans with a timeless wash. Durable denim built to last through everyday wear.", "Jeans"));
        allProducts.add(new Product("fs4", "Sneakers", "KSh 2,800", "KSh 4,000", "30%", R.drawable.shoes_casual, "4.8", "95", 
            "Stylish casual sneakers with a cushioned sole for maximum comfort. Perfect for long walks and daily activities.", "Shoes"));

        // Additional products for search/trending etc
        allProducts.add(new Product("tr1", "Oversized Hoodie", "KSh 2,500", R.drawable.oversized_hoodie, "4.5", 
            "Stay cozy in this oversized hoodie. Made from a blend of cotton and polyester for warmth and durability.", "Hoodies"));
        allProducts.add(new Product("tr2", "Blazer Jacket", "KSh 3,600", R.drawable.blazzer, "4.7", 
            "Sharp blazer jacket for a sophisticated look. Features a slim fit and notched lapels.", "Jackets"));
        allProducts.add(new Product("tr3", "Classic Sneakers", "KSh 2,800", R.drawable.shoes_casual, "4.6", 
            "Versatile classic sneakers that go well with any outfit. Lightweight design with a slip-resistant sole.", "Shoes"));
        allProducts.add(new Product("tr4", "Basic T-Shirt", "KSh 1,500", R.drawable.kids_plain_tshirt, "4.4", 
            "Essential basic t-shirt in a regular fit. A staple for every wardrobe, available in various colors.", "T-shirts"));
    }

    private List<Product> getNewArrivals() {
        return allProducts.subList(0, 4);
    }

    private List<Product> getFlashSaleProducts() {
        return allProducts.subList(4, 8);
    }

    private void filterProducts(String query) {
        if (query.isEmpty()) {
            searchResultsRecyclerView.setVisibility(View.GONE);
            return;
        }

        List<Product> filteredList = new ArrayList<>();
        for (Product product : allProducts) {
            if (product.getName().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(product);
            }
        }

        if (filteredList.isEmpty()) {
            searchResultsRecyclerView.setVisibility(View.GONE);
        } else {
            searchResultsRecyclerView.setVisibility(View.VISIBLE);
            searchAdapter.updateProductList(filteredList);
        }
    }

    private void openSubCategory(String category) {
        Intent intent = new Intent(getContext(), SubCategoryActivity.class);
        intent.putExtra("category", category);
        startActivity(intent);
    }

    private void openCategoryProducts(String category) {
        Intent intent = new Intent(getContext(), CategoryProductsActivity.class);
        intent.putExtra("category", category);
        startActivity(intent);
    }

    private void showToast(String section) {
        Toast.makeText(getContext(), section + " list coming soon!", Toast.LENGTH_SHORT).show();
    }
}
