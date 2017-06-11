package com.app.propertylist.base;

import android.support.annotation.NonNull;

public interface Lifecycle {

    interface View {

    }

    interface ViewModel {
        void onViewAttached(@NonNull Lifecycle.View viewCallback);
        void onViewDetached();
    }
}
