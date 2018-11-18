package csc472.depaul.edu.rateit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private ArrayList<Product> productArrayList;
    private String NEW_PRODUCT_INTENT = "NEW_PRODUCT_INTENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //TODO: open file from SD card and add product elements to productArrayList
        //TODO: read each element and use it to create a product
        mTextMessage = (TextView) findViewById(R.id.message);
    }

    private final HomeActivity getNewUserActivity()
    {
        return this;
    }

    //TODO: set up recycler view with buttons which pass intent to ProductActivity with a bundle containing the relevant Product
    private View.OnClickListener onProductClick = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            Product investment = new Product("productName", "imgSrc", "productDescription", 1, 5);

            Bundle extras = new Bundle();
            extras.putParcelable(NEW_PRODUCT_INTENT, investment);

            Intent productIntent = new Intent(getNewUserActivity(), ProductActivity.class);
            productIntent.putExtras(extras);
            startActivity(productIntent);
        }
    };
}
