package com.gwd.tracetool.utils;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class JSONUtils {
    private JSONUtils() {
        throw new AssertionError();
    }

    public static String getEventName(JSONObject headerJSON) {
        try {
            JSONObject headerObject = (JSONObject) JSONValue.parse(headerJSON.get("header").toString());
            JSONObject eventObject = (JSONObject) JSONValue.parse(headerObject.get("event").toString());
            return eventObject.get("eventName").toString();
        } catch (NullPointerException e) {
            return "NoEventName";
        }
    }

    public static String getCreateAt(JSONObject headerJSON) {
        try {
            JSONObject headerObject = (JSONObject) JSONValue.parse(headerJSON.get("header").toString());
            JSONObject eventObject = (JSONObject) JSONValue.parse(headerObject.get("event").toString());
            return eventObject.get("createAt").toString();
        } catch (NullPointerException e) {
            return "NoCreateAt";
        }
    }

    public static String getProvider(JSONObject headerJSON) {
        try {
            JSONObject headerObject = (JSONObject) JSONValue.parse(headerJSON.get("header").toString());
            JSONObject eventObject = (JSONObject) JSONValue.parse(headerObject.get("event").toString());
            return eventObject.get("provider").toString();
        } catch (NullPointerException e) {
            return "NoProvider";
        }
    }

    public static String getWorkflowType(JSONObject headerJSON) {
        try {
            JSONObject headerObject = (JSONObject) JSONValue.parse(headerJSON.get("header").toString());
            JSONObject workflowObject = (JSONObject) JSONValue.parse(headerObject.get("workflow").toString());
            JSONObject workflowTypeObject = (JSONObject) JSONValue.parse(workflowObject.get("workflowType").toString());
            return workflowTypeObject.get("name").toString();
        } catch (NullPointerException e) {
            return "NoWorkflow";
        }
    }

    public static String getTransactionId(JSONObject headerJSON) {
        try {
            JSONObject headerObject = (JSONObject) JSONValue.parse(headerJSON.get("header").toString());
            JSONObject workflowObject = (JSONObject) JSONValue.parse(headerObject.get("workflow").toString());
            return workflowObject.get("transactionId").toString();
        } catch (NullPointerException e) {
            return "NoTransactionId";
        }
    }

    public static String getHttpStatusCode(JSONObject headerJSON) {
        try {
            JSONObject headerObject = (JSONObject) JSONValue.parse(headerJSON.get("header").toString());
            JSONObject amqResponseInfoObject = (JSONObject) JSONValue.parse(headerObject.get("amqResponseInfo").toString());
            return amqResponseInfoObject.get("httpStatusCode").toString();
        } catch (NullPointerException e) {
            return "NoHttpStatusCode";
        }
    }

}
