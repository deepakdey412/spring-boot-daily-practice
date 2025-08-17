package com.dd.springcore_demo.component;

import org.springframework.stereotype.Component;

@Component
public class EngineDesign implements Engine{

    @Override
    public String engineType() {
        return "Engine Desing....";
    }
}
