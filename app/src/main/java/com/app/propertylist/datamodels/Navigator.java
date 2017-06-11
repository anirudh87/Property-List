package com.app.propertylist.datamodels;

import java.io.Serializable;
import java.util.List;

public class Navigator implements Serializable {

    private String Name;

    private int NavigatorField;

    List<Option> options;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getNavigatorField() {
        return NavigatorField;
    }

    public void setNavigatorField(int navigatorField) {
        NavigatorField = navigatorField;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }
}
