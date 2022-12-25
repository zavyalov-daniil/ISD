package com.notes.isd.config;

import com.notes.isd.services.exception_handlers.ExceptionDescriptionCreator;
import com.notes.isd.services.exception_handlers.ExceptionToken;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ExceptionDescriptorConfig {
    @Bean
    ExceptionDescriptionCreator exceptionDescriptionCreator() {
        Map<Class, ExceptionToken> handlers = new HashMap<Class, ExceptionToken>();
        handlers.put(RuntimeException.class, new ExceptionToken("418", "testExceptionOne 'cause I'm a teaport"));
        return new ExceptionDescriptionCreator(handlers);
    }
}
