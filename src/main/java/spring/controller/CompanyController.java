package spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.model.Company;
import spring.repository.CompanyRepository;

@Controller
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyRepository companyRepository;

    @GetMapping
    public String menu(Model model) {
        model.addAttribute("companies", companyRepository.findAllCompany());
        return "companyTable";
    }

    @GetMapping("form")
    public String companyForm() {
        return "companyForm";
    }

    @PostMapping("save")
    public String companySave(
            @RequestParam("name") String name,
            @RequestParam("located") String located,
            Model model
    ) {
        if (name.isEmpty() && located.isEmpty()) {
            check("title", "400", model);
            check("description", "Вы не заполнили все поля", model);
            return "error";
        }
        if (companyRepository.countName(name) != 0) {
            check("title", "409", model);
            check("description", "Такая компания уже существует", model);
            return "error";
        }
        companyRepository.saveCompany(Company.builder()
                .companyName(name)
                .locatedCountry(located)
                .build()
        );
        return "redirect:/";
    }

    @GetMapping("delete/{id}")
    public String deleteByIdCompany(@PathVariable Long id) {
        companyRepository.deleteCompany(id);
        return "redirect:/";
    }

    @GetMapping("clear")
    public String clear() {
        companyRepository.clearCompany();
        return "redirect:/";
    }

    @GetMapping("update/form/{id}")
    public String updateFormCompany(@PathVariable Long id,
                                    Model model) {
        model.addAttribute("update", companyRepository.findByIdCompany(id));
        return "companyUpdate";
    }

    @PostMapping("update/{id}")
    public String updateCompany(@RequestParam String name,
                                @RequestParam String located,
                                @PathVariable Long id,
                                Model model) {
        Company company = companyRepository.findByIdCompany(id);
        if (name.isEmpty() && located.isEmpty()) {
            check("title", "400", model);
            check("description", "Вы не заполнили все поля", model);
            return "error";
        }
        if (companyRepository.countName(name) != 0 && !company.getCompanyName().equals(name)) {
            check("title", "409", model);
            check("description", "Такая компания уже существует", model);
            return "error";
        }
        company.setCompanyName(name);
        company.setLocatedCountry(located);
        companyRepository.updateCompany(company);
        return "redirect:/";
    }

    private void check(String name, String description, Model model) {
        model.addAttribute(name, description);
    }
}