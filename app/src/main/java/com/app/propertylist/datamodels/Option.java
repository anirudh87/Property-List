package com.app.propertylist.datamodels;

import java.io.Serializable;

public class Option implements Serializable {

    private int Count;

    private String StringValue;

    private String Text;

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public String getStringValue() {
        return StringValue;
    }

    public void setStringValue(String stringValue) {
        StringValue = stringValue;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }
}
