package com.example.stylenest.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.stylenest.EditProfileActivity;
import com.example.stylenest.HelpCenterActivity;
import com.example.stylenest.OrderListActivity;
import com.example.stylenest.PaymentMethodsActivity;
import com.example.stylenest.PrivacyPolicyActivity;
import com.example.stylenest.R;
import com.example.stylenest.ShippingAddressActivity;

public class ProfileFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        // Header Buttons
        root.findViewById(R.id.btn_settings).setOnClickListener(v -> showToast("Settings"));

        // Profile Card
        root.findViewById(R.id.card_profile).setOnClickListener(v -> 
            startActivity(new Intent(getContext(), EditProfileActivity.class))
        );
        root.findViewById(R.id.btn_change_photo).setOnClickListener(v -> showToast("Change Photo"));
        root.findViewById(R.id.btn_edit_profile_arrow).setOnClickListener(v -> 
            startActivity(new Intent(getContext(), EditProfileActivity.class))
        );

        // Stats Row
        root.findViewById(R.id.stat_orders).setOnClickListener(v -> showToast("My Orders List"));
        root.findViewById(R.id.stat_wishlist).setOnClickListener(v -> showToast("My Wishlist"));
        root.findViewById(R.id.stat_points).setOnClickListener(v -> showToast("StyleNest Points"));

        // Order Status
        root.findViewById(R.id.btn_view_all_orders).setOnClickListener(v -> openOrderList("All Orders"));
        root.findViewById(R.id.order_status_to_pay).setOnClickListener(v -> openOrderList("To Pay"));
        root.findViewById(R.id.order_status_to_ship).setOnClickListener(v -> openOrderList("To Ship"));
        root.findViewById(R.id.order_status_to_receive).setOnClickListener(v -> openOrderList("To Receive"));
        root.findViewById(R.id.order_status_to_review).setOnClickListener(v -> openOrderList("To Review"));

        // Account Options
        setupOption(root.findViewById(R.id.option_edit_profile), R.drawable.ic_launcher_foreground, "Edit Profile");
        root.findViewById(R.id.option_edit_profile).setOnClickListener(v -> 
            startActivity(new Intent(getContext(), EditProfileActivity.class))
        );
        
        setupOption(root.findViewById(R.id.option_shipping_address), R.drawable.ic_launcher_foreground, "Shipping Address");
        root.findViewById(R.id.option_shipping_address).setOnClickListener(v -> 
            startActivity(new Intent(getContext(), ShippingAddressActivity.class))
        );
        
        setupOption(root.findViewById(R.id.option_payment_methods), R.drawable.ic_cart, "Payment Methods");
        root.findViewById(R.id.option_payment_methods).setOnClickListener(v -> 
            startActivity(new Intent(getContext(), PaymentMethodsActivity.class))
        );

        // Support Options
        setupOption(root.findViewById(R.id.option_help_center), R.drawable.ic_launcher_foreground, "Help Center");
        root.findViewById(R.id.option_help_center).setOnClickListener(v -> 
            startActivity(new Intent(getContext(), HelpCenterActivity.class))
        );
        
        setupOption(root.findViewById(R.id.option_privacy_policy), R.drawable.ic_launcher_foreground, "Privacy Policy");
        root.findViewById(R.id.option_privacy_policy).setOnClickListener(v -> 
            startActivity(new Intent(getContext(), PrivacyPolicyActivity.class))
        );

        // Log Out
        root.findViewById(R.id.btn_logout).setOnClickListener(v -> 
            Toast.makeText(getContext(), "Logged out successfully", Toast.LENGTH_SHORT).show()
        );

        return root;
    }

    private void setupOption(View view, int iconRes, String title) {
        if (view == null) return;
        
        ImageView icon = view.findViewById(R.id.option_icon);
        TextView titleText = view.findViewById(R.id.option_title);
        
        if (icon != null) icon.setImageResource(iconRes);
        if (titleText != null) titleText.setText(title);
        
        view.setOnClickListener(v -> showToast(title));
    }

    private void showToast(String message) {
        Toast.makeText(getContext(), "Clicked: " + message, Toast.LENGTH_SHORT).show();
    }

    private void openOrderList(String status) {
        Intent intent = new Intent(getContext(), OrderListActivity.class);
        intent.putExtra("status", status);
        startActivity(intent);
    }
}