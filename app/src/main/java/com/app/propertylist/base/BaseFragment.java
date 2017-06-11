package com.app.propertylist.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.app.propertylist.MainActivity;
import com.app.propertylist.interfaces.FragmentHelper;
import com.app.propertylist.network.PropertyService;
import com.app.propertylist.network.RequestManager;

public abstract class BaseFragment extends Fragment implements Lifecycle.View {

    protected FragmentHelper fragmentHelper;

    protected abstract Lifecycle.ViewModel getViewModel();

    protected PropertyService requestManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestManager = new RequestManager();

        if(getViewModel() != null) {
            getViewModel().onViewAttached(this);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        fragmentHelper = (MainActivity) context;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(getViewModel() != null) {
            getViewModel().onViewDetached();
        }
    }
}
