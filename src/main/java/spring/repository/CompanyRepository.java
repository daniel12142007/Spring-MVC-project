package spring.repository;

import spring.model.Company;

import java.util.List;

public interface CompanyRepository {
    List<Company> findAllCompany();

    Company findByIdCompany(Long id);

    int countName(String name);

    void saveCompany(Company company);

    void deleteCompany(Long id);

    void updateCompany(Company company);

    void clearCompany();
}