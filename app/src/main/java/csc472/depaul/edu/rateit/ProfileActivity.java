package csc472.depaul.edu.rateit;


import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.net.Uri;

<<<<<<< HEAD
=======
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }
>>>>>>> 22b126ffcc161eadf9db21e096bc252c058367ac

import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity
        implements ProfileFragment.OnFragmentInteractionListener,
                    FavoritesFragment.OnFragmentInteractionListener,
                    RatedFragment.OnFragmentInteractionListener {

    @Override
    public void onFragmentInteraction(Uri uri){}

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
<<<<<<< HEAD
            View rootView = inflater.inflate(R.layout.fragment_profile2, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
=======
            View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
            TextView textView = rootView.findViewById(R.id.section_label);
>>>>>>> 22b126ffcc161eadf9db21e096bc252c058367ac
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    private final String LOG_TAG = ProfileActivity.class.getSimpleName();

    // Titles of the individual pages (displayed in tabs)
    private final String[] PAGE_TITLES = new String[] {
            "Profile",
            "Rated Items",
            "Favorites"
    };

    // The fragments that are used as the individual pages
    private final Fragment[] PAGES = new Fragment[] {
            new ProfileFragment(),
            new RatedFragment(),
            new FavoritesFragment()
    };

    // The ViewPager is responsible for sliding pages (fragments) in and out upon user input
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Set the Toolbar as the activity's app bar (instead of the default ActionBar)
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Connect the ViewPager to our custom PagerAdapter. The PagerAdapter supplies the pages
        // (fragments) to the ViewPager, which the ViewPager needs to display.
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        // Connect the tabs with the ViewPager (the setupWithViewPager method does this for us in
        // both directions, i.e. when a new tab is selected, the ViewPager switches to this page,
        // and when the ViewPager switches to a new page, the corresponding tab is selected)
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(mViewPager);
    }


/* PagerAdapter for supplying the ViewPager with the pages (fragments) to display. */
public class MyPagerAdapter extends FragmentPagerAdapter {

    public MyPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        return PAGES[position];
    }

    @Override
    public int getCount() {
        return PAGES.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return PAGE_TITLES[position];
    }

}

}
