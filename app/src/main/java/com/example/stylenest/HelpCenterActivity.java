package com.example.stylenest;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class HelpCenterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_center);
        
        findViewById(R.id.btn_back).setOnClickListener(v -> finish());
        findViewById(R.id.btn_contact_us).setOnClickListener(v -> 
            Toast.makeText(this, "Connecting to support...", Toast.LENGTH_SHORT).show()
        );
    }
}