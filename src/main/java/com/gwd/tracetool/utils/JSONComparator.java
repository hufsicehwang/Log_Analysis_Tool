package com.gwd.tracetool.utils;

import org.json.simple.JSONObject;

import java.util.Comparator;

public class JSONComparator implements Comparator<JSONObject> {
    @Override
    public int compare(JSONObject o1, JSONObject o2) {
        String v1 = o1.get("occurrenceTime").toString();
        String v3 = o2.get("occurrenceTime").toString();
        return v1.compareTo(v3);
    }
}