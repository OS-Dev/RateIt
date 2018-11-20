package csc472.depaul.edu.rateit;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


public class ProductActivity extends AppCompatActivity{

    //private Product product = new Product("Malort", -800003,"Best drink there is!", 1, 5);
    private Product product;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        //Profile Button
        Button profileButton = findViewById(R.id.profile_button);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getUserActivity(), ProfileActivity.class));
            }
        });
            //Get Intent from Home of Profile
            Intent intent = getIntent();
            //Create product from parcel
            product = intent.getParcelableExtra("NEW_PRODUCT_INTENT");
            //Display product name
            TextView productTextView = findViewById(R.id.product_name);
            productTextView.setText(product.getProductName());
            //Display product image
            ImageView imgView = findViewById(R.id.product_img);
            imgView.setImageDrawable(getDrawable(product.getImgSrc()));
            //Display product description
            TextView productDescView = findViewById(R.id.product_description);
            productDescView.setText(product.getProductDescription());
            //Display rating
            RatingBar ratingView = findViewById(R.id.ratingBar);
            ratingView.setNumStars(product.getAvgRating());

    }

    private ProductActivity getUserActivity() {
        return this;
    }
}
