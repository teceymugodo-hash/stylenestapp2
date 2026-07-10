package com.example.stylenest;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PaymentMethodsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_methods);
        
        findViewById(R.id.btn_back).setOnClickListener(v -> finish());
        findViewById(R.id.btn_add_new).setOnClickListener(v -> 
            Toast.makeText(this, "Add new payment method", Toast.LENGTH_SHORT).show()
        );

        // Saved Methods
        setupPaymentRow(findViewById(R.id.method_visa), R.drawable.ic_launcher_foreground, "Visa ending in 4242", "Expires 12/26", true);
        setupPaymentRow(findViewById(R.id.method_mastercard), R.drawable.ic_launcher_foreground, "Mastercard ending in 8888", "Expires 08/27", false);
        setupPaymentRow(findViewById(R.id.method_mpesa), R.drawable.ic_launcher_foreground, "M-PESA", "254 712 345 678", false);
        setupPaymentRow(findViewById(R.id.method_airtel), R.drawable.ic_launcher_foreground, "Airtel Money", "254 712 345 678", false);
        setupPaymentRow(findViewById(R.id.method_equity), R.drawable.ic_launcher_foreground, "Equity Bank **** 1234", "Checking Account", false);

        // More Options
        setupOptionRow(findViewById(R.id.option_add_card), R.drawable.ic_launcher_foreground, "Add Credit / Debit Card", "Visa, Mastercard & more");
        setupOptionRow(findViewById(R.id.option_add_paypal), R.drawable.ic_launcher_foreground, "Add PayPal", "");
        setupOptionRow(findViewById(R.id.option_add_bank), R.drawable.ic_launcher_foreground, "Add Bank Account", "Transfer directly from your bank");
    }

    private void setupPaymentRow(View view, int iconRes, String title, String subtitle, boolean isDefault) {
        ImageView icon = view.findViewById(R.id.payment_icon);
        TextView titleText = view.findViewById(R.id.payment_title);
        TextView subtitleText = view.findViewById(R.id.payment_subtitle);
        TextView badge = view.findViewById(R.id.badge_default);

        icon.setImageResource(iconRes);
        titleText.setText(title);
        subtitleText.setText(subtitle);
        badge.setVisibility(isDefault ? View.VISIBLE : View.GONE);
        
        view.setOnClickListener(v -> Toast.makeText(this, "Selected: " + title, Toast.LENGTH_SHORT).show());
    }

    private void setupOptionRow(View view, int iconRes, String title, String subtitle) {
        ImageView icon = view.findViewById(R.id.row_icon);
        TextView label = view.findViewById(R.id.row_label);
        TextView value = view.findViewById(R.id.row_value);

        icon.setImageResource(iconRes);
        label.setText(title);
        value.setText(subtitle);
        value.setVisibility(subtitle.isEmpty() ? View.GONE : View.VISIBLE);
        
        view.setOnClickListener(v -> Toast.makeText(this, "Opening: " + title, Toast.LENGTH_SHORT).show());
    }
}