package peaksoft.dao.impl;

import peaksoft.JDBCConfig.JDBCconfig;
import peaksoft.dao.CourseDao;
import peaksoft.models.Course;

import java.sql.*;

public class CourseDaoImpl implements CourseDao {
    private final Connection connection = JDBCconfig.getConnection();
    @Override
    public void createTableCourse() {
        String sql = """
                create table if not exists courses (
                id serial primary key ,
                name varchar ,
                description varchar,
                duration int
                )
                """;
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String saveCourse(Course newCourse) {
        String sql = """
                insert into courses (name , description , duration )
                values (?,?,?)
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1 , newCourse.getName());
            preparedStatement.setString(2, newCourse.getDescription());
            preparedStatement.setInt(3,newCourse.getDuration());
            preparedStatement.executeUpdate();
            return "Success !";
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return "failed";
    }

    @Override
    public Course getById(Long courseId) {
        Course course = new Course();
        String sql = """
                select * from courses where id = ?
                """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1,courseId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                course.setId(resultSet.getLong("id"));
                course.setName(resultSet.getString("name"));
                course.setDescription(resultSet.getString("description"));
                course.setDuration(resultSet.getInt("duration"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return course;
    }

    @Override
    public String updateCourse(Long courseId, Course newCourse) {
        String query = """
                update courses
                set name = ?,
                description = ?,
                duration = ?
                where id = ?
                """;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, newCourse.getName());
            preparedStatement.setString(2, newCourse.getDescription());
            preparedStatement.setInt(3,newCourse.getDuration());
            preparedStatement.setLong(4, courseId);
         preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return "Success !";
    }
    @Override
    public String groupCourseByName(String name) {
        String sql = """
            select name from courses where name = ? group by name
            """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String courseName = resultSet.getString("name");
                System.out.println(courseName);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "Success !";
    }

    @Override
    public boolean deleteCourse(Long courseId) {

        String sql = "delete from courses where id =?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1,courseId) ;
            int deleteAuthor = preparedStatement.executeUpdate();
            if (deleteAuthor>0){
                System.out.println("Successfully deleted");
            }else System.out.println("Courses id not found!");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return false;
    }



    @Override
    public boolean getLongestCourse() {
String sql = """
        select max(duration) from courses
        """;
try{
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(sql);
    if (resultSet.next()) {
        int maxDuration = resultSet.getInt("max");
        System.out.println("Longest course duration: " + maxDuration );
    } else {
        System.out.println("No found");
    }
}catch (SQLException e ){
    System.out.println(e.getMessage());
}

        return false;
    }
}
