package com.app.propertylist.interfaces;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;

public interface FragmentHelper {
    CoordinatorLayout getContentMain();
    void showDetails(Bundle bundle);
    void hideDetailsView();
}
