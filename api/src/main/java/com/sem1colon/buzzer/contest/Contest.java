package com.sem1colon.buzzer.contest;

import com.sem1colon.buzzer.contestant.Contestant;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Contest {
    @Id
    private String id;
    private String host;
    @OneToMany(targetEntity = Contestant.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "Contest_Contestant_FK", referencedColumnName = "id")
    private List<Contestant> contestants = new ArrayList<>();

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

    public List<Contestant> getContestants() {
        return contestants;
    }

    public void setContestants(List<Contestant> contestants) {
        this.contestants = contestants;
    }

    @Override
    public String toString() {
        return "Contest{" +
                "id='" + id + '\'' +
                ", host='" + host + '\'' +
                ", contestants=" + contestants +
                '}';
    }
}
