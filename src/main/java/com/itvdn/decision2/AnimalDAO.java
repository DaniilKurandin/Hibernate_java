package com.itvdn.decision2;

import com.sun.istack.NotNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AnimalDAO implements DAO<Animal, Integer>{

    private final SessionFactory factory;

    public AnimalDAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Animal getAnimal(@NotNull final Integer id) {
        try (final Session session = factory.openSession()) {

            final Animal result = session.get(Animal.class, id);

            return result != null ? result : new Animal();
        }
    }

    @Override
    public void updateAnimal(@NotNull final Animal animal) {
        try (Session session = factory.openSession()) {

            session.beginTransaction();

            session.update(animal);

            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteAnimal(@NotNull final Animal animal) {
        try (Session session = factory.openSession()) {

            session.beginTransaction();

            session.delete(animal);

            session.getTransaction().commit();
        }
    }
}
