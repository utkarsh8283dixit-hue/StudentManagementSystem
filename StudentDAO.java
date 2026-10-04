package com.student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // ==========================================
    // ADD STUDENT
    // ==========================================

    public void addStudent(Student student) {

        String sql = "INSERT INTO students " +
                "(name, age, course, email, phone) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, student.getName());
            pst.setInt(2, student.getAge());
            pst.setString(3, student.getCourse());
            pst.setString(4, student.getEmail());
            pst.setString(5, student.getPhone());

            int rows = pst.executeUpdate();

            if (rows > 0) {
                System.out.println("\nStudent added successfully!");
            }

        } catch (SQLException e) {

            System.out.println("\nError while adding student!");
            e.printStackTrace();
        }
    }


    // ==========================================
    // VIEW ALL STUDENTS
    // ==========================================

    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM students";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("course"),
                        rs.getString("email"),
                        rs.getString("phone")
                );

                students.add(student);
            }

        } catch (SQLException e) {

            System.out.println("\nError while fetching students!");
            e.printStackTrace();
        }

        return students;
    }


    // ==========================================
    // UPDATE STUDENT
    // ==========================================

    public void updateStudent(Student student) {

        String sql = "UPDATE students SET " +
                "name=?, age=?, course=?, email=?, phone=? " +
                "WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, student.getName());
            pst.setInt(2, student.getAge());
            pst.setString(3, student.getCourse());
            pst.setString(4, student.getEmail());
            pst.setString(5, student.getPhone());
            pst.setInt(6, student.getId());

            int rows = pst.executeUpdate();

            if (rows > 0) {

                System.out.println("\nStudent updated successfully!");

            } else {

                System.out.println("\nStudent ID not found!");
            }

        } catch (SQLException e) {

            System.out.println("\nError while updating student!");
            e.printStackTrace();
        }
    }


    // ==========================================
    // DELETE STUDENT
    // ==========================================

    public void deleteStudent(int id) {

        String sql = "DELETE FROM students WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, id);

            int rows = pst.executeUpdate();

            if (rows > 0) {

                System.out.println("\nStudent deleted successfully!");

            } else {

                System.out.println("\nStudent ID not found!");
            }

        } catch (SQLException e) {

            System.out.println("\nError while deleting student!");
            e.printStackTrace();
        }
    }


    // ==========================================
    // SEARCH STUDENT BY ID
    // ==========================================

    public Student getStudentById(int id) {

        String sql = "SELECT * FROM students WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                return new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("course"),
                        rs.getString("email"),
                        rs.getString("phone")
                );
            }

        } catch (SQLException e) {

            System.out.println("\nError while searching student!");
            e.printStackTrace();
        }

        return null;
    }
}