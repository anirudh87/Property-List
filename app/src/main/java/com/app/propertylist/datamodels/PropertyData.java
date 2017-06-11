package com.app.propertylist.datamodels;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class PropertyData implements Parcelable {

    public int AdId;

    public String AgencyColor;

    public String AgencyContactPhoto;

    public String AgencyLogoUrl;

    public int AgencyId;

    public String Area;

    public int Bathrooms;

    public int Bedrooms;

    public int Carspaces;

    public List<String> ImageUrls;

    public int IsElite;

    public String DisplayableAddress;

    public String DisplayPrice;

    public String ListingType;

    public String TruncatedDescription;

    public String RetinaDisplayThumbUrl;

    public String SecondRetinaDisplayThumbUrl;

    private PropertyData(Parcel in) {
        AdId = in.readInt();
        AgencyColor = in.readString();
        AgencyContactPhoto = in.readString();
        AgencyLogoUrl = in.readString();
        AgencyId = in.readInt();
        Area = in.readString();
        Bathrooms = in.readInt();
        Bedrooms = in.readInt();
        Carspaces = in.readInt();
        ImageUrls = in.createStringArrayList();
        IsElite = in.readInt();
        DisplayableAddress = in.readString();
        DisplayPrice = in.readString();
        ListingType = in.readString();
        TruncatedDescription = in.readString();
        RetinaDisplayThumbUrl = in.readString();
        SecondRetinaDisplayThumbUrl = in.readString();
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

    public String getAgencyLogoUrl() {
        return AgencyLogoUrl;
    }

    public void setAgencyLogoUrl(String agencyLogoUrl) {
        AgencyLogoUrl = agencyLogoUrl;
    }

    public int getCarspaces() {
        return Carspaces;
    }

    public void setCarspaces(int carspaces) {
        Carspaces = carspaces;
    }

    public String getTruncatedDescription() {
        return TruncatedDescription;
    }

    public void setTruncatedDescription(String truncatedDescription) {
        TruncatedDescription = truncatedDescription;
    }

    public String getRetinaDisplayThumbUrl() {
        return RetinaDisplayThumbUrl;
    }

    public void setRetinaDisplayThumbUrl(String retinaDisplayThumbUrl) {
        RetinaDisplayThumbUrl = retinaDisplayThumbUrl;
    }

    public String getSecondRetinaDisplayThumbUrl() {
        return SecondRetinaDisplayThumbUrl;
    }

    public void setSecondRetinaDisplayThumbUrl(String secondRetinaDisplayThumbUrl) {
        SecondRetinaDisplayThumbUrl = secondRetinaDisplayThumbUrl;
    }

    public String getDisplayPrice() {
        return DisplayPrice;
    }

    public void setDisplayPrice(String displayPrice) {
        DisplayPrice = displayPrice;
    }

    public String getListingType() {
        return ListingType;
    }

    public void setListingType(String listingType) {
        ListingType = listingType;
    }

    public String getDisplayableAddress() {
        return DisplayableAddress;
    }

    public void setDisplayableAddress(String displayableAddress) {
        DisplayableAddress = displayableAddress;
    }

    public int getIsElite() {
        return IsElite;
    }

    public void setIsElite(int IsElite) {
        this.IsElite = IsElite;
    }

    public int getAdId() {
        return AdId;
    }

    public void setAdId(int adId) {
        AdId = adId;
    }

    public String getAgencyColor() {
        return AgencyColor;
    }

    public void setAgencyColor(String agencyColor) {
        AgencyColor = agencyColor;
    }

    public String getAgencyContactPhoto() {
        return AgencyContactPhoto;
    }

    public void setAgencyContactPhoto(String agencyContactPhoto) {
        AgencyContactPhoto = agencyContactPhoto;
    }

    public int getAgencyId() {
        return AgencyId;
    }

    public void setAgencyId(int agencyId) {
        AgencyId = agencyId;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public int getBathrooms() {
        return Bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        Bathrooms = bathrooms;
    }

    public int getBedrooms() {
        return Bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        Bedrooms = bedrooms;
    }

    public List<String> getImageUrls() {
        return ImageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        ImageUrls = imageUrls;
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
