package ProductAdapter;

import static android.view.View.inflate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.assignment4.MainActivity;
import com.example.assignment4.R;

public class ProductAdapter extends BaseAdapter {
    Context context;
    String[] productNames;
    double[] productPrices;
    int[] productQuantities;
    double[] totalPrice;
    Integer[] img;

    public ProductAdapter(@NonNull Context context, String[] productNames, double[] productPrices, int[] productQuantities, double[] totalPrice, Integer[] img) {
        this.context = context;
        this.productNames = productNames;
        this.productPrices = productPrices;
        this.productQuantities = productQuantities;
        this.totalPrice = totalPrice;
        this.img = img;

    }

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
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.list_view, parent, false);
        }


        ImageView imageViewProduct = convertView.findViewById(R.id.image_view_product);
        TextView textViewProductName = convertView.findViewById(R.id.text_view_product_name);
        TextView textViewProductPrice = convertView.findViewById(R.id.text_view_product_price);
        TextView textViewTotalPrice = convertView.findViewById(R.id.text_view_product_total); // For total price


        imageViewProduct.setImageResource(img[position]);
        textViewProductName.setText(productNames[position]);
        textViewProductPrice.setText(String.format("$%.2f", productPrices[position]));


        double totalPrice = productQuantities[position] * productPrices[position];
        textViewTotalPrice.setText(String.format("Total: $%.2f", totalPrice));


        return convertView;
    }
}
