package spring.repository;

import spring.model.Course;

import java.util.List;

public interface CourseRepository {
    List<Course> findAllCourse(Long id);

    Course findByIdCourse(Long id);

    void saveCourse(Course course);

    void deleteCourse(Long id);

    void updateCourse(Course course);

    void clearCourse(Long id);
}