package dao;

public class DAOFactory implements IDAOFactory {
    @Override
    public ICarDAO getCarDAO() {
        return new CarDAO();
    }

    @Override
    public IClientDAO getClientDAO() {
        return new ClientDAO();
    }
}
