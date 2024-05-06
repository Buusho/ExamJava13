package peaksoft.service;

import peaksoft.models.Course;

public interface CourseService {
    void createTableCourse();

    String saveCourse(Course newCourse);

    Course getById(Long courseId);

    String updateCourse(Long courseId, Course newCourse);

    void deleteCourse(Long courseId);

    String groupCourseByName(String name);

    void  getLongestCourse();
}
