package com.dd.springcore_demo.component;

import org.springframework.stereotype.Component;

@Component
public class EnginePart implements Engine {

    @Override
    public String engineType() {
        return "Engine Part";
    }
}
