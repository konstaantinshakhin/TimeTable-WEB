package ru.shakhin.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import ru.shakhin.dao.DictionaryDAO;
import ru.shakhin.model.Dictionary;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Kostya on 30.11.2014.
 */

@Named(DictionaryBean.BEAN_NAME)
@Scope("session")
public class DictionaryBean implements Serializable {

    public static final String BEAN_NAME = "dictionaryBean";


    @Inject
    DictionaryDAO dictionaryDAO;

    private String word;
    private String translate;


    public String printMessage() {

        return "Hello World";
    }

    public List<Dictionary> getAllWords(){

        List<Dictionary> list = dictionaryDAO.findAllWords();

       return list;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }


}