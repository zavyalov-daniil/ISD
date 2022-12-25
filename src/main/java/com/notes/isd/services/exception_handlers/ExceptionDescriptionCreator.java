package com.notes.isd.services.exception_handlers;

import java.util.Map;

public class ExceptionDescriptionCreator {
    private Map<Class, ExceptionToken> classification;
    private ExceptionDescriptor descriptor;

//    private final Exception ex;

    public ExceptionDescriptionCreator(Map<Class, ExceptionToken> classification) {
        this.descriptor = new SimpleExceptionDescriptor();
        this.classification = classification;
//        this.ex = ex;
    }

    public String getExceptionDescription(Exception ex) {
        ExceptionToken token = new ExceptionToken("500", /*"unhandled error. You missed:" +*/ ex.toString());

        for (Class cl : classification.keySet()) {
            if (cl.equals(ex.getClass())) {
                token = classification.get(ex.getClass());
            }
//            ExceptionDescriptor description = new SimpleExceptionDescriptor();
            descriptor.addLine("code", token.getCode());
            descriptor.addLine("message", token.getErrorRespresentation());
            descriptor.addLine("source", ex.getStackTrace().toString());//todo: фабрика полей для вывода ошибки, запрос указывается в токене
        }

        return descriptor.toString();
    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        return sb.toString();
//    }
}
