package ru.shakhin.model;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by kshahin on 17.12.2014.
 */

@Entity
@Table(name = "WORD")
public class Word {
    private Integer id;
    private String english;
    private String russian;

    public Word() {
    }

    public Word(String english, String russian) {
        this.english = english;
        this.russian = russian;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "INGLISH")
    public String getEnglish() {
        return this.english;
    }

    public String setEnglish(String english) {
        return this.english;
    }

    @Column(name = "RUSSIAN")
    public String getRussian() {
        return this.russian;
    }

    public String setRussian(String russian) {
        return this.english;
    }

}
