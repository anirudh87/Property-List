package com.app.propertylist.network;

import com.app.propertylist.datamodels.PropertyListResponse;

import io.reactivex.Observable;
import retrofit2.Retrofit;

public class RequestManager implements PropertyService{

    Retrofit retrofit;
    PropertyService propertyService;

    public RequestManager(){
        retrofit = RetrofitFactory.getRetrofit();
        propertyService = retrofit.create(PropertyService.class);
    }

    @Override
    public Observable<PropertyListResponse> getPropertyList(String mode, String sub, String pcodes, String state) {
        PropertyService propertyService = retrofit.create(PropertyService.class);
        return propertyService.getPropertyList(mode, sub, pcodes, state);
    }

    @Override
    public Observable<PropertyListResponse> getProperty() {
        return null;
    }
}
