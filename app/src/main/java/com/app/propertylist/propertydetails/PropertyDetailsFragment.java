package com.app.propertylist.propertydetails;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.propertylist.R;
import com.app.propertylist.base.BaseFragment;
import com.app.propertylist.base.Lifecycle;
import com.app.propertylist.databinding.FragmentPropertydetailsBinding;
import com.app.propertylist.datamodels.PropertyData;
import com.app.propertylist.util.Constants;

public class PropertyDetailsFragment extends BaseFragment {

    private FragmentPropertydetailsBinding binding;
    private PropertyData property;

    public static PropertyDetailsFragment newInstance(Bundle property) {
        PropertyDetailsFragment fragment = new PropertyDetailsFragment();
        fragment.setArguments(property);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        Bundle bundle = getArguments();
        if (bundle != null) {
            property = bundle.getParcelable(Constants.PROPERTY);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_propertydetails, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setProperty(property);
    }

    @Override
    protected Lifecycle.ViewModel getViewModel() {
        return null;
    }

    public void setPropertyData(Bundle bundle) {
        if (bundle != null) {
            property = bundle.getParcelable(Constants.PROPERTY);
            binding.setProperty(property);
        }
    }
}
