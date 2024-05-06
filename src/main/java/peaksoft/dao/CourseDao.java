package peaksoft.dao;

import peaksoft.models.Course;



public interface CourseDao {

    void createTableCourse();

    String saveCourse(Course newCourse);

    Course getById(Long courseId);

    String updateCourse(Long courseId, Course newCourse);

    boolean deleteCourse(Long courseId);

    String groupCourseByName(String name);

    boolean getLongestCourse();

}
