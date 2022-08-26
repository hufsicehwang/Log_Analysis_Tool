package com.gwd.tracetool.utils;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public final class Constants {

    private Constants() {
        throw new AssertionError();
    }

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    public static final SimpleDateFormat SIMPLE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

    public static final String API_QUEUE_RECORD = "[Feign Response] ";
    public static final String EVENT_QUEUE_RECORD = "receive message propertioes: MessageProperties";
    public static final String ERROR_EVENT_QUEUE_RECORD = "receive error message propertioes: MessageProperties";
    public static final String EVENT_TOKEN = "receivemessage: ";
    public static final String ERROR_EVENT_TOKEN = "receivemessage: ";

}
