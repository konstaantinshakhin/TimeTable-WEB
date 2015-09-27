package ru.shakhin.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.shakhin.model.Word;

import java.util.List;

/**
 * Created by kshahin on 17.12.2014.
 */
public class WordDAO {

    private SessionFactory sessionFactory;

    public WordDAO(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
    public List<Word> findAllWords(){
        return  getCurrentSession().createQuery("from Word as w").list();

    }

}