package com.app.propertylist.propertylist;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.NonNull;

import com.app.propertylist.base.Lifecycle;
import com.app.propertylist.datamodels.PropertyData;
import com.app.propertylist.datamodels.PropertyListResponse;
import com.app.propertylist.datamodels.SearchRequest;
import com.app.propertylist.network.PropertyService;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class PropertyListViewModel extends BaseObservable implements PropertyListContract.ViewModel {

    private PropertyListContract.View viewCallback;
    private List<PropertyData> propertyList;

    private PropertyService propertyService;
    private PropertyListObserver disposableObserver;

    public PropertyListViewModel(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @Bindable
    public List<PropertyData> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<PropertyData> propertyList) {
        this.propertyList = propertyList;
        notifyChange();
    }

    @Override
    public void loadProperties(final PropertyListContract.View view, SearchRequest request) {
        disposableObserver = new PropertyListObserver(view);
        view.showLoading();
        propertyService.getPropertyList(request.getMode(), request.getSub(), request.getPcodes(), request.getState()).observeOn(AndroidSchedulers.mainThread()).
                subscribeOn(Schedulers.io()).subscribe(disposableObserver);
    }

    @Override
    public void onViewAttached(@NonNull Lifecycle.View viewCallback) {
        this.viewCallback = (PropertyListContract.View) viewCallback;
    }

    @Override
    public void onViewDetached() {
        viewCallback = null;
        disposableObserver.dispose();
    }

    public class PropertyListObserver extends DisposableObserver<PropertyListResponse> {
        PropertyListContract.View viewCallback;

        public PropertyListObserver(PropertyListContract.View viewCallback) {
            this.viewCallback = viewCallback;
        }

        @Override
        public void onError(Throwable e) {
            viewCallback.hideLoading();
            viewCallback.onFailure(e);
        }

        @Override
        public void onComplete() {
            viewCallback.onComplete();
        }

        @Override
        public void onNext(PropertyListResponse propertyListResponse) {
            viewCallback.hideLoading();
            List<PropertyData> propertyDataList = propertyListResponse.getListingResults().getListings();
            setPropertyList(propertyDataList);
            viewCallback.onSuccess(propertyDataList);
        }
    }
}
