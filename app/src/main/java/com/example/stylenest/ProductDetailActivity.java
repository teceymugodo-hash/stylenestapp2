package com.example.stylenest;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.stylenest.R;
import com.example.stylenest.model.CartManager;
import com.example.stylenest.model.Product;
import com.example.stylenest.ui.home.SizeAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductDetailActivity extends AppCompatActivity {
    private String selectedSize = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        String name = getIntent().getStringExtra("name");
        String price = getIntent().getStringExtra("price");
        int image = getIntent().getIntExtra("image", R.drawable.ic_launcher_foreground);
        String description = getIntent().getStringExtra("description");
        String category = getIntent().getStringExtra("category");

        ImageView imageView = findViewById(R.id.detail_image);
        TextView nameView = findViewById(R.id.detail_name);
        TextView priceView = findViewById(R.id.detail_price);
        TextView descriptionView = findViewById(R.id.detail_description);

        imageView.setImageResource(image);
        nameView.setText(name);
        priceView.setText(price);
        if (descriptionView != null) {
            descriptionView.setText(description);
        }

        setupSizeSelection(category);

        findViewById(R.id.button_add_to_cart).setOnClickListener(v -> {
            if (selectedSize.isEmpty()) {
                Toast.makeText(this, "Please select a size", Toast.LENGTH_SHORT).show();
                return;
            }
            Product product = new Product(String.valueOf(System.currentTimeMillis()), name, price, image, "4.5", description, category);
            CartManager.getInstance().addProduct(product);
            Toast.makeText(this, "Added to cart (" + selectedSize + ")!", Toast.LENGTH_SHORT).show();
        });
    }

    private void setupSizeSelection(String category) {
        RecyclerView recyclerView = findViewById(R.id.recycler_view_sizes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        List<String> sizes;
        if ("Shoes".equalsIgnoreCase(category)) {
            sizes = Arrays.asList(
                "UK 3 (EU 36)", "UK 4 (EU 37)", "UK 5 (EU 38)", 
                "UK 6 (EU 39)", "UK 7 (EU 40/41)", "UK 8 (EU 42)", "UK 9 (EU 43)"
            );
        } else {
            // Default clothing sizes
            sizes = Arrays.asList("XS", "S", "M", "L", "XL", "XXL");
        }

        SizeAdapter adapter = new SizeAdapter(sizes, size -> selectedSize = size);
        recyclerView.setAdapter(adapter);
    }
}
