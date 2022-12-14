package com.tpssoft.retro.model.pokerGame;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(max = 50, message = "<50")
    private String name;
    private String url;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "game")
    private Collection<Issue> issues;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "game")
    private Collection<GameUser> gameUsers;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "game")
    private Collection<History> histories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Game() {
    }

    public Game(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
