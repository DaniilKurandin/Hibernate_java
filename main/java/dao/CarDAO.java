package dao;

import entity.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CarDAO implements ICarDAO {
    @Override
    public void add(Car car) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();
        session.save(car);
        session.flush();
        session.getTransaction().commit();
        session.close();
        factory.close();
    }

    @Override
    public List<Car> getAll() {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();

        List<Car> list = session.createQuery("from Car", Car.class).list();

        session.close();
        factory.close();

        return list;
    }

    @Override
    public Car getById(int id) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Car car = factory.openSession().get(Car.class, id);

        factory.close();

        return car;
    }

    @Override
    public void updatePrice(int price, Car car) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        if (factory.openSession().get(Car.class, price) != null) {
            Session session = factory.openSession();

            session.beginTransaction();

            car.setPrice(price);

            session.update(car);
            session.flush();
            session.getTransaction().commit();

            session.close();
        }

        factory.close();
    }

    @Override
    public void removeMark(String mark) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Car car = factory.openSession().get(Car.class, mark);

        if (car != null) {
            Session session = factory.openSession();
            session.beginTransaction();

            session.delete(car);
            session.flush();
            session.getTransaction().commit();

            session.close();
        }

        factory.close();
    }

    @Override
    public void removeModel(String model) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Car car = factory.openSession().get(Car.class, model);

        if (car != null) {
            Session session = factory.openSession();
            session.beginTransaction();

            session.delete(car);
            session.flush();
            session.getTransaction().commit();

            session.close();
        }

        factory.close();
    }
}
