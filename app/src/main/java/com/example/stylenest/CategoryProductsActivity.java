package com.example.stylenest;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.stylenest.model.Product;
import com.example.stylenest.ui.home.ProductAdapter;
import java.util.ArrayList;
import java.util.List;

public class CategoryProductsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_products);

        String category = getIntent().getStringExtra("category");
        String mainCategory = getIntent().getStringExtra("mainCategory");
        TextView titleView = findViewById(R.id.text_category_title);
        titleView.setText(category);

        RecyclerView recyclerView = findViewById(R.id.recycler_view_category_products);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        List<Product> products = new ArrayList<>();

        if ("Summer Collection".equalsIgnoreCase(category)) {
            if ("Women".equalsIgnoreCase(mainCategory)) {
                products.add(new Product("scw1", "Floral Maxi Dress", "KSh 2,500", R.drawable.maxi_dress, "4.8", "Vibrant floral maxi dress, perfect for summer days.", "Summer Collection"));
                products.add(new Product("scw2", "Basic Crop Top", "KSh 1,200", R.drawable.basic_crop_top, "4.5", "Essential basic crop top for effortless summer style.", "Summer Collection"));
                products.add(new Product("scw3", "Wrap Skirt", "KSh 2,200", R.drawable.wrap_skirt, "4.6", "Stylish wrap skirt with a flattering silhouette.", "Summer Collection"));
                products.add(new Product("scw4", "Off-Shoulder Top", "KSh 1,800", R.drawable.off_shoulder_top_alt, "4.7", "Elegant off-shoulder top for a breezy summer look.", "Summer Collection"));
                products.add(new Product("scw5", "Casual Slides", "KSh 1,500", R.drawable.shoes_slippers, "4.4", "Comfortable slides for easy summer wear.", "Summer Collection"));
            } else if ("Men".equalsIgnoreCase(mainCategory)) {
                products.add(new Product("scm1", "Linen Shirt", "KSh 2,200", R.drawable.linen_shirt, "4.7", "Breathable linen shirt for a cool summer feel.", "Summer Collection"));
                products.add(new Product("scm2", "Polo T-Shirt", "KSh 1,800", R.drawable.polo_tshirt, "4.6", "Classic polo t-shirt for a smart-casual summer look.", "Summer Collection"));
                products.add(new Product("scm3", "Cotton Trousers", "KSh 2,800", R.drawable.cargo_pants, "4.5", "Lightweight cotton trousers for everyday comfort.", "Summer Collection"));
                products.add(new Product("scm4", "Casual Loafers", "KSh 4,500", R.drawable.shoes_casual, "4.8", "Stylish loafers to complete your summer outfit.", "Summer Collection"));
            } else if ("Boys".equalsIgnoreCase(mainCategory)) {
                products.add(new Product("scb1", "Graphic T-Shirt", "KSh 1,200", R.drawable.kids_graphic_tshirt, "4.5", "Cool graphic tee for active boys.", "Summer Collection"));
                products.add(new Product("scb2", "Cotton Trousers", "KSh 1,800", R.drawable.boys_cotton_trouser, "4.4", "Comfy cotton trousers for playtime.", "Summer Collection"));
                products.add(new Product("scb3", "Summer Hat", "KSh 800", R.drawable.ic_categories, "4.3", "Protect them from the sun with this cute hat.", "Summer Collection"));
            } else if ("Girls".equalsIgnoreCase(mainCategory)) {
                products.add(new Product("scg1", "Printed T-Shirt", "KSh 1,200", R.drawable.kids_printed_tshirt, "4.6", "Pretty printed t-shirt for stylish girls.", "Summer Collection"));
                products.add(new Product("scg2", "Cotton Trousers", "KSh 1,800", R.drawable.girls_cotton_trouser, "4.5", "Lightweight trousers for summer fun.", "Summer Collection"));
                products.add(new Product("scg3", "Floral Dress", "KSh 2,200", R.drawable.maxi_dress, "4.8", "Adorable floral dress for special summer days.", "Summer Collection"));
            } else {
                products.add(new Product("sca1", "Men's Linen Shirt", "KSh 2,200", R.drawable.linen_shirt, "4.7", "Classic linen shirt for men.", "Summer Collection"));
                products.add(new Product("sca2", "Women's Maxi Dress", "KSh 2,500", R.drawable.maxi_dress, "4.8", "Elegant maxi dress for women.", "Summer Collection"));
                products.add(new Product("sca3", "Kids' Graphic Tee", "KSh 1,200", R.drawable.kids_graphic_tshirt, "4.5", "Fun graphic tee for kids.", "Summer Collection"));
            }
        } else if ("Bags".equalsIgnoreCase(category)) {
            products.add(new Product("b1", "Backpack", "KSh 3,500", R.drawable.backpack, "4.6", "Spacious and durable backpack for daily use.", "Bags"));
            products.add(new Product("b2", "Boxbag", "KSh 4,500", R.drawable.boxbag, "4.7", "Elegant box-shaped handbag for a modern look.", "Bags"));
            products.add(new Product("b3", "Briefcase", "KSh 8,500", R.drawable.briefcase, "4.8", "Professional briefcase for your office essentials.", "Bags"));
            products.add(new Product("b4", "Camera bag", "KSh 2,500", R.drawable.camera_bag, "4.5", "Compact bag to keep your camera safe and accessible.", "Bags"));
            products.add(new Product("b5", "Duffle bag", "KSh 6,000", R.drawable.duffle_bag, "4.6", "Large duffle bag for travel or gym.", "Bags"));
            products.add(new Product("b6", "Messenger bag", "KSh 4,000", R.drawable.messenger_bag, "4.5", "Stylish messenger bag for a casual vibe.", "Bags"));
            products.add(new Product("b7", "Mini back pack", "KSh 3,200", R.drawable.mini_backpack, "4.4", "Cute and compact mini backpack.", "Bags"));
            products.add(new Product("b8", "Quilted bag", "KSh 5,000", R.drawable.quilted_bag, "4.7", "Sophisticated quilted handbag.", "Bags"));
            products.add(new Product("b9", "Sling bag", "KSh 1,800", R.drawable.sling_bag, "4.3", "Lightweight sling bag for your essentials.", "Bags"));
            products.add(new Product("b10", "Travel bag", "KSh 10,000", R.drawable.travel_bag, "4.9", "Premium travel bag for long trips.", "Bags"));
        } else if ("Dresses".equalsIgnoreCase(category)) {
            products.add(new Product("d1", "Shirt dress", "KSh 3,500", R.drawable.shirt_dress, "4.5", "Versatile shirt dress for a smart-casual look.", "Dresses"));
            products.add(new Product("d2", "Casual dress", "KSh 2,500", R.drawable.casual_dress, "4.4", "Simple and comfortable dress for everyday wear.", "Dresses"));
            products.add(new Product("d3", "Maxi dress", "KSh 4,500", R.drawable.maxi_dress, "4.8", "Flowy maxi dress for an elegant appearance.", "Dresses"));
            products.add(new Product("d4", "Midi dress", "KSh 4,000", R.drawable.midi_dress, "4.7", "Sophisticated midi dress for any occasion.", "Dresses"));
            products.add(new Product("d5", "Mini dress", "KSh 3,200", R.drawable.mini_dress, "4.6", "Trendy mini dress for a youthful look.", "Dresses"));
            products.add(new Product("d6", "Cocktail dress", "KSh 6,000", R.drawable.cocktail_dress, "4.9", "Stunning cocktail dress for evening events.", "Dresses"));
            products.add(new Product("d7", "A-line dress", "KSh 4,000", R.drawable.a_line_dress, "4.5", "Classic A-line dress with a flattering fit.", "Dresses"));
            products.add(new Product("d8", "Wrap dress", "KSh 3,500", R.drawable.wrap_dress, "4.6", "Timeless wrap dress that suits everyone.", "Dresses"));
            products.add(new Product("d9", "Party dress", "KSh 5,000", R.drawable.party_dress, "4.7", "Glamorous party dress to shine at any celebration.", "Dresses"));
            products.add(new Product("d10", "Bodycon dress", "KSh 3,800", R.drawable.bodycon_dress, "4.8", "Figure-hugging bodycon dress for a bold statement.", "Dresses"));
        } else if ("Skirts".equalsIgnoreCase(category)) {
            products.add(new Product("s1", "Wrap skirt", "KSh 2,500", R.drawable.wrap_skirt, "4.5", "Stylish wrap skirt for a feminine touch.", "Skirts"));
            products.add(new Product("s2", "Bodycon skirt", "KSh 1,800", R.drawable.bodycon_skirt, "4.3", "Classic bodycon skirt for a sleek look.", "Skirts"));
            products.add(new Product("s3", "Cargo skirt", "KSh 3,200", R.drawable.cargo_skirt, "4.6", "Utilitarian cargo skirt with a modern edge.", "Skirts"));
            products.add(new Product("s4", "Pleated skirt", "KSh 2,500", R.drawable.pleated_skirt, "4.7", "Elegant pleated skirt for a sophisticated vibe.", "Skirts"));
            products.add(new Product("s5", "tennis skirt", "KSh 2,200", R.drawable.tennis_skirt, "4.4", "Active-inspired tennis skirt for casual wear.", "Skirts"));
            products.add(new Product("s6", "Pencil skirt", "KSh 2,500", R.drawable.pencil_skirt, "4.8", "Professional pencil skirt for work.", "Skirts"));
            products.add(new Product("s8", "Midi skirt", "KSh 3,500", R.drawable.midi_skirt, "4.5", "Versatile midi skirt for any season.", "Skirts"));
            products.add(new Product("s9", "Maxi skirt", "KSh 4,000", R.drawable.maxi_skirt, "4.6", "Long and flowy maxi skirt for maximum comfort.", "Skirts"));
            products.add(new Product("s10", "Denim skirt", "KSh 3,000", R.drawable.denim_skirt, "4.7", "Essential denim skirt for your wardrobe.", "Skirts"));
            products.add(new Product("s11", "A lined skirt", "KSh 2,600", R.drawable.a_line_skirt, "4.4", "Simple A-line skirt with a comfortable fit.", "Skirts"));
            products.add(new Product("s12", "Tiered skirt", "KSh 2,800", R.drawable.tiered_skirt, "4.5", "Playful tiered skirt for a bohemian look.", "Skirts"));
        } else if ("T-shirts".equalsIgnoreCase(category)) {
            if ("Boys".equalsIgnoreCase(mainCategory) || "Girls".equalsIgnoreCase(mainCategory)) {
                products.add(new Product("bt1", "Pocket T-Shirt", "KSh 1,200", R.drawable.kids_pocket_tshirt, "4.5", "Basic kids tee with a handy pocket.", "T-shirts"));
                products.add(new Product("bt2", "Graphic T-Shirt", "KSh 1,400", R.drawable.kids_graphic_tshirt, "4.6", "Cool graphic print for kids.", "T-shirts"));
            } else {
                products.add(new Product("t1", "Polo T-Shirt", "KSh 1,800", R.drawable.polo_tshirt, "4.6", "Classic polo for men.", "T-shirts"));
                products.add(new Product("t2", "Graphic T-Shirt", "KSh 1,500", R.drawable.graphic_tshirt, "4.5", "Casual graphic tee for daily wear.", "T-shirts"));
            }
        } else if ("Shirts".equalsIgnoreCase(category)) {
            if ("Men".equalsIgnoreCase(mainCategory)) {
                products.add(new Product("ms1", "Casual Shirt", "KSh 2,500", R.drawable.casual_shirt, "4.5", "Comfortable casual shirt for everyday.", "Shirts"));
                products.add(new Product("ms2", "Flannel Shirt", "KSh 3,000", R.drawable.flannel, "4.6", "Warm and stylish flannel shirt.", "Shirts"));
                products.add(new Product("ms3", "Formal Shirt", "KSh 3,200", R.drawable.formal_shirt, "4.7", "Sharp formal shirt for the office.", "Shirts"));
                products.add(new Product("ms4", "Linen Shirt", "KSh 3,500", R.drawable.linen_shirt, "4.8", "Premium linen shirt for a refined look.", "Shirts"));
                products.add(new Product("ms5", "Long Sleeve Shirt", "KSh 2,800", R.drawable.long_sleeve_shirt, "4.6", "Versatile long sleeve shirt.", "Shirts"));
                products.add(new Product("ms6", "Oxford Shirt", "KSh 2,500", R.drawable.oxford_shirt, "4.5", "Classic oxford button-down.", "Shirts"));
                products.add(new Product("ms7", "Short Sleeve Shirt", "KSh 2,200", R.drawable.short_sleeve_shirt, "4.4", "Cool short sleeve shirt for summer.", "Shirts"));
            } else {
                products.add(new Product("s1", "Casual Shirt", "KSh 2,500", R.drawable.casual_shirt, "4.5", "Simple casual shirt.", "Shirts"));
                products.add(new Product("s2", "Formal Shirt", "KSh 3,200", R.drawable.formal_shirt, "4.6", "Classic formal shirt.", "Shirts"));
                products.add(new Product("s3", "Oxford Shirt", "KSh 2,500", R.drawable.oxford_shirt, "4.5", "Timeless oxford shirt.", "Shirts"));
                products.add(new Product("s4", "Linen Shirt", "KSh 3,500", R.drawable.linen_shirt, "4.7", "Breathable linen shirt.", "Shirts"));
            }
        } else if ("Hoodies".equalsIgnoreCase(category)) {
            if ("Women".equalsIgnoreCase(mainCategory)) {
                products.add(new Product("wh0", "Hoodie", "KSh 3,200", R.drawable.women_hoodie, "4.5", "Cozy hoodie for women.", "Hoodies"));
                products.add(new Product("wh5", "Oversized Hoodie", "KSh 4,000", R.drawable.women_oversized_hoodie, "4.8", "Trendy oversized fit.", "Hoodies"));
            } else if ("Boys".equalsIgnoreCase(mainCategory) || "Girls".equalsIgnoreCase(mainCategory)) {
                products.add(new Product("bh1", "Graphic Hoodie", "KSh 2,500", R.drawable.kids_graphic_hoodie, "4.6", "Fun graphic hoodie for kids.", "Hoodies"));
            } else {
                products.add(new Product("h1", "Graphic Hoodie", "KSh 3,200", R.drawable.mens_graphic_hoodie, "4.7", "Stylish graphic hoodie for men.", "Hoodies"));
                products.add(new Product("h6", "Oversized Hoodie", "KSh 4,000", R.drawable.mens_oversized_hoodie, "4.8", "Relaxed oversized fit.", "Hoodies"));
            }
        } else if ("Jackets".equalsIgnoreCase(category)) {
            products.add(new Product("mj1", "Denim Jacket", "KSh 4,000", R.drawable.denim_jacket, "4.6", "Classic denim jacket for all seasons.", "Jackets"));
            products.add(new Product("mj2", "Bomber Jacket", "KSh 4,500", R.drawable.bomber_jacket, "4.7", "Cool bomber jacket for a modern look.", "Jackets"));
        } else if ("Trousers".equalsIgnoreCase(category)) {
            products.add(new Product("tr1", "Cargo Pants", "KSh 3,500", R.drawable.cargo_pants, "4.5", "Practical cargo pants with multiple pockets.", "Trousers"));
            products.add(new Product("tr2", "Chinos", "KSh 4,000", R.drawable.chinos, "4.6", "Classic chinos for a polished look.", "Trousers"));
        } else if ("Jeans".equalsIgnoreCase(category)) {
            products.add(new Product("j1", "Bootcut Jeans", "KSh 4,000", R.drawable.bootcut_jeans, "4.5", "Stylish bootcut jeans for a retro vibe.", "Jeans"));
            products.add(new Product("j2", "Cargo Jeans", "KSh 4,500", R.drawable.cargo_jeans, "4.6", "Tough cargo jeans for extra utility.", "Jeans"));
        } else if ("Shoes".equalsIgnoreCase(category)) {
            products.add(new Product("sh3", "School Shoes", "KSh 3,500", R.drawable.shoes_school, "4.4", "Durable leather shoes for school.", "Shoes"));
            products.add(new Product("sh8", "Baby Shoes", "KSh 1,800", R.drawable.shoes_baby, "4.5", "Soft and safe shoes for little feet.", "Shoes"));
            products.add(new Product("sh15", "Pumps", "KSh 5,000", R.drawable.shoes_pumps, "4.7", "Elegant high-heeled pumps.", "Shoes"));
            products.add(new Product("sh16", "Canvas Shoes", "KSh 3,500", R.drawable.shoes_canvas, "4.5", "Casual and lightweight canvas sneakers.", "Shoes"));
            products.add(new Product("sh17", "Football Boots", "KSh 7,500", R.drawable.shoes_football_boots, "4.8", "Professional performance football boots.", "Shoes"));
            products.add(new Product("sh18", "Slippers", "KSh 1,200", R.drawable.shoes_slippers, "4.2", "Comfortable home slippers.", "Shoes"));
            products.add(new Product("sh19", "Derby Shoes", "KSh 7,000", R.drawable.shoes_derby, "4.8", "Classic leather derby shoes.", "Shoes"));
            products.add(new Product("sh20", "Mary Jane Shoes", "KSh 4,000", R.drawable.shoes_mary_jane, "4.6", "Timeless Mary Jane style.", "Shoes"));
            products.add(new Product("sh21", "Combat Boots", "KSh 8,500", R.drawable.shoes_combat_boots, "4.9", "Rugged and durable combat boots.", "Shoes"));
            products.add(new Product("sh22", "Flip-Flops", "KSh 1,000", R.drawable.shoes_flip_flops, "4.0", "Easy summer flip-flops.", "Shoes"));
            products.add(new Product("sh23", "Work Boots", "KSh 10,500", R.drawable.shoes_work_boots, "4.9", "Heavy duty industrial work boots.", "Shoes"));
            products.add(new Product("sh24", "Wedges", "KSh 5,000", R.drawable.shoes_wedges, "4.6", "Stylish and stable wedge heels.", "Shoes"));
            products.add(new Product("sh25", "Casual Shoes", "KSh 4,000", R.drawable.shoes_casual, "4.6", "Versatile casual sneakers.", "Shoes"));
            products.add(new Product("sh26", "Golf Shoes", "KSh 8,500", R.drawable.shoes_golf, "4.7", "Professional spiked golf shoes.", "Shoes"));
            products.add(new Product("sh27", "Clogs", "KSh 3,500", R.drawable.shoes_clogs, "4.3", "Comfortable slip-on clogs.", "Shoes"));
        } else if ("Accessories".equalsIgnoreCase(category)) {
            products.add(new Product("a1", "Chain Necklace", "KSh 1,200", R.drawable.chain_necklace, "4.5", "Stylish gold-toned chain necklace.", "Accessories"));
            products.add(new Product("a8", "Leather Belt", "KSh 1,800", R.drawable.leather_belt, "4.6", "Genuine leather belt with a classic buckle.", "Accessories"));
        } else if ("Croptop".equalsIgnoreCase(category)) {
            products.add(new Product("ct1", "Basic Crop Top", "KSh 1,200", R.drawable.basic_crop_top, "4.5", "Simple cotton crop top.", "Croptop"));
        } else if ("Tops".equalsIgnoreCase(category)) {
            products.add(new Product("tp1", "Peplum Top", "KSh 1,800", R.drawable.peplum_top, "4.5", "Flattering peplum waist design.", "Tops"));
            products.add(new Product("tp2", "Wrap Top", "KSh 2,200", R.drawable.wrap_top, "4.6", "Chic adjustable wrap top.", "Tops"));
            products.add(new Product("tp3", "Off-Shoulder Top", "KSh 2,500", R.drawable.off_shoulder_top_alt, "4.7", "Elegant off-the-shoulder neckline.", "Tops"));
            products.add(new Product("tp4", "One-Shoulder Top", "KSh 2,500", R.drawable.one_shoulder_top, "4.6", "Modern one-shoulder silhouette.", "Tops"));
            products.add(new Product("tp5", "Halter Neck Top", "KSh 1,800", R.drawable.halter_neck_top, "4.5", "Stylish summer halter neck.", "Tops"));
            products.add(new Product("tp6", "Tube Top", "KSh 1,400", R.drawable.tube_top, "4.3", "Classic strapless tube top.", "Tops"));
            products.add(new Product("tp7", "Corset Top", "KSh 3,500", R.drawable.corset_top, "4.8", "Trendy corset-style bodice.", "Tops"));
            products.add(new Product("tp8", "Bustier Top", "KSh 3,200", R.drawable.bustier_top, "4.7", "Supportive and stylish bustier.", "Tops"));
            products.add(new Product("tp9", "Smocked Top", "KSh 2,500", R.drawable.smocked_top, "4.5", "Comfortable stretchy smocked body.", "Tops"));
            products.add(new Product("tp10", "Ruched Top", "KSh 2,500", R.drawable.ruched_top, "4.6", "Fashionable ruched detailing.", "Tops"));
            products.add(new Product("tp11", "Babydoll Top", "KSh 3,000", R.drawable.babydoll_top, "4.5", "Flowy babydoll silhouette.", "Tops"));
            products.add(new Product("tp12", "Cape Top", "KSh 4,000", R.drawable.cape_top, "4.7", "Elegant dramatic cape sleeves.", "Tops"));
        } else {
            products.add(new Product("1", category + " Item 1", "KSh 49.99", R.drawable.ic_categories, "4.0", "Product description coming soon.", category));
        }

        ProductAdapter adapter = new ProductAdapter(products);
        recyclerView.setAdapter(adapter);
    }
}
