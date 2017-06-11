package com.app.propertylist.datamodels;

import com.google.gson.annotations.SerializedName;

public class PropertyListResponse {

    @SerializedName("Ads")
    public Object ads;

    @SerializedName("ClusterResults")
    public Object clusterResults;

    @SerializedName("GeographicWindow")
    public GeographicWindow geographicWindow;

    @SerializedName("ListingResults")
    public ListingResults listingResults;

    @SerializedName("NavigatorResults")
    public NavigatorResults navigatorResults;

    @SerializedName("PoiMarkerResults")
    public PoiMarkerResults poiMarkerResults;

    public PropertyListResponse(Object ads, Object clusterResults, GeographicWindow geographicWindow, ListingResults listingResults, NavigatorResults navigatorResults, PoiMarkerResults poiMarkerResults) {
        this.ads = ads;
        this.clusterResults = clusterResults;
        this.geographicWindow = geographicWindow;
        this.listingResults = listingResults;
        this.navigatorResults = navigatorResults;
        this.poiMarkerResults = poiMarkerResults;
    }

    public Object getAds() {
        return ads;
    }

    public void setAds(Object ads) {
        this.ads = ads;
    }

    public Object getClusterResults() {
        return clusterResults;
    }

    public void setClusterResults(Object clusterResults) {
        this.clusterResults = clusterResults;
    }

    public GeographicWindow getGeographicWindow() {
        return geographicWindow;
    }

    public void setGeographicWindow(GeographicWindow geographicWindow) {
        this.geographicWindow = geographicWindow;
    }

    public ListingResults getListingResults() {
        return listingResults;
    }

    public void setListingResults(ListingResults listingResults) {
        this.listingResults = listingResults;
    }

    public NavigatorResults getNavigatorResults() {
        return navigatorResults;
    }

    public void setNavigatorResults(NavigatorResults navigatorResults) {
        this.navigatorResults = navigatorResults;
    }

    public PoiMarkerResults getPoiMarkerResults() {
        return poiMarkerResults;
    }

    public void setPoiMarkerResults(PoiMarkerResults poiMarkerResults) {
        this.poiMarkerResults = poiMarkerResults;
    }
}
