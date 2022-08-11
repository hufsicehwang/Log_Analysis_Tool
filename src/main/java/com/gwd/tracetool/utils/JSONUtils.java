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
    public static String getErrorName(JSONObject headerJSON) {
        try {
            JSONObject headerObject = (JSONObject) JSONValue.parse(headerJSON.get("header").toString());
            JSONObject eventObject = (JSONObject) JSONValue.parse(headerObject.get("event").toString());
            JSONObject typeObject = (JSONObject) JSONValue.parse(eventObject.get("type").toString());
            return typeObject.get("eventName").toString();
        } catch (NullPointerException e) {
            return "NoErrorName";
        }
    }

    public static String getFailEventName(JSONObject headerJSON) {
        try {
            JSONObject failEventTypeObject = (JSONObject) JSONValue.parse(headerJSON.get("failEventType").toString());
            return failEventTypeObject.get("eventName").toString();
        } catch (NullPointerException e) {
            return "NoFailEventName";
        }
    }
    public static String getFailWorkflowType(JSONObject headerJSON) {
        try {
            JSONObject failEventWorkflowObject = (JSONObject) JSONValue.parse(headerJSON.get("failEventWorkflow").toString());
            return failEventWorkflowObject.get("name").toString();
        } catch (NullPointerException e) {
            return "NoFailWorkflowType";
        }
    }

    public static String getFailTransactionId(JSONObject headerJSON) {
        try {
            JSONObject originHeaderObject = (JSONObject) JSONValue.parse(headerJSON.get("originalMessageHeader").toString());
            JSONObject workflowObject = (JSONObject) JSONValue.parse(originHeaderObject.get("workflow").toString());
            return workflowObject.get("transactionId").toString();
        } catch (NullPointerException e) {
            return "NoFailTransactionId";
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
