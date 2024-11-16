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

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ProductAdapter.ProductAdapter;

public class MainActivity extends AppCompatActivity {

    private ListView listViewProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewProducts = findViewById(R.id.list_view_products);

        String[] productNames = {"Pastry", "Croissant", "Chocolate Shake", "Cold Coffee", "Strawberry Ice Cream"};
        double[] productPrices = {250, 300, 200, 150, 180};
        int[] productQuantities = {1, 1, 2, 3, 2};
        double[] totalPrice= {};
        Integer[] img = {R.drawable.pastry, R.drawable.img_1, R.drawable.img, R.drawable.img_2, R.drawable.img_3};

        ProductAdapter adapter = new ProductAdapter(this, productNames, productPrices, productQuantities, totalPrice, img);
        listViewProducts.setAdapter(adapter);

    }
}
