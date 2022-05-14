package src.helper;

import src.data.dao_impl.StudentDAOImpl;
import src.domain.dao.StudentDAO;

/**
 * This is the DI Container class.
 * 
 * It will be used to inject the dependencies to the classes.
 */
public class DIContainer {
    private DIContainer() {

    }

    public static StudentDAO getStudentDAO() {
        return new StudentDAOImpl();
    }
}
