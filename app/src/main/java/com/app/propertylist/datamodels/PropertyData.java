package com.app.propertylist.datamodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PropertyData implements Parcelable {

    @SerializedName("AdId")
    public int adId;

    @SerializedName("AgencyColor")
    public String agencyColor;

    @SerializedName("AgencyContactPhoto")
    public String agencyContactPhoto;

    @SerializedName("AgencyLogoUrl")
    public String agencyLogoUrl;

    @SerializedName("AgencyId")
    public int agencyId;

    @SerializedName("Area")
    public String area;

    @SerializedName("Bathrooms")
    public int bathrooms;

    @SerializedName("Bedrooms")
    public int bedrooms;

    @SerializedName("Carspaces")
    public int carspaces;

    @SerializedName("ImageUrls")
    public List<String> imageUrls;

    @SerializedName("IsElite")
    public int isElite;

    @SerializedName("DisplayableAddress")
    public String displayableAddress;

    @SerializedName("DisplayPrice")
    public String displayPrice;

    @SerializedName("ListingType")
    public String listingType;

    @SerializedName("TruncatedDescription")
    public String truncatedDescription;

    @SerializedName("RetinaDisplayThumbUrl")
    public String retinaDisplayThumbUrl;

    @SerializedName("SecondRetinaDisplayThumbUrl")
    public String secondRetinaDisplayThumbUrl;

    public boolean isFavorite;

    private PropertyData(Parcel in) {
        adId = in.readInt();
        agencyColor = in.readString();
        agencyContactPhoto = in.readString();
        agencyLogoUrl = in.readString();
        agencyId = in.readInt();
        area = in.readString();
        bathrooms = in.readInt();
        bedrooms = in.readInt();
        carspaces = in.readInt();
        imageUrls = in.createStringArrayList();
        isElite = in.readInt();
        displayableAddress = in.readString();
        displayPrice = in.readString();
        listingType = in.readString();
        truncatedDescription = in.readString();
        retinaDisplayThumbUrl = in.readString();
        secondRetinaDisplayThumbUrl = in.readString();
    }

    public PropertyData() {

    }

    public static final Creator<PropertyData> CREATOR = new Creator<PropertyData>() {
        @Override
        public PropertyData createFromParcel(Parcel in) {
            return new PropertyData(in);
        }

        @Override
        public PropertyData[] newArray(int size) {
            return new PropertyData[size];
        }
    };

    public int getAdId() {
        return adId;
    }

    public void setAdId(int adId) {
        this.adId = adId;
    }

    public String getAgencyColor() {
        return agencyColor;
    }

    public void setAgencyColor(String agencyColor) {
        this.agencyColor = agencyColor;
    }

    public String getAgencyContactPhoto() {
        return agencyContactPhoto;
    }

    public void setAgencyContactPhoto(String agencyContactPhoto) {
        this.agencyContactPhoto = agencyContactPhoto;
    }

    public String getAgencyLogoUrl() {
        return agencyLogoUrl;
    }

    public void setAgencyLogoUrl(String agencyLogoUrl) {
        this.agencyLogoUrl = agencyLogoUrl;
    }

    public int getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getCarspaces() {
        return carspaces;
    }

    public void setCarspaces(int carspaces) {
        this.carspaces = carspaces;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public int getIsElite() {
        return isElite;
    }

    public void setIsElite(int isElite) {
        this.isElite = isElite;
    }

    public String getDisplayableAddress() {
        return displayableAddress;
    }

    public void setDisplayableAddress(String displayableAddress) {
        this.displayableAddress = displayableAddress;
    }

    public String getDisplayPrice() {
        return displayPrice;
    }

    public void setDisplayPrice(String displayPrice) {
        this.displayPrice = displayPrice;
    }

    public String getListingType() {
        return listingType;
    }

    public void setListingType(String listingType) {
        this.listingType = listingType;
    }

    public String getTruncatedDescription() {
        return truncatedDescription;
    }

    public void setTruncatedDescription(String truncatedDescription) {
        this.truncatedDescription = truncatedDescription;
    }

    public String getRetinaDisplayThumbUrl() {
        return retinaDisplayThumbUrl;
    }

    public void setRetinaDisplayThumbUrl(String retinaDisplayThumbUrl) {
        this.retinaDisplayThumbUrl = retinaDisplayThumbUrl;
    }

    public String getSecondRetinaDisplayThumbUrl() {
        return secondRetinaDisplayThumbUrl;
    }

    public void setSecondRetinaDisplayThumbUrl(String secondRetinaDisplayThumbUrl) {
        this.secondRetinaDisplayThumbUrl = secondRetinaDisplayThumbUrl;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getAgencyLogoUrl());
        parcel.writeString(getDisplayableAddress());
        parcel.writeString(getDisplayPrice());
        parcel.writeInt(getBedrooms());
        parcel.writeInt(getBathrooms());
        parcel.writeInt(getCarspaces());
    }
}
