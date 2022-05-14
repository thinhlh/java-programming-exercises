package src.base;

/**
 * This is the Base Manager class.
 * All managers will extend this class to have methods to interact with the DAO
 * and handling exceptions
 * 
 * @param <MODEL> is the model class
 */
public abstract class BaseManager<MODEL> {

    protected BaseDAO<MODEL> dao;

    public BaseManager() {
        dao = createDAO();
    }

    public abstract BaseDAO<MODEL> createDAO();

    public abstract void findAll();

    public abstract void findById(String id);

    public abstract void create(MODEL student);

    public abstract void update(MODEL student);

    public abstract void delete(String id);
}
