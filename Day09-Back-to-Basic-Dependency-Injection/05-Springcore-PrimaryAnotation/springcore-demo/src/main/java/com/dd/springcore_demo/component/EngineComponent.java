package com.dd.springcore_demo.component;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class EngineComponent implements Engine {

    @Override
    public String engineType() {
        return "Engine Component";
    }
}
