package spring.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private String duration;

    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany(
            mappedBy = "courses",
            cascade = CascadeType.ALL)
    private List<Group> groups;

    @Override
    public String toString() {
        return "Course{" +
               "id=" + id +
               ", courseName='" + courseName + '\'' +
               ", duration='" + duration + '\'' +
               '}';
    }
}