package com.notes.isd.services.exception_handlers;

import java.util.Map;

public interface ExceptionDescriptor {
    public void addLine(String title, String text);

    public Map<String, String> getMessage();

    public String toString();
}
