package csc472.depaul.edu.rateit;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View RootView = inflater.inflate(R.layout.fragment_profile2, container, false);
        TextView textView = RootView.findViewById(R.id.total_num);
        String total_ratings = Integer.toString(ProfileActivity.profile.getRated().size());
        textView.setText(total_ratings);

        TextView textView2 = RootView.findViewById(R.id.favorite_num);
        String total_favorites = Integer.toString(ProfileActivity.profile.getFavorites().size());
        textView2.setText(total_favorites);

        return RootView;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
