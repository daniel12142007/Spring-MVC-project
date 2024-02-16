package spring.repositoryImpl;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import spring.model.Group;
import spring.repository.GroupRepository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class GroupRepositoryImpl implements GroupRepository {
    private final SessionFactory sessionFactory;

    @Override
    public List<Group> findAllGroup() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select g from Groups g", Group.class).getResultList();
    }

    @Override
    public Group findByIdGroup(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Group.class, id);
    }

    @Override
    public void saveGroup(Group group) {
        Session session = sessionFactory.getCurrentSession();
        session.save(group);
    }

    @Override
    public void deleteGroup(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Group group = findByIdGroup(id);
        session.delete(group);
    }

    @Override
    public void updateGroup(Long id, Group group) {
        Session session = sessionFactory.getCurrentSession();
        Group group1 = findByIdGroup(id);
        group1.setGroupName(group.getGroupName());
        group1.setDataStart(group.getDataStart());
        group1.setDataFinish(group.getDataFinish());
        session.merge(group1);
    }

    @Override
    public void clearGroup() {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Groups ").executeUpdate();
    }
}