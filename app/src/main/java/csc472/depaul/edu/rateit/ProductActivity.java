package csc472.depaul.edu.rateit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {

    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

            //Get Intent from Home of Profile
            Intent intent = getIntent();
            //Create product from parcel
            product = intent.getParcelableExtra("product");
            //Gather data for display
            String productName = product.getProductName();
            String imgSrc = product.getImgSrc();
            String productDescription = product.getProductDescription();
            Integer avgRating = product.getAvgRating();
            //Display product name
            final TextView productTextView = findViewById(R.id.product_name);
            productTextView.setText(productName);
            //Display product image
            final ImageView imgView = findViewById(R.id.product_img);
            imgView.setImageURI(Uri.parse(imgSrc));
            //Display product description
            final TextView productDescView = findViewById(R.id.product_description);
            productDescView.setText(productDescription);
            //Display rating
            final RatingBar ratingView = findViewById(R.id.ratingBar);
            ratingView.setNumStars(avgRating);

    }
}
