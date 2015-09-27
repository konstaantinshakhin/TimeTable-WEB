package ru.shakhin.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import ru.shakhin.model.Station;

import java.util.List;

/**
 * Created by Kostya on 20.12.2014.
 */
@Transactional
public class StationDAO {
    private SessionFactory sessionFactory;

    public StationDAO(){}

    public StationDAO(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession(){

        return sessionFactory.getCurrentSession();
    }
    public List findById(long id){
        return getCurrentSession().createQuery("from Station s where s.id = id").list();
    }
    public List findAll(){
        return getCurrentSession().createQuery("from Station s ").list();
    }
}
