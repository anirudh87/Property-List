package com.app.propertylist.datamodels;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class GeographicWindow implements Serializable {

    @SerializedName("MaximumLatLng")
    private Location maxLatLong;

    @SerializedName("MinimumLatLng")
    private Location minLatLong;

    public Location getMaxLatLong() {
        return maxLatLong;
    }

    public void setMaxLatLong(Location maxLatLong) {
        this.maxLatLong = maxLatLong;
    }

    public Location getMinLatLong() {
        return minLatLong;
    }

    public void setMinLatLong(Location minLatLong) {
        this.minLatLong = minLatLong;
    }
}
