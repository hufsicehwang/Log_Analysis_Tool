package com.gwd.tracetool.utils;

import org.json.simple.JSONObject;

import java.util.Comparator;

public class JSONComparator implements Comparator<JSONObject> {
    @Override
    public int compare(JSONObject object1, JSONObject object2) {
        String value1 = object1.get("occurrenceTime").toString();
        String value2 = object2.get("occurrenceTime").toString();
        return value1.compareTo(value2);
    }
}