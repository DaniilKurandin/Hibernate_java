package dao;

import entity.Client;

import java.util.List;

public interface IClientDAO {
    void add(Client client);

    List<Client> getAll();

    Client getById(int id);

    void updatePhone(String phone, Client client);

    void removeMark(String phone);
}
