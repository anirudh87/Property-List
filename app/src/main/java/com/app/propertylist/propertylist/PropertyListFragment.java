package com.app.propertylist.propertylist;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.propertylist.R;
import com.app.propertylist.base.BaseFragment;
import com.app.propertylist.base.Lifecycle;
import com.app.propertylist.databinding.FragmentPropertylistBinding;
import com.app.propertylist.datamodels.PropertyData;
import com.app.propertylist.datamodels.SearchRequest;
import com.app.propertylist.interfaces.OnItemClickListener;
import com.app.propertylist.util.SimpleDividerItem;
import com.app.propertylist.util.Utility;

import java.util.List;

public class PropertyListFragment extends BaseFragment implements PropertyListContract.View, OnItemClickListener {

    FragmentPropertylistBinding binding;
    PropertyListContract.ViewModel propertyListViewModel;
    private PropertyListAdapter propertyListAdapter;
    private ProgressDialog progressDialog;

    public static PropertyListFragment newInstance() {
        PropertyListFragment fragment = new PropertyListFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SearchRequest request = new SearchRequest();
        request.setMode("buy");
        request.setSub("Bondi");
        request.setPcodes("2026");
        request.setState("NSW");

        propertyListViewModel.loadProperties(this, request);

        propertyListAdapter = new PropertyListAdapter(getContext(), PropertyListFragment.this);
    }

    @Override
    protected Lifecycle.ViewModel getViewModel() {
        if(Utility.isEmpty(propertyListViewModel)) {
            propertyListViewModel = new PropertyListViewModel(requestManager);
        }
        return propertyListViewModel;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_propertylist, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.propertyList.setLayoutManager(layoutManager);

        binding.propertyList.addItemDecoration(new SimpleDividerItem(getActivity()));
        binding.propertyList.setAdapter(propertyListAdapter);
    }

    @Override
    public void onSuccess(List<PropertyData> propertyList) {
        if(Utility.isNotEmpty(propertyList)) {
            propertyListAdapter.addAll(propertyList);
            binding.propertyList.setVisibility(View.VISIBLE);
            binding.noPropertyFound.setVisibility(View.GONE);
        }
        else {
            binding.propertyList.setVisibility(View.GONE);
            binding.noPropertyFound.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onFailure(Throwable e) {
        Log.e("Data", "> "+e.getMessage());
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void showLoading() {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Fetching Items..");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        if (progressDialog != null & progressDialog.isShowing()) {
            progressDialog.dismiss();
            progressDialog.cancel();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hideLoading();
        propertyListViewModel = null;
    }

    @Override
    public void OnClick(Bundle data) {
    }
}
