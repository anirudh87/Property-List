package com.app.propertylist.propertylist;

import com.app.propertylist.base.Lifecycle;
import com.app.propertylist.datamodels.PropertyData;
import com.app.propertylist.datamodels.SearchRequest;

import java.util.List;

public interface PropertyListContract {

    interface View extends Lifecycle.View {
        void onSuccess(List<PropertyData> propertyList);
        void onFailure(Throwable e);
        void onComplete();
        void showLoading();
        void hideLoading();
    }

    interface ViewModel extends Lifecycle.ViewModel {

        void loadProperties(SearchRequest request);
    }
}
