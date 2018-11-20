package csc472.depaul.edu.rateit;

import android.content.Context;
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
        setOrientation(LinearLayout.VERTICAL);

        TextView title = new TextView(context);
        title.setText(_product.getProductName());
        title.setWidth(100);
        title.setHeight(500);
        addView(title);

        TextView rating = new TextView(context);
        rating.setText(_product.getAvgRating());
        rating.setWidth(100);
        rating.setHeight(500);
        addView(title);
    }
}

