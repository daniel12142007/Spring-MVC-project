package spring.repository;

import spring.model.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAllStudent();

    Student findByidStudent(Long id);

    void saveStudent(Student student);

    void deleteStudent(Long id);

    void updateStudent(Long id, Student student);

    void clearStudent();
}