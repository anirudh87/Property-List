package com.app.propertylist.datamodels;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class PoiMarkerResults implements Serializable {

    @SerializedName("PoiMarkers")
    private List<PoiMarker> poiMarkers;

    @SerializedName("ResultsReturned")
    private int resultsReturned;

    @SerializedName("ResultsTotal")
    private int resultsTotal;

    public List<PoiMarker> getPoiMarkers() {
        return poiMarkers;
    }

    public void setPoiMarkers(List<PoiMarker> poiMarkers) {
        this.poiMarkers = poiMarkers;
    }

    public int getResultsReturned() {
        return resultsReturned;
    }

    public void setResultsReturned(int resultsReturned) {
        this.resultsReturned = resultsReturned;
    }

    public int getResultsTotal() {
        return resultsTotal;
    }

    public void setResultsTotal(int resultsTotal) {
        this.resultsTotal = resultsTotal;
    }
}
