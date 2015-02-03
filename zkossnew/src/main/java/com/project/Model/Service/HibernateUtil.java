package com.project.Model.Service;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import java.util.List;

@Transactional(propagation= Propagation.REQUIRED, readOnly=false)
public final class HibernateUtil<T extends Serializable, PK extends Serializable>{
    private final HibernateTemplate hibernateTemplate;
    private final SessionFactory sessionFactory;

    public HibernateUtil() {
        sessionFactory = (SessionFactory) SpringContext.getInstance().getBean("sessionFactory");
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    public SessionFactory getSessionFactory(){
        return this.sessionFactory;
    }

    public void add(T entity){
        this.hibernateTemplate.save(entity);
    }

    public T get(Class<T> type, PK id){
        return (T)this.hibernateTemplate.get(type,id);
    }

    public void update(T entity){
        this.hibernateTemplate.update(entity);
    }

    public List<T> getAll(Class<T> type){
        return this.hibernateTemplate.loadAll(type);
    }

    public void remove(T entity) {
        this.hibernateTemplate.delete(entity);
    }

    public void removeById(Class<T> entityClass, PK id) {
        remove(get(entityClass, id));
    }
}
