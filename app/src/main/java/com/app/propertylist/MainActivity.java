package com.app.propertylist;

import android.databinding.DataBindingUtil;
import android.os.PersistableBundle;
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
import com.app.propertylist.util.Constants;

public class MainActivity extends AppCompatActivity implements FragmentHelper {

    ActivityMainBinding binding;
    private boolean isFragmentAdded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.toolbar.setTitle(getString(R.string.app_name));

        //Check if device is Phone/Tablet
        if (savedInstanceState == null) {
            if (!getResources().getBoolean(R.bool.has_two_panes)) {
                PropertyListFragment propertyListFragment = PropertyListFragment.newInstance();

                // Load first fragment into Activity
                loadFragment(R.id.main_container, propertyListFragment, PropertyListFragment.class.getSimpleName());
                isFragmentAdded = true;

            } else {
                PropertyListFragment propertyListFragment = PropertyListFragment.newInstance();
                PropertyDetailsFragment propertyDetailsFragment = PropertyDetailsFragment.newInstance(null);

                // Load both fragments into Activity in tablets
                loadFragment(R.id.property_list_fragment, propertyListFragment, PropertyListFragment.class.getSimpleName());
                loadFragment(R.id.property_details_fragment, propertyDetailsFragment, PropertyDetailsFragment.class.getSimpleName());
            }
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
        //Load details screen
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
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        outState.putBoolean(Constants.IS_FRAGMENT_ADDED, isFragmentAdded);
        super.onSaveInstanceState(outState, outPersistentState);
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
