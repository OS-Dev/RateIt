package csc472.depaul.edu.rateit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private ArrayList<Product> productArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //TODO open file from SD card and add product elements to productArrayList
        mTextMessage = (TextView) findViewById(R.id.message);
    }

    //TODO set up recycler view with buttons which pass intent to ProductActivity with a bundle containing the relevant Product

}
