package com.springSecurityPractice.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CsrfController {

    // GET: Returns the current CSRF token for the session
    // CSRF token is tied with the user's session ID
    // Needed for POST/PUT/DELETE requests when CSRF protection is ON
    @GetMapping("csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
