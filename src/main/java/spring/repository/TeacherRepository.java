package spring.repository;

import spring.model.Teacher;

import java.util.List;

public interface TeacherRepository {
    List<Teacher> findAllTeacher();

    Teacher findByidTeacher(Long id);

    void saveTeacher(Teacher teacher);

    void deleteTeacher(Long id);

    void updateTeacher(Long id, Teacher teacher);

    void clearTeacher();
}