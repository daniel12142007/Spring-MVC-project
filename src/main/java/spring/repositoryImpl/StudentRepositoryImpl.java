package spring.repositoryImpl;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import spring.model.Student;
import spring.repository.StudentRepository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class StudentRepositoryImpl implements StudentRepository {
    private final SessionFactory sessionFactory;

    @Override
    public List<Student> findAllStudent() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select s from Student s", Student.class).getResultList();
    }

    @Override
    public Student findByidStudent(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);
    }

    @Override
    public void saveStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Student where id=" + id).executeUpdate();
    }

    @Override
    public void updateStudent(Long id, Student student) {
        Session session = sessionFactory.getCurrentSession();
        Student student1 = findByidStudent(id);
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setEmail(student.getEmail());
        student1.setFormat(student.getFormat());
        session.merge(student1);
    }

    @Override
    public void clearStudent() {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Student ").executeUpdate();
    }
}