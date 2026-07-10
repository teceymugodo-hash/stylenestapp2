package com.example.stylenest;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.stylenest.ui.home.ProductAdapter;
import com.example.stylenest.model.Product;
import java.util.ArrayList;
import java.util.List;

public class OrderListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        String status = getIntent().getStringExtra("status");
        TextView titleView = findViewById(R.id.text_order_title);
        if (status != null) {
            titleView.setText(status);
        }

        findViewById(R.id.btn_back).setOnClickListener(v -> finish());

        RecyclerView recyclerView = findViewById(R.id.recycler_view_orders);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // Mock data based on status
        List<Product> orders = getMockOrders(status);
        recyclerView.setAdapter(new ProductAdapter(orders));
    }

    private List<Product> getMockOrders(String status) {
        List<Product> list = new ArrayList<>();
        if ("To Pay".equals(status)) {
            list.add(new Product("1", "Oversized Graphic T-Shirt", "KSh 1,200", R.drawable.graphic_tshirt));
        } else if ("To Ship".equals(status)) {
            list.add(new Product("2", "Ruched Bodycon Dress", "KSh 2,500", R.drawable.bodycon_dress));
        } else if ("To Receive".equals(status)) {
            list.add(new Product("3", "Classic White Sneakers", "KSh 4,500", R.drawable.ic_launcher_foreground));
        } else if ("To Review".equals(status)) {
            list.add(new Product("4", "Denim Jacket", "KSh 3,500", R.drawable.denim_jacket));
        } else {
            // All Orders
            list.add(new Product("1", "Oversized Graphic T-Shirt", "KSh 1,200", R.drawable.graphic_tshirt));
            list.add(new Product("2", "Ruched Bodycon Dress", "KSh 2,500", R.drawable.bodycon_dress));
        }
        return list;
    }
}
