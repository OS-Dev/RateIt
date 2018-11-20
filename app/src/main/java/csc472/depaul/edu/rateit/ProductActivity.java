package csc472.depaul.edu.rateit;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.DrawableRes;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;


public class ProductActivity extends AppCompatActivity{

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
        //Add Favorite Button
        Button favButton = findViewById(R.id.favorite_button);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//
               //profile.addFavorite(product);
            }
        });

            //Get Intent from Home or Profile
            Intent intent = getIntent();

            //Create product from parcel
            product = intent.getParcelableExtra("NEW_PRODUCT_INTENT");

            //Display product name
            TextView productTextView = findViewById(R.id.product_name);
            productTextView.setText(product.getProductName());

            //Display product image
            try {
                requestReadExternalStoragePermission();

                File sdCard = Environment.getExternalStorageDirectory();
                File dir = new File(sdCard.getAbsolutePath() + "/products/images");
                File imgFile = new File(dir, product.getImgSrc());

                ImageView imgView = findViewById(R.id.product_img);
                Bitmap bitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                imgView.setImageBitmap(bitmap);

            //Display product description
            TextView productDescView = findViewById(R.id.product_description);
            productDescView.setText(product.getProductDescription());

            //Display rating
            final RatingBar ratingView = findViewById(R.id.ratingBar);
            ratingView.setNumStars(5);
            ratingView.setRating(product.getAvgRating());
            ratingView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   //Change File, add Rating to rated,
                   //profile.rate(product, rating);
                    }
            });
            } catch (Exception e) {
                Toast toast = Toast.makeText(getUserActivity(), e.getMessage(), Toast.LENGTH_LONG);
                toast.show();
            }

    }

    private ProductActivity getUserActivity() {
        return this;
    }

    private void requestReadExternalStoragePermission()
    {
        int readPermission = ActivityCompat.checkSelfPermission(getUserActivity(), Manifest.permission.READ_EXTERNAL_STORAGE);

        if (readPermission != PackageManager.PERMISSION_GRANTED)
        {
            int REQUEST_EXTERNAL_STORAGE = 1;

            String[] PERMISSIONS_STORAGE = {
                    Manifest.permission.READ_EXTERNAL_STORAGE,
            };

            ActivityCompat.requestPermissions(
                    getUserActivity(),
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }
}
