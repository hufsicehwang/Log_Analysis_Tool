package com.gwd.tracetool.service;

import java.util.List;

public interface EventParserService {
    List readEventList(String date);

    List readErrorEventList(String date);

}
