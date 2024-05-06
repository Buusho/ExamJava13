package peaksoft.service.impl;

import peaksoft.dao.CourseDao;
import peaksoft.dao.impl.CourseDaoImpl;
import peaksoft.models.Course;

public class CourseServiceImpl implements CourseDao {
    private  final CourseDao courseDao = new CourseDaoImpl();
    @Override
    public void createTableCourse() {
        courseDao.createTableCourse();
    }

    @Override
    public String saveCourse(Course newCourse) {
        return courseDao.saveCourse(newCourse);
    }

    @Override
    public Course getById(Long courseId) {
        return courseDao.getById(courseId);
    }

    @Override
    public String updateCourse(Long courseId, Course newCourse) {
        return courseDao.updateCourse(courseId,newCourse);
    }

    @Override
    public boolean deleteCourse(Long courseId) {
courseDao.deleteCourse(courseId);
        return false;
    }

    @Override
    public String groupCourseByName(String name) {
        return courseDao.groupCourseByName(name);
    }

    @Override
    public boolean getLongestCourse() {
courseDao.getLongestCourse();
        return false;
    }
}
