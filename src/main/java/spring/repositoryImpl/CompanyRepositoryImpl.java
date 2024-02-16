package spring.repositoryImpl;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import spring.model.Company;
import spring.repository.CompanyRepository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class CompanyRepositoryImpl implements CompanyRepository {

    private final SessionFactory sessionFactory;

    @Override
    public List<Company> findAllCompany() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select c from Company c", Company.class).getResultList();
    }

    @Override
    public Company findByIdCompany(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Company.class, id);
    }

    @Override
    public int countName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Long num = (Long) session.createQuery("select count(c) from Company c where c.companyName = :name").setParameter("name", name).getSingleResult();
        return num.intValue();
    }

    @Override
    public void saveCompany(Company ompany) {
        Session session = sessionFactory.getCurrentSession();
        session.save(ompany);
    }

    @Override
    public void deleteCompany(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Company company = findByIdCompany(id);
        session.delete(company);
    }

    @Override
    public void updateCompany(Company company) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(company);
    }

    @Override
    public void clearCompany() {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Company company").executeUpdate();
    }
}