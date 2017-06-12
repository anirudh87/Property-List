package com.app.propertylist;

import android.databinding.DataBindingUtil;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.app.propertylist.databinding.ActivityMainBinding;
import com.app.propertylist.interfaces.FragmentHelper;
import com.app.propertylist.propertydetails.PropertyDetailsFragment;
import com.app.propertylist.propertylist.PropertyListFragment;

public class MainActivity extends AppCompatActivity implements FragmentHelper {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.toolbar.setTitle(getString(R.string.app_name));

        //Check if device is Portrait/Landscape/Tablet
        if (!getResources().getBoolean(R.bool.has_two_panes)) {
            PropertyListFragment propertyListFragment = PropertyListFragment.newInstance();

            // Load first fragment into Activity
            loadFragment(R.id.main_container, propertyListFragment, PropertyListFragment.class.getSimpleName());
        }
        else {
            PropertyListFragment propertyListFragment = PropertyListFragment.newInstance();
            PropertyDetailsFragment propertyDetailsFragment = PropertyDetailsFragment.newInstance(null);

            // Load both fragments into Activity
            loadFragment(R.id.property_list_fragment, propertyListFragment, PropertyListFragment.class.getSimpleName());
            loadFragment(R.id.property_details_fragment, propertyDetailsFragment, PropertyDetailsFragment.class.getSimpleName());
        }
    }

    private void loadFragment(int container, Fragment fragment, String fragmentTag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(container, fragment, fragmentTag).addToBackStack(fragmentTag).commit();
    }

    @Override
    public CoordinatorLayout getContentMain() {
        return binding.outerLayout;
    }

    @Override
    public void showDetails(Bundle bundle) {
        if (getResources().getBoolean(R.bool.has_two_panes)) {
            PropertyDetailsFragment propertyDetailsFragment = (PropertyDetailsFragment) getSupportFragmentManager().findFragmentByTag(PropertyDetailsFragment.class.getSimpleName());
            propertyDetailsFragment.setPropertyData(bundle);
        } else {
            PropertyDetailsFragment propertyDetails = PropertyDetailsFragment.newInstance(bundle);
            loadFragment(R.id.main_container, propertyDetails, PropertyDetailsFragment.class.getSimpleName());
        }
    }

    @Override
    public void hideDetailsView() {
        binding.propertyDetailsFragment.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.executePendingTransactions();

        int count = fragmentManager.getBackStackEntryCount();
        if (count > 1) {
            fragmentManager.popBackStack();
        } else {
            finish();
        }
    }
}
