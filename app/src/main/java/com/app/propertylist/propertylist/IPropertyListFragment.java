package com.app.propertylist.propertylist;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;

public interface IPropertyListFragment {
    Context getContext();
    CoordinatorLayout getContentMain();
    void OnListItemClick(Bundle data);
}
