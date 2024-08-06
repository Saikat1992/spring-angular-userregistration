package com.javatechie.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController{

	@RequestMapping("/error")
    @ResponseBody
    public String handleError(HttpServletRequest request) {
        // You can add custom error handling logic here
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String errorMessage = (String) request.getAttribute("javax.servlet.error.message");
        return "Error occurred with status code: " + statusCode + " and message: " + errorMessage;
    }

    public String getErrorPathString() {
        return "/error";
    }
}
