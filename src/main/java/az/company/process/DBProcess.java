package az.company.process;

import az.company.connection.DBConnection;
import az.company.entity.Student;


import java.sql.*;
import java.util.List;
import java.util.Scanner;


public class DBProcess {
    private static Connection connection = DBConnection.getConnection();
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    public static void createStudentTable(){
        try {
            String query = "CREATE TABLE student(studentID INT PRIMARY KEY NOT NULL, name VARCHAR(255)," +
                    "surname VARCHAR(255), birthdate INT, studentNumber VARCHAR(30))";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            System.out.println("Student table has created successfully !");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally{
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        DBConnection.closeConnection();
    }
    public static void insertStudent(List<Student> listOfStudents){
        try {
            String query = "INSERT INTO student(studentID, name, surname, birthdate, studentNumber) VALUES(?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);
            for(Student student : listOfStudents){

                preparedStatement.setInt(1,student.getStudentID());
                preparedStatement.setString(2,student.getName());
                preparedStatement.setString(3,student.getSurname());
                preparedStatement.setInt(4,student.getBirthdate());
                preparedStatement.setString(5,student.getStudentNumber());

                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();
            System.out.println("Data inserted successfully ! ");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        DBConnection.closeConnection();
    }
    public static void updateStudent(Student student){
        try {
        String query = "UPDATE student SET name = ?, surname = ?, birthdate = ?, studentNumber = ? WHERE studentID = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getSurname());
            preparedStatement.setInt(3,student.getBirthdate());
            preparedStatement.setString(4,student.getStudentNumber());
            preparedStatement.setInt(5,student.getStudentID());

            preparedStatement.executeUpdate();
            System.out.println("Student update successfully !");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnection.closeConnection();
        }
    }
    public static void deleteStudent(Integer id){
        String query = "DELETE from student WHERE studentID = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            System.out.println("Student deleted from Database !");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnection.closeConnection();
        }

    }
    public static void findStudentByID(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student ID: ");
        int studentId = sc.nextInt();

        String query = "SELECT * FROM student WHERE studentID = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,studentId);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                Integer id = resultSet.getInt(1);
               String name = resultSet.getString(2);
               String surname = resultSet.getString(3);
               int birthdate = resultSet.getInt(4);
               String studentNumber = resultSet.getString(5);
                System.out.println(id + " " + name + " " + surname + " " + birthdate + " " + studentNumber );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnection.closeConnection();
        }
    }
    public static void findStudnetLikeName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a litte letter : ");
        String letter = sc.nextLine();

        String query = "SELECT * FROM student WHERE name LIKE '"+letter+"%'";

        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                String name = resultSet.getString(2);
                String surname = resultSet.getString(3);
                System.out.println(name + " " + surname);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnection.closeConnection();
        }
    }
}
