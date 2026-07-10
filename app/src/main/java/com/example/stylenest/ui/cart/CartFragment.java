package com.example.stylenest.ui.cart;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.stylenest.R;
import com.example.stylenest.model.CartManager;
import com.example.stylenest.model.Product;
import java.util.List;
import java.util.Locale;

public class CartFragment extends Fragment {
    
    private TextView tvTotalAmount;
    private TextView tvCartCount;
    private TextView tvSummarySubtotal;
    private TextView tvSummaryTotal;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_cart, container, false);
        
        recyclerViewSetup(root);
        
        tvTotalAmount = root.findViewById(R.id.tv_total_price);
        tvCartCount = root.findViewById(R.id.tv_cart_count);
        tvSummarySubtotal = root.findViewById(R.id.tv_summary_subtotal);
        tvSummaryTotal = root.findViewById(R.id.tv_summary_total);
        
        updateCartUI();

        root.findViewById(R.id.btn_checkout).setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), com.example.stylenest.ShippingAddressActivity.class);
            startActivity(intent);
        });

        return root;
    }

    private void recyclerViewSetup(View root) {
        RecyclerView recyclerView = root.findViewById(R.id.recycler_cart_items);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onResume() {
        super.onResume();
        updateCartUI();
    }

    private void updateCartUI() {
        List<Product> cartItems = CartManager.getInstance().getCartItems();
        
        if (getView() == null) return;

        RecyclerView recyclerView = getView().findViewById(R.id.recycler_cart_items);
        CartAdapter adapter = new CartAdapter(cartItems);
        recyclerView.setAdapter(adapter);

        tvCartCount.setText(String.format(Locale.getDefault(), "%d Items", cartItems.size()));

        double subtotal = 0;
        for (Product item : cartItems) {
            try {
                // Handle both "KSh" and "$" for robustness
                String priceStr = item.getPrice().replace("KSh", "").replace("$", "").replace(",", "").trim();
                subtotal += Double.parseDouble(priceStr);
            } catch (NumberFormatException e) {
                // ignore
            }
        }

        double shipping = cartItems.isEmpty() ? 0 : 500.0; // Changed to KSh 500
        double total = subtotal + shipping;

        tvTotalAmount.setText(String.format(Locale.getDefault(), "KSh %.2f", total));
        tvSummarySubtotal.setText(String.format(Locale.getDefault(), "KSh %.2f", subtotal));
        tvSummaryTotal.setText(String.format(Locale.getDefault(), "KSh %.2f", total));
        
        TextView tvSummaryShipping = getView().findViewById(R.id.tv_summary_shipping);
        if (tvSummaryShipping != null) {
            tvSummaryShipping.setText(String.format(Locale.getDefault(), "KSh %.2f", shipping));
        }
    }
}