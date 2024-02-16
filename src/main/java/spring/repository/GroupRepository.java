package spring.repository;

import spring.model.Group;

import javax.persistence.Table;
import java.util.List;

public interface GroupRepository {
    List<Group> findAllGroup();

    Group findByIdGroup(Long id);

    void saveGroup(Group groups);

    void deleteGroup(Long id);

    void updateGroup(Long id, Group group);

    void clearGroup();

}