package com.gwd.tracetool.utils;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class JSONUtils {
    private JSONUtils() {
        throw new AssertionError();
    }

    public static String getEventName(JSONObject headerJSON) {
        JSONObject headerObject = (JSONObject) JSONValue.parse(headerJSON.get("header").toString());
        try {
            JSONObject eventObject = (JSONObject) JSONValue.parse(headerObject.get("event").toString());
            return eventObject.get("eventName").toString();
        } catch (NullPointerException e) {
            return "NoEventName";
        }
    }

    public static String getCreateAt(JSONObject headerJSON){
        try {
            JSONObject headerObject = (JSONObject) JSONValue.parse(headerJSON.get("header").toString());
            JSONObject eventObject = (JSONObject) JSONValue.parse(headerObject.get("event").toString());
            return eventObject.get("createAt").toString();
        } catch (NullPointerException e) {
            return "NoCreateAt";
        }
    }
}
