package com.gwd.tracetool.utils;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public final class Constants {

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    public static final SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd");

    public static final String apiQueueRecord = "[Feign Response] ";
    public static final String eventQueueRecord = "receive message propertioes: MessageProperties";
    public static final String errorEventQueueRecord = "receive error message propertioes: MessageProperties";
    public static final String eventToken = "receivemessage: ";
    public static final String errorEventToken = "receivemessage: ";

}
