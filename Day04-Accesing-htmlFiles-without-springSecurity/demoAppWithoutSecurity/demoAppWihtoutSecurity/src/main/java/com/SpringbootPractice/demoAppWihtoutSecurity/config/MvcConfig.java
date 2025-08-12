package com.SpringbootPractice.demoAppWihtoutSecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * MvcConfig class is responsible for configuring simple view controllers
 * without the need for explicitly writing controller classes.
 * This approach is useful when you just need to map a URL directly to a view template.
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home"); // Maps "/home" URL to "home.html" view
        registry.addViewController("/").setViewName("home");     // Maps root "/" to "home.html" view
        registry.addViewController("/hello").setViewName("hello"); // Maps "/hello" URL to "hello.html" view
    }
}
    /**
     * This method registers view controllers for specific URL paths
     * and directly maps them to their corresponding view names.
     * It helps avoid writing boilerplate controller code for simple page rendering.
     *
     * Advantages:
     * 1. Reduces boilerplate code by removing the need for explicit controller methods.
     * 2. Improves readability and maintainability for static or simple pages.
     * 3. Useful for basic mappings like home, login, or static info pages.
     * 4. Keeps controller classes clean and focused on complex business logic.
     */
