package entity;

import dao.DAOFactory;
import dao.ICarDAO;
import dao.IClientDAO;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ICarDAO carDAO = new DAOFactory().getCarDAO();

        IClientDAO clientDAO = new DAOFactory().getClientDAO();

        Client client = new Client("Vasili", 23, "8(982)11-11-111");

        clientDAO.add(client);

        Car car = new Car("Subaru", "X6", 300000);

        carDAO.add(car);

        List<Car> list = carDAO.getAll();

        for (Car car1 : list) {
            System.out.println(car1);
        }


    }
}
