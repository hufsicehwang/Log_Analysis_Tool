package com.gwd.tracetool.utils;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONUtils {

    public static String getEventName(JSONObject headerJSON){
        JSONObject object1 = (JSONObject) JSONValue.parse(headerJSON.get("header").toString());
        JSONObject object2 = (JSONObject) JSONValue.parse(object1.get("event").toString());
        return object2.get("eventName").toString();
    }
}
