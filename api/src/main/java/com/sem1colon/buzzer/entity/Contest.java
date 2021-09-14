package com.sem1colon.buzzer.entity;

import java.util.ArrayList;

public class Contest {
    private String id;
    private String host;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public String toString() {
        return "Contest{" +
                "id='" + id + '\'' +
                ", host='" + host + '\'' +
                '}';
    }


}
