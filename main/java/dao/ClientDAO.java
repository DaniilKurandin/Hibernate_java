package dao;

import entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ClientDAO implements IClientDAO {
    @Override
    public void add(Client client) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();
        session.save(client);
        session.flush();
        session.getTransaction().commit();
        session.close();
        factory.close();
    }

    @Override
    public List<Client> getAll() {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();

        List<Client> list = session.createQuery("from Client", Client.class).list();

        session.close();
        factory.close();

        return list;
    }

    @Override
    public Client getById(int id) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Client client = factory.openSession().get(Client.class, id);

        factory.close();

        return client;
    }

    @Override
    public void updatePhone(String phone, Client client) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        if (factory.openSession().get(Client.class, phone) != null) {
            Session session = factory.openSession();

            session.beginTransaction();

            client.setPhone(phone);

            session.update(client);
            session.flush();
            session.getTransaction().commit();

            session.close();
        }

        factory.close();
    }

    @Override
    public void removeMark(String phone) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Client client = factory.openSession().get(Client.class, phone);

        if (client != null) {
            Session session = factory.openSession();
            session.beginTransaction();

            session.delete(client);
            session.flush();
            session.getTransaction().commit();

            session.close();
        }

        factory.close();
    }
}
