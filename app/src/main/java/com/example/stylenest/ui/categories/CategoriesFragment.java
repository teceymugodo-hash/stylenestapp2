package com.example.stylenest.ui.categories;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.stylenest.CategoryProductsActivity;
import com.example.stylenest.SubCategoryActivity;
import com.example.stylenest.R;
import java.util.ArrayList;
import java.util.List;

public class CategoriesFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_categories, container, false);
        
        RecyclerView recyclerView = root.findViewById(R.id.recycler_view_categories);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<String> categories = new ArrayList<>();
        categories.add("Women");
        categories.add("Kids");
        categories.add("Men");
        categories.add("Bags");
        categories.add("Shoes");
        categories.add("Accessories");

        CategoryAdapter adapter = new CategoryAdapter(categories, category -> {
            if ("Women".equalsIgnoreCase(category) || "Men".equalsIgnoreCase(category) || "Kids".equalsIgnoreCase(category)) {
                Intent intent = new Intent(getContext(), SubCategoryActivity.class);
                intent.putExtra("category", category);
                startActivity(intent);
            } else {
                Intent intent = new Intent(getContext(), CategoryProductsActivity.class);
                intent.putExtra("category", category);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);

        return root;
    }
}