package com.app.propertylist.propertylist;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.propertylist.BR;
import com.app.propertylist.R;
import com.app.propertylist.datamodels.PropertyData;
import com.app.propertylist.interfaces.OnItemClickListener;
import com.app.propertylist.util.Constants;

import java.util.ArrayList;
import java.util.List;

public class PropertyListAdapter extends RecyclerView.Adapter<PropertyListAdapter.CustomViewHolder> {
    private List<PropertyData> propertyDataList;
    private Context context;
    private OnItemClickListener callback;

    public PropertyListAdapter(Context context, OnItemClickListener callback) {
        this.context = context;
        this.callback = callback;

        propertyDataList = new ArrayList<>();
    }

    @Override
    public int getItemViewType(int position) {
        return propertyDataList.get(position).getIsElite();
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int isElite) {

        int layoutId = R.layout.list_item_layout_simple;
        if(isElite == 1) {
            layoutId = R.layout.list_item_layout_elite;
        }

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(layoutId, viewGroup, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClick(view);
            }
        });
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    private void handleClick(View v) {
        Bundle data = new Bundle();
        data.putParcelable(Constants.PROPERTY, (PropertyData) v.getTag());
        callback.OnClick(data);
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder customViewHolder, int position) {
        final PropertyData propertyData = propertyDataList.get(position);

        customViewHolder.getBinding().setVariable(BR.property, propertyData);
        customViewHolder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return propertyDataList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        public CustomViewHolder(View view) {
            super(view);
            binding = DataBindingUtil.bind(view);
        }

        public ViewDataBinding getBinding() {
            return binding;
        }
    }

    public void addAll(List<PropertyData> list) {
        propertyDataList.clear();
        propertyDataList.addAll(list);
        notifyDataSetChanged();
    }

}