package com.app.propertylist.binding;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.app.propertylist.R;
import com.squareup.picasso.Picasso;

public class ImageViewBinding {

    @BindingAdapter("imageUrl")
    public static void getImageUrl(ImageView imageView, String imageUrl) {
        Picasso.with(imageView.getContext()).load(imageUrl).placeholder(R.drawable.no_image).into(imageView);
    }
}
