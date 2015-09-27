package ru.shakhin.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import ru.shakhin.model.Dictionary;


import java.util.List;

/**
 * Created by Kostya on 30.11.2014.
 */
@Transactional
public class DictionaryDAO {
    private SessionFactory sessionFactory;

    public DictionaryDAO(){}

    public DictionaryDAO(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession(){

        return sessionFactory.getCurrentSession();
    }

    public List findAllWords(){
        Query query = getCurrentSession().createQuery("from Dictionary");
        List list = query.list();

       return list;
//
    }
//    public String getMessage(){};
}
