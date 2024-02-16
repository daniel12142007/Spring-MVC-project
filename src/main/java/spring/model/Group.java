package spring.model;

import lombok.*;


import javax.persistence.*;
import java.util.List;

@Entity(name = "Groups")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String groupName;
    private String dataStart;
    private String dataFinish;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Student> students;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany
    @JoinTable(name = "course_group",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;

    @Override
    public String toString() {
        return "Group{" +
               "id=" + id +
               ", groupName='" + groupName + '\'' +
               ", dataStart='" + dataStart + '\'' +
               ", dataFinish='" + dataFinish + '\'' +
               '}';
    }
}