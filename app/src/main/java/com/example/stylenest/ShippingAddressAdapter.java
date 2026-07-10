package com.example.stylenest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.example.stylenest.model.ShippingAddress;
import com.google.android.material.card.MaterialCardView;
import java.util.List;

public class ShippingAddressAdapter extends RecyclerView.Adapter<ShippingAddressAdapter.AddressViewHolder> {

    private List<ShippingAddress> addressList;
    private OnAddressSelectedListener listener;

    public interface OnAddressSelectedListener {
        void onAddressSelected(int position);
        void onMoreOptionsClick(ShippingAddress address);
    }

    public ShippingAddressAdapter(List<ShippingAddress> addressList, OnAddressSelectedListener listener) {
        this.addressList = addressList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AddressViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shipping_address, parent, false);
        return new AddressViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddressViewHolder holder, int position) {
        ShippingAddress address = addressList.get(position);
        holder.tvType.setText(address.getType());
        holder.tvUserName.setText(address.getUserName());
        holder.tvDetails.setText(address.getDetails());
        holder.tvPhone.setText(address.getPhone());
        holder.ivIcon.setImageResource(address.getIconRes());
        holder.tvDefault.setVisibility(address.isDefault() ? View.VISIBLE : View.GONE);
        holder.rbSelected.setChecked(address.isSelected());

        if (address.isSelected()) {
            holder.card.setStrokeColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.primary_orange));
            holder.card.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.flash_sale_bg));
        } else {
            holder.card.setStrokeColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.light_grey));
            holder.card.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.white));
        }

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onAddressSelected(position);
            }
        });

        holder.rbSelected.setOnClickListener(v -> {
            if (listener != null) {
                listener.onAddressSelected(position);
            }
        });

        holder.ivMore.setOnClickListener(v -> {
            if (listener != null) {
                listener.onMoreOptionsClick(address);
            }
        });
    }

    @Override
    public int getItemCount() {
        return addressList.size();
    }

    static class AddressViewHolder extends RecyclerView.ViewHolder {
        TextView tvType, tvUserName, tvDetails, tvPhone, tvDefault;
        ImageView ivIcon, ivMore;
        RadioButton rbSelected;
        MaterialCardView card;

        public AddressViewHolder(@NonNull View itemView) {
            super(itemView);
            tvType = itemView.findViewById(R.id.tv_address_type);
            tvUserName = itemView.findViewById(R.id.tv_user_name);
            tvDetails = itemView.findViewById(R.id.tv_address_details);
            tvPhone = itemView.findViewById(R.id.tv_phone);
            tvDefault = itemView.findViewById(R.id.tv_default_tag);
            ivIcon = itemView.findViewById(R.id.iv_address_icon);
            ivMore = itemView.findViewById(R.id.iv_more);
            rbSelected = itemView.findViewById(R.id.rb_selected);
            card = itemView.findViewById(R.id.address_card);
        }
    }
}