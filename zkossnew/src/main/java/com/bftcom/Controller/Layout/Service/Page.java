package com.bftcom.Controller.Layout.Service;

import java.io.Serializable;

/**
 * Created by Marolok on 08.01.2015.
 */
public class Page implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    String label;
    String uri;
    String location;

    public Page(String name,String label, String uri, String location) {
        this.name = name;
        this.label = label;
        this.uri = uri;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLabel() {
        return label;
    }

    public String getUri() {
        return uri;
    }

    public String getLocation() {return location;}
}
