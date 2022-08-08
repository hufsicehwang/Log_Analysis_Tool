package com.gwd.tracetool.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONTransfer {
    public static JSONObject stringToJSON (String subStr) {
        JSONParser parser = new JSONParser();

        try {
            JSONObject jsonObject = (JSONObject) parser.parse(subStr);
            return jsonObject;

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
