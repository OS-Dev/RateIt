package csc472.depaul.edu.rateit;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class HomeActivity extends AppCompatActivity {

    private static ArrayList<Product> productArrayList = new ArrayList<>();
    private String NEW_PRODUCT_INTENT = "NEW_PRODUCT_INTENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button profileButton = findViewById(R.id.home_profile_button);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getUserActivity(), ProfileActivity.class));
            }
        });

        try
        {
            requestReadExternalStoragePermission();

            File sdCard = Environment.getExternalStorageDirectory();
            File dir = new File(sdCard.getAbsolutePath() + "/products");

            if( !dir.exists() )
                dir.mkdir();

            File file = new File(dir, "products.txt");
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                String s = scan.nextLine();
                String[] sArr = s.split("\\|");
                Product product = new Product(sArr[0], sArr[1], sArr[2], Integer.parseInt(sArr[3]), Integer.parseInt(sArr[4]));
                productArrayList.add(product);
            }

        } catch (Exception e) {
            Toast toast = Toast.makeText(getUserActivity(), e.getMessage(), Toast.LENGTH_LONG);
            toast.show();
        }

        populateScrollView();
    }

    private final HomeActivity getUserActivity()
    {
        return this;
    }

    public static ArrayList<Product> getProductArrayList() { return productArrayList; }

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

    private void populateScrollView() {
        ViewGroup parent = findViewById(R.id.productHomeLinear);
        ProductLinearLayout pll;

        for (Product product : productArrayList) {
            pll = new ProductLinearLayout(this, product);
            pll.setOnClickListener(onProductClick);
            parent.addView(pll);
        }
    }

    //TODO: set up recycler view with buttons which pass intent to ProductActivity with a bundle containing the relevant Product
    private View.OnClickListener onProductClick = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            ProductLinearLayout pll = (ProductLinearLayout) v;
            Product product = pll.getProduct();

            Bundle extras = new Bundle();
            extras.putParcelable(NEW_PRODUCT_INTENT, product);

            Intent productIntent = new Intent(getUserActivity(), ProductActivity.class);
            productIntent.putExtras(extras);
            startActivity(productIntent);
        }
    };
}
