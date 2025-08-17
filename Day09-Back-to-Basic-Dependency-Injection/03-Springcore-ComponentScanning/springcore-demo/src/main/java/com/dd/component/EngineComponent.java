package com.dd.component;

import org.springframework.stereotype.Component;

@Component
public class EngineComponent implements Engine {

    @Override
    public String engineType() {
        return "Petrol";
    }
}
