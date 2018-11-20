package csc472.depaul.edu.rateit;

import android.content.Context;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProductLinearLayout extends LinearLayout {

    private Product _product;

    public ProductLinearLayout(Context context, Product product)
    {
        super(context);

        _product = product;

        inflaterContextAndAddLayoutToLayout(context);
    }

    public Product getProduct() {
        return _product;
    }

    private void inflaterContextAndAddLayoutToLayout(Context context)
    {
        setGravity(Gravity.END);
        setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        TextView title = new TextView(context);
        title.setText(_product.getProductName());
        title.setTextSize(25);
        title.setWidth(800);
        title.setPadding(30,20,0,0);
        addView(title);

        TextView rating = new TextView(context);
        rating.setText(Integer.toString(_product.getAvgRating()) + " stars");
        rating.setTextSize(25);
        rating.setPadding(0,20,0,0);
        addView(rating);
    }
}

