package spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.model.Course;
import spring.repository.CompanyRepository;
import spring.repository.CourseRepository;

@Controller
@RequiredArgsConstructor
@RequestMapping("course/controller")
public class CourseController {
    private final CourseRepository courseRepository;
    private final CompanyRepository companyRepository;

    @GetMapping("{id}")
    public String menu(@PathVariable Long id,
                       Model model) {
        model.addAttribute("courses", courseRepository.findAllCourse(id));
        model.addAttribute("id", id);
        return "courseTable";
    }

    @GetMapping("form/{id}")
    public String companyForm(@PathVariable Long id,
                              Model model) {
        model.addAttribute("id", id);
        return "courseForm";
    }

    @PostMapping("save/{id}")
    public String companySave(
            @PathVariable Long id,
            @RequestParam("name") String name,
            @RequestParam("duration") String duration,
            Model model
    ) {
        if (name.isEmpty() && duration.isEmpty()) {
            check("title", "400", model);
            check("description", "Вы не заполнили все поля", model);
            return "error";
        }
        courseRepository.saveCourse(Course.builder()
                .courseName(name)
                .duration(duration)
                .company(companyRepository.findByIdCompany(id))
                .build()
        );
        return "redirect:/course/controller/" + id;
    }

    @GetMapping("delete/{id}/{comId}")
    public String deleteByIdCompany(@PathVariable Long comId,
                                    @PathVariable Long id) {
        courseRepository.deleteCourse(id);
        return "redirect:/course/controller/" + comId;
    }

    @GetMapping("clear/{id}")
    public String clear(@PathVariable Long id) {
        courseRepository.clearCourse(id);
        return "redirect:/course/controller/" + id;
    }

    @GetMapping("update/form/{id}/{comId}")
    public String updateFormCompany(@PathVariable Long comId,
                                    @PathVariable Long id,
                                    Model model) {
        model.addAttribute("update", courseRepository.findByIdCourse(id));
        model.addAttribute("id", comId);
        return "courseUpdate";
    }

    @PostMapping("update/{id}/{comId}")
    public String updateCompany(@RequestParam("name") String name,
                                @RequestParam("duration") String duration,
                                @PathVariable Long id,
                                @PathVariable Long comId,
                                Model model) {
        Course course = courseRepository.findByIdCourse(id);
        if (name.isEmpty() && duration.isEmpty()) {
            check("title", "400", model);
            check("description", "Вы не заполнили все поля", model);
            return "error";
        }
        course.setCourseName(name);
        course.setDuration(duration);
        courseRepository.updateCourse(course);
        return "redirect:/course/controller/" + comId;
    }

    private void check(String name, String description, Model model) {
        model.addAttribute(name, description);
    }
}