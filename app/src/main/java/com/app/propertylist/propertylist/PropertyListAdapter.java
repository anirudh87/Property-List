package com.app.propertylist.propertylist;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.app.propertylist.BR;
import com.app.propertylist.R;
import com.app.propertylist.datamodels.PropertyData;
import com.app.propertylist.util.Constants;
import com.app.propertylist.util.Utility;

import java.util.ArrayList;
import java.util.List;

public class PropertyListAdapter extends RecyclerView.Adapter<PropertyListAdapter.CustomViewHolder> {
    private List<PropertyData> propertyDataList;
    private IPropertyListFragment fragmentCallback;

    public PropertyListAdapter(IPropertyListFragment propertyListFragment) {
        this.fragmentCallback = propertyListFragment;

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

    @Override
    public void onBindViewHolder(final CustomViewHolder customViewHolder, int position) {
        final PropertyData propertyData = propertyDataList.get(position);
        customViewHolder.getFavoriteIcon().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClick(view);
            }
        });

        customViewHolder.getBinding().setVariable(BR.property, propertyData);
        customViewHolder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return propertyDataList.size();
    }

    private void handleClick(View v) {

        PropertyData propertyData = (PropertyData) v.getTag();
        if(Utility.isNotEmpty(propertyData)) {
            String toastMsg;
            if (v instanceof ImageView) {
                if(propertyData.isFavorite) {
                    ((ImageView) v).setImageResource(R.drawable.favorite);
                    propertyData.setFavorite(false);
                    toastMsg = fragmentCallback.getContext().getString(R.string.msg_property_removed_from_fav);
                }
                else {
                    ((ImageView) v).setImageResource(R.drawable.favorite_dark);
                    propertyData.setFavorite(true);
                    toastMsg = fragmentCallback.getContext().getString(R.string.msg_property_added_in_fav);
                }
                if(Utility.isNotEmpty(toastMsg)) {
                    Utility.showSnackBar(fragmentCallback.getContentMain(), toastMsg);
                }
            } else {
                Bundle data = new Bundle();
                data.putParcelable(Constants.PROPERTY, propertyData);
                fragmentCallback.OnListItemClick(data);
            }
        }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;
        private ImageView favoriteIcon;

        public CustomViewHolder(View view) {
            super(view);
            binding = DataBindingUtil.bind(view);
            favoriteIcon = (ImageView) view.findViewById(R.id.favorite_icon);
        }

        public ViewDataBinding getBinding() {
            return binding;
        }

        public ImageView getFavoriteIcon() {
            return favoriteIcon;
        }
    }

    public void addAll(List<PropertyData> list) {
        propertyDataList.clear();
        propertyDataList.addAll(list);
        notifyDataSetChanged();
    }
}