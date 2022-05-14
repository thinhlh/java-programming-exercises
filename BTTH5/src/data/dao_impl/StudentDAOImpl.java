package src.data.dao_impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.domain.dao.StudentDAO;
import src.domain.models.Student;

/**
 * This is the implementation of StudentDAO interface.
 * 
 * This class will define the interaction with the Database inorder to perform
 * Student DAO declared operations.
 */
public class StudentDAOImpl implements StudentDAO {

    @Override
    public Student findById(String id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM student WHERE student_id = ?");

        statement.setString(1, id);
        ResultSet result = statement.executeQuery();

        if (result.next()) {
            return new Student(result.getString("student_id"),
                    result.getString("first_name"),
                    result.getString("last_name"),
                    result.getDate("dob"),
                    result.getString("department"),
                    result.getDate("entrance_date"),
                    result.getDate("graduation_date"),
                    result.getInt("credits"),
                    result.getDouble("score"));
        } else {
            return null;
        }

    }

    @Override
    public List<Student> findAll() throws SQLException {

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM student");
        ResultSet result = statement.executeQuery();
        ArrayList<Student> students = new ArrayList<>();

        while (result.next()) {
            students.add(
                    new Student(
                            result.getString("student_id"),
                            result.getString("first_name"),
                            result.getString("last_name"),
                            result.getDate("dob"),
                            result.getString("department"),
                            result.getDate("entrance_date"),
                            result.getDate("graduation_date"),
                            result.getInt("credits"),
                            result.getDouble("score")));
        }
        return students;
    }

    @Override
    public boolean save(Student entity) throws SQLException {

        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO student (student_id, first_name, last_name, dob, department, entrance_date, graduation_date, credits, score) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

        statement.setString(1, entity.getStudentId());
        statement.setString(2, entity.getFirstName());
        statement.setString(3, entity.getLastName());
        statement.setDate(4, entity.getDob());
        statement.setString(5, entity.getDepartment());
        statement.setDate(6, entity.getEntranceDate());
        statement.setDate(7, entity.getGraduationDate());
        statement.setInt(8, entity.getCredits());
        statement.setDouble(9, entity.getScore());

        int result = statement.executeUpdate();

        return result > 0; // if result is greater than 0, then the query was successful
    }

    @Override
    public boolean update(Student entity) throws SQLException {

        PreparedStatement statement = connection.prepareStatement(
                "UPDATE student SET first_name = ?, last_name = ?, dob = ?, department = ?, entrance_date = ?, graduation_date = ?, credits = ?, score = ? WHERE student_id = ?");

        statement.setString(1, entity.getFirstName());
        statement.setString(2, entity.getLastName());
        statement.setDate(3, entity.getDob());
        statement.setString(4, entity.getDepartment());
        statement.setDate(5, entity.getEntranceDate());
        statement.setDate(6, entity.getGraduationDate());
        statement.setInt(7, entity.getCredits());
        statement.setDouble(8, entity.getScore());
        statement.setString(9, entity.getStudentId());

        int result = statement.executeUpdate();

        return result > 0; // if result is greater than 0, then the update was successful
    }

    @Override
    public boolean delete(String id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM student WHERE student_id = ?");
        statement.setString(1, id);
        int result = statement.executeUpdate();

        return result > 0; // if result > 0, then delete was successful
    }

}
