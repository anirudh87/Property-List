package com.app.propertylist.datamodels;

public class SearchRequest {

    private String mode;
    private String sub;
    private String pcodes;
    private String state;

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getPcodes() {
        return pcodes;
    }

    public void setPcodes(String pcodes) {
        this.pcodes = pcodes;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
