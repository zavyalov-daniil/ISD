package com.notes.isd.services.exception.handling;

import com.notes.isd.config.ExceptionDescriptorConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Component
public class ExceptionHandler implements HandlerExceptionResolver {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
        System.out.println("Spring MVC ExceptionHandler handling");
        logger.error("ErrorLog: ", e);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ExceptionDescriptorConfig.class);
        Map<Class, ExceptionToken> handlers = new HashMap<Class, ExceptionToken>();
        handlers.put(RuntimeException.class, new ExceptionToken("418", "testExceptionOne 'cause I'm a teaport"));
        ExceptionDescriptionCreator descriptor = new ExceptionDescriptionCreator(handlers);// context.getBean(ExceptionDescriptionCreator.class);
        String description = descriptor.getExceptionDescription(e);
        CurrentExceptionKeeper.setDescription(description);
        //Как передать контекст в контроллер?
        return new ModelAndView("error/exception", "exceptionMsg", "Message:\n" + description);
    }
}
