package com.app.propertylist.binding;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.app.propertylist.R;
import com.squareup.picasso.Picasso;

public class ImageViewBinding {

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView, Object imageUrl) {
        Picasso.with(imageView.getContext()).load((String) imageUrl).placeholder(R.drawable.no_image).into(imageView);
    }
}
