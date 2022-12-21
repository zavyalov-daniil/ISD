package com.notes.isd.contollers;

import com.notes.isd.entities.UserAccount;
import com.notes.isd.services.CurrentExceptionKeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.boot.web.error.ErrorAttributeOptions;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping({"${server.error.path:${error.path:/error}}"})
public class BasicErrorController extends AbstractErrorController {

    public BasicErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    /*remake some constructor*/
    @Autowired
    public BasicErrorController(ErrorAttributes errorAttributes, List<ErrorViewResolver> errorViewResolvers) {
        super(errorAttributes, errorViewResolvers);
    }

    @RequestMapping
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        HttpStatus status = this.getStatus(request);
        if (status == HttpStatus.NO_CONTENT) {
            return new ResponseEntity(status);
        } else {
            ErrorAttributeOptions options =
                    ErrorAttributeOptions.defaults()
                            .including(ErrorAttributeOptions.Include.EXCEPTION)
                            .including(ErrorAttributeOptions.Include.MESSAGE);
//                            .including(ErrorAttributeOptions.Include.STACK_TRACE);
            Map<String, String> body = new HashMap<String, String>();/* this.getErrorAttributes(request, options);*/
            String description = CurrentExceptionKeeper.getDescription();
            body.put("", description);
            
            return new ResponseEntity(body, status);
        }
    }

}
