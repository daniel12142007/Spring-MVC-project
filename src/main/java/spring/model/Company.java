package spring.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String locatedCountry;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Course> courses;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Group> groups;

    @Override
    public String toString() {
        return "Company{" +
               "id=" + id +
               ", companyName='" + companyName + '\'' +
               ", locatedCountry='" + locatedCountry + '\'' +
               '}';
    }
}