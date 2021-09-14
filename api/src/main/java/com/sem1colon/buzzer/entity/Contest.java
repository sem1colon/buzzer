package com.sem1colon.buzzer.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Contest {
    @Id
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
