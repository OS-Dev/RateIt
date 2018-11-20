package csc472.depaul.edu.rateit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


public class ProductActivity extends AppCompatActivity {

    private Product product;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        //Profile Button
        Button profileButton = findViewById(R.id.profile_button);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent());
            }
        });
            //Get Intent from Home of Profile
            Intent intent = getIntent();
            //Create product from parcel
            product = intent.getParcelableExtra("NEW_PRODUCT_INTENT");
            //Gather data for display
            String productName = product.getProductName();
            int imgSrc = product.getImgSrc();
            String productDescription = product.getProductDescription();
            Integer avgRating = product.getAvgRating();
            //Display product name
            final TextView productTextView = findViewById(R.id.product_name);
            productTextView.setText(productName);
            //Display product image
            final ImageView imgView = findViewById(R.id.product_img);
            imgView.setImageDrawable(getDrawable(imgSrc));
            //Display product description
            final TextView productDescView = findViewById(R.id.product_description);
            productDescView.setText(productDescription);
            //Display rating
            final RatingBar ratingView = findViewById(R.id.ratingBar);
            ratingView.setNumStars(avgRating);

    }
}
