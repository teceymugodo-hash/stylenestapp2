package com.example.stylenest;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class EditProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        
        findViewById(R.id.btn_back).setOnClickListener(v -> finish());
        findViewById(R.id.btn_save).setOnClickListener(v -> {
            Toast.makeText(this, "Profile updated successfully", Toast.LENGTH_SHORT).show();
            finish();
        });

        // Personal Information
        setupTextRow(findViewById(R.id.row_full_name), R.drawable.ic_launcher_foreground, "Full Name", "Wanjiku M.");
        setupTextRow(findViewById(R.id.row_email), R.drawable.ic_launcher_foreground, "Email Address", "wanjiku.m@gmail.com");
        setupTextRow(findViewById(R.id.row_phone), R.drawable.ic_launcher_foreground, "Phone Number", "+254 712 345 678");
        setupDateRow(findViewById(R.id.row_dob), R.drawable.ic_launcher_foreground, "Date of Birth", "12 May 1996");
        setupChoiceRow(findViewById(R.id.row_gender), R.drawable.ic_launcher_foreground, "Gender", "Female", new String[]{"Female", "Male", "Other"});

        // Address
        setupTextRow(findViewById(R.id.row_default_address), R.drawable.ic_launcher_foreground, "Default Address", "123 Green Street, Nairobi, Kenya");
        setupActionRow(findViewById(R.id.row_manage_addresses), R.drawable.ic_launcher_foreground, "Manage Addresses", "3 saved addresses", "Opening Address Manager...");

        // Account & Security
        setupActionRow(findViewById(R.id.row_change_password), R.drawable.ic_launcher_foreground, "Change Password", "********", "Opening Change Password...");
        setupChoiceRow(findViewById(R.id.row_2fa), R.drawable.ic_launcher_foreground, "Two-Factor Authentication", "Off", new String[]{"On", "Off"});
        setupChoiceRow(findViewById(R.id.row_biometric), R.drawable.ic_launcher_foreground, "Biometric Login", "On", new String[]{"On", "Off"});

        // Preferences
        setupActionRow(findViewById(R.id.row_notifications), R.drawable.ic_launcher_foreground, "Notification Preferences", "", "Opening Notifications...");
        setupChoiceRow(findViewById(R.id.row_language), R.drawable.ic_launcher_foreground, "Language", "English", new String[]{"English", "Swahili", "French", "Spanish"});
        setupChoiceRow(findViewById(R.id.row_currency), R.drawable.ic_launcher_foreground, "Currency", "KES (KSh)", new String[]{"KES (KSh)", "USD ($)", "EUR (€)", "GBP (£)"});
        setupChoiceRow(findViewById(R.id.row_size), R.drawable.ic_launcher_foreground, "Size Preference", "M", new String[]{"XS", "S", "M", "L", "XL", "XXL"});

        findViewById(R.id.btn_logout_text).setOnClickListener(v -> 
            new AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("Are you sure you want to logout?")
                .setPositiveButton("Logout", (dialog, which) -> {
                    Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show();
                    finish();
                })
                .setNegativeButton("Cancel", null)
                .show()
        );
    }

    private void setupTextRow(View rowView, int iconRes, String label, String initialValue) {
        setupRow(rowView, iconRes, label, initialValue, v -> showEditDialog(label, (TextView) rowView.findViewById(R.id.row_value)));
    }

    private void setupDateRow(View rowView, int iconRes, String label, String initialValue) {
        setupRow(rowView, iconRes, label, initialValue, v -> showDatePicker((TextView) rowView.findViewById(R.id.row_value)));
    }

    private void setupChoiceRow(View rowView, int iconRes, String label, String initialValue, String[] choices) {
        setupRow(rowView, iconRes, label, initialValue, v -> showChoiceDialog(label, choices, (TextView) rowView.findViewById(R.id.row_value)));
    }

    private void setupActionRow(View rowView, int iconRes, String label, String initialValue, String toastMsg) {
        setupRow(rowView, iconRes, label, initialValue, v -> Toast.makeText(this, toastMsg, Toast.LENGTH_SHORT).show());
    }

    private void setupRow(View rowView, int iconRes, String label, String initialValue, View.OnClickListener listener) {
        if (rowView == null) return;
        
        ImageView icon = rowView.findViewById(R.id.row_icon);
        TextView labelText = rowView.findViewById(R.id.row_label);
        TextView valueText = rowView.findViewById(R.id.row_value);
        
        if (icon != null) icon.setImageResource(iconRes);
        if (labelText != null) labelText.setText(label);
        if (valueText != null) {
            valueText.setText(initialValue);
            valueText.setVisibility(initialValue.isEmpty() ? View.GONE : View.VISIBLE);
        }
        
        rowView.setOnClickListener(listener);
    }

    private void showEditDialog(String title, TextView valueView) {
        EditText input = new EditText(this);
        input.setText(valueView.getText());
        input.setSelection(input.getText().length());
        
        if (title.contains("Email")) {
            input.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        } else if (title.contains("Phone")) {
            input.setInputType(InputType.TYPE_CLASS_PHONE);
        }

        new AlertDialog.Builder(this)
            .setTitle("Edit " + title)
            .setView(input)
            .setPositiveButton("OK", (dialog, which) -> {
                String newValue = input.getText().toString();
                valueView.setText(newValue);
                valueView.setVisibility(newValue.isEmpty() ? View.GONE : View.VISIBLE);
            })
            .setNegativeButton("Cancel", null)
            .show();
    }

    private void showChoiceDialog(String title, String[] choices, TextView valueView) {
        new AlertDialog.Builder(this)
            .setTitle("Select " + title)
            .setItems(choices, (dialog, which) -> {
                valueView.setText(choices[which]);
                valueView.setVisibility(View.VISIBLE);
            })
            .show();
    }

    private void showDatePicker(TextView valueView) {
        Calendar calendar = Calendar.getInstance();
        new DatePickerDialog(this, (view, year, month, dayOfMonth) -> {
            String date = dayOfMonth + " " + getMonthName(month) + " " + year;
            valueView.setText(date);
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    private String getMonthName(int month) {
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        return months[month];
    }
}