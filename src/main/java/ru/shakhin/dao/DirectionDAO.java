package ru.shakhin.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Kostya on 21.12.2014.
 */
@Transactional
public class DirectionDAO {
    private SessionFactory sessionFactory;

    public DirectionDAO(){}

    public DirectionDAO(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession(){

        return sessionFactory.getCurrentSession();
    }
    public List findById(long id){
        return getCurrentSession().createQuery("from Direction d where s.id = id").list();
    }
    public List findAll(){
        return getCurrentSession().createQuery("from Direction d ").list();
    }
}
