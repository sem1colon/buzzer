package com.sem1colon.buzzer.contestant;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Contestant {
    @Id
    private String username;
    private boolean isBuzzerPressed;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isBuzzerPressed() {
        return isBuzzerPressed;
    }

    public void setBuzzerPressed(boolean buzzerPressed) {
        isBuzzerPressed = buzzerPressed;
    }

    @Override
    public String toString() {
        return "Contestant{" +
                "username='" + username + '\'' +
                ", isBuzzerPressed=" + isBuzzerPressed +
                '}';
    }
}
