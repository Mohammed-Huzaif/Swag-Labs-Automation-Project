package com.ui.pojo;

import java.util.HashMap;
import java.util.Map;

public class Config {

    Map<String, Environment> environments = new HashMap<>();

    public Map<String, Environment> getEnvironments() {
        return environments;
    }

    public void setEnvironments(Map<String, Environment> environment) {
        this.environments = environment;
    }
}
