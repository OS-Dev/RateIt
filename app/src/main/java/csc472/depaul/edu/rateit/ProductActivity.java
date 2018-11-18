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

    private TextView mTextMessage;
    private Product product;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        ListView content = (ListView) findViewById(R.id.product_layout);

        if (savedInstanceState==null) {
            Intent intent = getIntent();
            Product product = (Product) intent.getParcelableExtra("product");
            String productName = product.getProductName();
            String imgSrc = product.getImgSrc();
            String productDescription = product.getProductDescription();
            Integer timesRated = product.getTimesRated();
            Integer totalRating = product.getTotalRating();
            //Don't think this is needed
            Integer avgRating = product.getAvgRating();
            final TextView productTextView = (TextView) findViewById(R.id.product_name);
            productTextView.setText(productName);
            final ImageView imgView = (ImageView) findViewById(R.id.product_img);
            imgView.setImageURI(Uri.parse(imgSrc));
            final TextView productDescView = (TextView) findViewById(R.id.product_description);
            productDescView.setText(productDescription);
            final RatingBar ratingView = (RatingBar) findViewById(R.id.ratingBar);
            ratingView.setNumStars(avgRating);
        }
        else{
            product = savedInstanceState.getParcelable("product");
        }
        content.setAdapter((ListAdapter) product);

    }
}
