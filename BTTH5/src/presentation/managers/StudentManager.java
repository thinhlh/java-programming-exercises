package src.presentation.managers;

import java.sql.SQLException;
import java.util.List;

import src.base.BaseDAO;
import src.base.BaseManager;
import src.domain.models.Student;
import src.helper.DIContainer;

/**
 * This is the Student Manager class.
 * 
 * It will be used to manipulate the data flow related to Student.
 */
public class StudentManager extends BaseManager<Student> {
    @Override
    public BaseDAO<Student> createDAO() {
        return DIContainer.getStudentDAO();
    }

    @Override
    public void findAll() {

        try {
            List<Student> students = dao.findAll();

            for (Student student : students) {
                System.out.println(student);
            }
        } catch (SQLException e) {
            System.out.println("==> Error: " + e.getMessage());
        }

    }

    @Override
    public void findById(String id) {
        try {

            Student student = dao.findById(id);

            if (student == null) {
                throw new Exception("==> Student not found");
            } else
                System.out.println(student);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void create(Student student) {
        try {
            boolean result = dao.save(student);

            if (result)
                System.out.println("==> Student created successfully");
            else
                throw new Exception("==> Student creation failed! Student already exists!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void update(Student student) {

        try {
            boolean result = dao.update(student);

            if (result)
                System.out.println("==> Student updated successfully");
            else
                throw new Exception("==> Student update failed! Student not found!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        try {
            boolean result = dao.delete(id);

            if (result)
                System.out.println("==> Student deleted successfully");
            else
                throw new Exception("==> Student deletion failed! Student not found!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
