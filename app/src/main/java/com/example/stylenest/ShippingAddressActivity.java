package com.example.stylenest;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.stylenest.model.ShippingAddress;
import java.util.ArrayList;
import java.util.List;

public class ShippingAddressActivity extends AppCompatActivity implements ShippingAddressAdapter.OnAddressSelectedListener {

    private List<ShippingAddress> addressList;
    private ShippingAddressAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping_address);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(v -> finish());

        findViewById(R.id.btn_add_new).setOnClickListener(v -> 
            Toast.makeText(this, "Add New Address screen coming soon!", Toast.LENGTH_SHORT).show()
        );

        RecyclerView recyclerView = findViewById(R.id.recycler_addresses);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        addressList = new ArrayList<>();
        addressList.add(new ShippingAddress("Home", "Wanjiku M.", "123 Green Street, Kilimani\nNairobi, Kenya\n00100", "+254 712 345 678", R.drawable.ic_home, true, true));
        addressList.add(new ShippingAddress("Work", "Wanjiku M.", "Tech Hub, 5th Floor, Ngong Road\nNairobi, Kenya\n00100", "+254 712 345 678", R.drawable.ic_launcher_foreground, false, false));
        addressList.add(new ShippingAddress("Parents' Home", "Wanjiku M.", "45 Riverside Drive, Westlands\nNairobi, Kenya\n00800", "+254 712 345 678", R.drawable.ic_launcher_foreground, false, false));
        addressList.add(new ShippingAddress("Holiday Home", "Wanjiku M.", "Beach Road, Diani\nUkunda, Kwale\n80401", "+254 712 345 678", R.drawable.ic_launcher_foreground, false, false));

        adapter = new ShippingAddressAdapter(addressList, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onAddressSelected(int position) {
        for (int i = 0; i < addressList.size(); i++) {
            addressList.get(i).setSelected(i == position);
        }
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "Selected: " + addressList.get(position).getType(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMoreOptionsClick(ShippingAddress address) {
        Toast.makeText(this, "Options for " + address.getType() + " address", Toast.LENGTH_SHORT).show();
    }
}