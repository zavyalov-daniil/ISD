package com.notes.isd.services.exception.handling;

/**
 * Используется в мапе сдля соотнесения ошибки с более развёрнутым её описанием.
 */
//@Component
public class ExceptionToken {
    private final String code;
    private final String errorRespresentation;

    public ExceptionToken(String code, String errorRespresentation) {
        this.code = code;
        this.errorRespresentation = errorRespresentation;
    }

    public String getCode() {
        return code;
    }

    public String getErrorRespresentation() {
        return errorRespresentation;
    }
}
