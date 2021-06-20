package dao;

public interface IDAOFactory {
    ICarDAO getCarDAO();
    IClientDAO getClientDAO();
}
