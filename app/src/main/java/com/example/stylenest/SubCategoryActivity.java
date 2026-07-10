package com.example.stylenest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.stylenest.ui.categories.CategoryAdapter;
import java.util.ArrayList;
import java.util.List;

public class SubCategoryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);

        String mainCategory = getIntent().getStringExtra("category");
        TextView titleView = findViewById(R.id.text_sub_category_title);
        titleView.setText(mainCategory);

        RecyclerView recyclerView = findViewById(R.id.recycler_view_sub_categories);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> subCategories = new ArrayList<>();
        if ("Women".equalsIgnoreCase(mainCategory)) {
            subCategories.add("Skirts");
            subCategories.add("Tops");
            subCategories.add("Croptop");
            subCategories.add("Trousers");
            subCategories.add("Dresses");
            subCategories.add("Hoodies");
        } else if ("Men".equalsIgnoreCase(mainCategory)) {
            subCategories.add("Jeans");
            subCategories.add("Trousers");
            subCategories.add("T-shirts");
            subCategories.add("Shirts");
            subCategories.add("Jackets");
            subCategories.add("Hoodies");
        } else if ("Kids".equalsIgnoreCase(mainCategory)) {
            subCategories.add("Boys");
            subCategories.add("Girls");
        } else if ("Boys".equalsIgnoreCase(mainCategory) || "Girls".equalsIgnoreCase(mainCategory)) {
            subCategories.add("Jeans");
            subCategories.add("Trousers");
            subCategories.add("T-shirts");
            subCategories.add("Jackets");
            subCategories.add("Hoodies");
        }

        CategoryAdapter adapter = new CategoryAdapter(subCategories, subCategory -> {
            if ("Boys".equalsIgnoreCase(subCategory) || "Girls".equalsIgnoreCase(subCategory)) {
                Intent intent = new Intent(SubCategoryActivity.this, SubCategoryActivity.class);
                intent.putExtra("category", subCategory);
                startActivity(intent);
            } else {
                Intent intent = new Intent(SubCategoryActivity.this, CategoryProductsActivity.class);
                intent.putExtra("category", subCategory);
                intent.putExtra("mainCategory", mainCategory);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
    }
}