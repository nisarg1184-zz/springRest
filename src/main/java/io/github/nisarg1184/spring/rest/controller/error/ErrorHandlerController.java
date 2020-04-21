package io.github.nisarg1184.spring.rest.controller.error;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorHandlerController implements ErrorController {
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            switch (statusCode) {
                case 403: return "403";
                case 404: return "404";
                case 401: return "401";
            }
        }
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "error";
    }
}
