package ru.shakhin.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import ru.shakhin.model.Train;

import java.util.List;

/**
 * Created by Kostya on 20.12.2014.
 */
@Transactional
public class TrainDAO {
    private SessionFactory sessionFactory;

    public TrainDAO(){}

    public TrainDAO(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession(){

        return sessionFactory.getCurrentSession();
    }
    public List findById(long id){
        return getCurrentSession().createQuery("from Train t where t.id = id").list();
    }
    public List findAll(){
        return getCurrentSession().createQuery("from Train t ").list();
    }

}
