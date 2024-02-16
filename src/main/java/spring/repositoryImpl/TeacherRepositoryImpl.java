package spring.repositoryImpl;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import spring.model.Teacher;
import spring.repository.TeacherRepository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class TeacherRepositoryImpl implements TeacherRepository {
    private final SessionFactory sessionFactory;

    @Override
    public List<Teacher> findAllTeacher() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select t from Teacher t", Teacher.class).getResultList();
    }

    @Override
    public Teacher findByidTeacher(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Teacher.class, id);
    }

    @Override
    public void saveTeacher(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        session.save(teacher);
    }

    @Override
    public void deleteTeacher(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Teacher where id=" + id).executeUpdate();
    }

    @Override
    public void updateTeacher(Long id, Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        Teacher teacher1 = findByidTeacher(id);
        teacher1.setFirstName(teacher.getFirstName());
        teacher1.setLastName(teacher.getLastName());
        teacher1.setEmail(teacher.getEmail());
        session.merge(teacher1);
    }

    @Override
    public void clearTeacher() {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Teacher ").executeUpdate();
    }
}