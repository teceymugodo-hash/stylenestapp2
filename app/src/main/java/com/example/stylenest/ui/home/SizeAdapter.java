package com.example.stylenest.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.example.stylenest.R;
import java.util.List;

public class SizeAdapter extends RecyclerView.Adapter<SizeAdapter.SizeViewHolder> {

    private final List<String> sizes;
    private int selectedPosition = -1;
    private final OnSizeSelectedListener listener;

    public interface OnSizeSelectedListener {
        void onSizeSelected(String size);
    }

    public SizeAdapter(List<String> sizes, OnSizeSelectedListener listener) {
        this.sizes = sizes;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SizeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_size_option, parent, false);
        return new SizeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SizeViewHolder holder, int position) {
        String size = sizes.get(position);
        holder.sizeText.setText(size);

        if (position == selectedPosition) {
            holder.itemView.setSelected(true);
            holder.sizeText.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.white));
        } else {
            holder.itemView.setSelected(false);
            holder.sizeText.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.text_dark));
        }

        holder.itemView.setOnClickListener(v -> {
            int previousSelected = selectedPosition;
            selectedPosition = holder.getAdapterPosition();
            notifyItemChanged(previousSelected);
            notifyItemChanged(selectedPosition);
            if (listener != null) {
                listener.onSizeSelected(size);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sizes.size();
    }

    static class SizeViewHolder extends RecyclerView.ViewHolder {
        TextView sizeText;

        public SizeViewHolder(@NonNull View itemView) {
            super(itemView);
            sizeText = (TextView) itemView;
        }
    }
}
