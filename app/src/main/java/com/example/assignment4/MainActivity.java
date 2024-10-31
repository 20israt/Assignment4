package com.example.assignment4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView listViewProducts;

    private String[] productNames = {"P1", "P2", "P3", "P4", "P5"};
    private double[] productPrices = {250, 300, 200, 150, 180};
    private int[] productQuantities = {0, 0, 0, 0, 0};


    private int[] productImages = {R.drawable.pastry, R.drawable.img_1, R.drawable.img, R.drawable.img_2, R.drawable.img_3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewProducts = findViewById(R.id.list_view_products);

        listViewProducts.setAdapter(new ProductAdapter());

    }

    private class ProductAdapter extends android.widget.BaseAdapter {

        @Override
        public int getCount() {
            return productNames.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.list_view, parent, false);
            }


            ImageView imageViewProduct = convertView.findViewById(R.id.image_view_product);
            TextView textViewProductName = convertView.findViewById(R.id.text_view_product_name);
            TextView textViewProductPrice = convertView.findViewById(R.id.text_view_product_price);
            TextView textViewTotalPrice = convertView.findViewById(R.id.text_view_product_total); // For total price


            imageViewProduct.setImageResource(productImages[position]);
            textViewProductName.setText(productNames[position]);
            textViewProductPrice.setText(String.format("$%.2f", productPrices[position]));


            double totalPrice = productQuantities[position] * productPrices[position];
            textViewTotalPrice.setText(String.format("Total: $%.2f", totalPrice));


            return convertView;
        }
}
}