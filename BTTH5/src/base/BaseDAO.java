package src.base;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import src.helper.DBConnection;

/**
 * This is the Base DAO interface that all DAO interfaces will extend.
 * It will contains all the common methods that all DAO interfaces will used to
 * interact with Database
 * 
 * @param T is the entity
 */
public interface BaseDAO<T> {

    public final Connection connection = DBConnection.getInstance().getConnection();

    public T findById(String id) throws SQLException;

    public List<T> findAll() throws SQLException;

    public boolean save(T entity) throws SQLException;

    public boolean update(T entity) throws SQLException;

    public boolean delete(String id) throws SQLException;

    default void closeConnection() throws SQLException {
        DBConnection.getInstance().closeConnection();
    }

}
