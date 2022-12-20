package com.notes.isd.services.exception_handlers;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SimpleExceptionDescriptor implements ExceptionDescriptor {

    private Map<String, String> descriptionLines;

    public SimpleExceptionDescriptor(HashMap<String, String> lines) {
        this.descriptionLines = new HashMap<>(lines);
    }

    public SimpleExceptionDescriptor() {
        this.descriptionLines = new HashMap<>();
    }

    @Override
    public void addLine(String title, String text) {
        descriptionLines.put(title, text);
    }

    @Override
    public Map<String, String> getMessage() {
        return descriptionLines;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String title : descriptionLines.keySet()) {
            sb.append(title);
            sb.append(": ");
            sb.append(descriptionLines.get(title));
            sb.append('\n');
        }
        return sb.toString();
    }
}
