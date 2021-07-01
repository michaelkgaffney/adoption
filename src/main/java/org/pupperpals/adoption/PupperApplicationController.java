package org.pupperpals.adoption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class PupperApplicationController {
    @GetMapping("/")
    @ResponseStatus(HttpStatus.FOUND)
    public void redirectToDocs(HttpServletResponse httpServletResponse){
        httpServletResponse.setHeader("Location", "/docs/index.html");
    }
}
