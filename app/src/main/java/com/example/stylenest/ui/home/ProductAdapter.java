package com.example.stylenest.ui.home;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.stylenest.ProductDetailActivity;
import com.example.stylenest.R;
import com.example.stylenest.model.Product;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> productList;

    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.productName.setText(product.getName());
        holder.productPrice.setText(product.getPrice());
        holder.productImage.setImageResource(product.getImageResource());
        
        if (holder.productRating != null) {
            if (product.getReviewCount() != null && !product.getReviewCount().isEmpty()) {
                holder.productRating.setText("(" + product.getReviewCount() + ")");
            } else {
                holder.productRating.setText(product.getRating());
            }
        }

        if (holder.productOriginalPrice != null) {
            if (product.getOriginalPrice() != null) {
                holder.productOriginalPrice.setVisibility(View.VISIBLE);
                holder.productOriginalPrice.setText(product.getOriginalPrice());
                holder.productOriginalPrice.setPaintFlags(holder.productOriginalPrice.getPaintFlags() | android.graphics.Paint.STRIKE_THRU_TEXT_FLAG);
            } else {
                holder.productOriginalPrice.setVisibility(View.GONE);
            }
        }

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), ProductDetailActivity.class);
            intent.putExtra("name", product.getName());
            intent.putExtra("price", product.getPrice());
            intent.putExtra("image", product.getImageResource());
            intent.putExtra("description", product.getDescription());
            intent.putExtra("category", product.getCategory());
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public void updateProductList(List<Product> newProducts) {
        this.productList = newProducts;
        notifyDataSetChanged();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
        TextView productName;
        TextView productPrice;
        TextView productRating;
        TextView productOriginalPrice;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_image);
            productName = itemView.findViewById(R.id.product_name);
            productPrice = itemView.findViewById(R.id.product_price);
            productRating = itemView.findViewById(R.id.product_rating);
            productOriginalPrice = itemView.findViewById(R.id.product_original_price);
        }
    }
}