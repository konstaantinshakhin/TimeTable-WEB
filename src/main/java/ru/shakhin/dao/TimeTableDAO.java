package ru.shakhin.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Kostya on 20.12.2014.
 */
@Transactional
public class TimeTableDAO {
    private SessionFactory sessionFactory;

    public TimeTableDAO(){}

    public TimeTableDAO(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession(){

        return sessionFactory.getCurrentSession();
    }
    public List findById(long id){
        return getCurrentSession().createQuery("from TimeTable tb where s.id = id").list();
    }
    public List findAll(){
        return getCurrentSession().createQuery("from TimeTable tb ").list();
    }
    public List findAllByDirection(String direction){
        String hql = "from TimeTable tb where tb.direction = :direction";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("direction",direction);
        List results = query.list();
        return results;
    }
    public List findAllByDirectionAndNumber(String direction,String number){
        String hql = "from TimeTable tb where tb.direction.name = :direction and tb.train.number = :number";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("direction",direction);
        query.setParameter("number",number);
        List results = query.list();
        return results;

    }

}
