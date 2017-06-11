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
import com.app.propertylist.propertylist.PropertyListFragment;

public class MainActivity extends AppCompatActivity implements FragmentHelper {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        PropertyListFragment propertyListFragment = PropertyListFragment.newInstance();

        // Load first fragment into Activity
        loadFragment(R.id.main_container, propertyListFragment, PropertyListFragment.class.getSimpleName());
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
