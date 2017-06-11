package com.app.propertylist.datamodels;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ListingResults implements Serializable {

    @SerializedName("ResultsReturned")
    private int resultsReturned;

    @SerializedName("ResultsTotal")
    private int resultsTotal;

    @SerializedName("TopSpotAgencyBanner")
    private String topSpotAgencyBanner;

    @SerializedName("TopSpotAgencyID")
    private int topSpotAgencyId;

    @SerializedName("TopSpotBackgroundColor")
    private String topSpotBackgroundColor;

    @SerializedName("TopSpotListingCount")
    private int topSpotListingCount;

    private List<PropertyData> Listings;

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

    public String getTopSpotAgencyBanner() {
        return topSpotAgencyBanner;
    }

    public void setTopSpotAgencyBanner(String topSpotAgencyBanner) {
        this.topSpotAgencyBanner = topSpotAgencyBanner;
    }

    public int getTopSpotAgencyId() {
        return topSpotAgencyId;
    }

    public void setTopSpotAgencyId(int topSpotAgencyId) {
        this.topSpotAgencyId = topSpotAgencyId;
    }

    public String getTopSpotBackgroundColor() {
        return topSpotBackgroundColor;
    }

    public void setTopSpotBackgroundColor(String topSpotBackgroundColor) {
        this.topSpotBackgroundColor = topSpotBackgroundColor;
    }

    public int getTopSpotListingCount() {
        return topSpotListingCount;
    }

    public void setTopSpotListingCount(int topSpotListingCount) {
        this.topSpotListingCount = topSpotListingCount;
    }

    public List<PropertyData> getListings() {
        return Listings;
    }

    public void setListings(List<PropertyData> listings) {
        this.Listings = listings;
    }
}
