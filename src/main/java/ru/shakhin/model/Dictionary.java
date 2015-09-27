package ru.shakhin.model;


import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
/**
 * Created by Kostya on 30.11.2014.
 */


@Entity(name = "Dictionary")
@Table(name = "DICTIONARY")
public class Dictionary implements java.io.Serializable {

    private Integer id;
    private String word;
    private String translate;

    public Dictionary() {
    }

    public Dictionary(String word, String tarnslate) {
        this.word = word;
        this.translate = tarnslate;
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

    @Column(name = "WORD")
    public String getWord() {
        return this.word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Column(name = "TRANSLATE")
    public String getTranslate() {
        return this.translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    @Override
    public String toString() {
        return "Dictionary [word=" + word + ", id=" + id
                + ", translate=" + translate + "]";
    }
}