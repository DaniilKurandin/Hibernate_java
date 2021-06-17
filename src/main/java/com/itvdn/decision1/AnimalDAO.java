package com.itvdn.decision1;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class AnimalDAO {
    public Animal getAnimal(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Animal.class, id);
    }

    public void update(Animal animal) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(animal);
        tx1.commit();
        session.close();
    }

    public void delete(Animal animal) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(animal);
        tx1.commit();
        session.close();
    }
}
