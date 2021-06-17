package com.itvdn.decision1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal("Tvarina", 11, true);

        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();
        session.save(animal);
        session.flush();
        session.getTransaction().commit();

        //       List<Animal> list = session.createQuery("from Animal", Animal.class).list();

        session.close();
        factory.close();

//        for(Animal animal: list) {
//            System.out.println(animal);
//        }
    }
}
