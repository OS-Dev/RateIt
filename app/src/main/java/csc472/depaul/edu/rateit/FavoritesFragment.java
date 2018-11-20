package csc472.depaul.edu.rateit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;


public class FavoritesFragment extends Fragment {

    List<Product> favoriteList = new ArrayList<>();

    private void loadRated() {
        ArrayList<Product> inventory = HomeActivity.getProductArrayList();
        for (int i=0; i<inventory.size(); i++) {
            if (inventory.get(i).getAvgRating() == 5) favoriteList.add(inventory.get(i));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        loadRated();
        View RootView = inflater.inflate(R.layout.fragment_favorites, container, false);

        ViewGroup parent = RootView.findViewById(R.id.favoriteProductLinear);
        ProductLinearLayout pll;

        for (Product product : favoriteList) {
            pll = new ProductLinearLayout(getActivity(), product);
            pll.setOnClickListener(onProductClick);
            parent.addView(pll);
        }

        return RootView;
    }

    private View.OnClickListener onProductClick = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            ProductLinearLayout pll = (ProductLinearLayout) v;
            Product product = pll.getProduct();

            Bundle extras = new Bundle();
            extras.putParcelable("NEW_PRODUCT_INTENT", product);

            Intent productIntent = new Intent(getActivity(), ProductActivity.class);
            productIntent.putExtras(extras);
            startActivity(productIntent);

        }
    };

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
