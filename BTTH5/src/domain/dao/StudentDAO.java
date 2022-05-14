package src.domain.dao;

import src.base.BaseDAO;
import src.domain.models.Student;

/**
 * This is the Student DAO interface. Any implementation of this interface will
 * be used yo interact with database
 * It contains commons methods declared inside BaseDAO interface.
 * 
 * User can add more methods to this interface if needed.
 */
public interface StudentDAO extends BaseDAO<Student> {

}
