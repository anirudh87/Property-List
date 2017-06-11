package com.app.propertylist.network;

import com.app.propertylist.datamodels.PropertyListResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PropertyService {

    @GET("mapsearch")
    Observable<PropertyListResponse> getPropertyList(@Query("mode") String mode, @Query("sub") String sub, @Query("pcodes") String pcodes, @Query("state") String state);

    @GET("test")
    Observable<PropertyListResponse> getProperty();

}

