package com.app.propertylist.datamodels;

import java.io.Serializable;
import java.util.List;

public class NavigatorResults implements Serializable {

    private List<Navigator> navigators;

    public List<Navigator> getNavigators() {
        return navigators;
    }

    public void setNavigators(List<Navigator> navigators) {
        this.navigators = navigators;
    }
}
