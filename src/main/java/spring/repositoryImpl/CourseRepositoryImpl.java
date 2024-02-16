package spring.repositoryImpl;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import spring.model.Course;
import spring.repository.CourseRepository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class CourseRepositoryImpl implements CourseRepository {
    private final SessionFactory sessionFactory;

    @Override
    public List<Course> findAllCourse(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select cour from Course cour where cour.company.id = :id", Course.class).setParameter("id", id).getResultList();
    }

    @Override
    public Course findByIdCourse(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Course.class, id);
    }

    @Override
    public void saveCourse(Course course) {
        Session session = sessionFactory.getCurrentSession();
        session.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Course course = findByIdCourse(id);
        session.delete(course);
    }

    @Override
    public void updateCourse(Course course) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(course);
    }

    @Override
    public void clearCourse(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Course course where course.company.id = :id").setParameter("id", id).executeUpdate();
    }
}