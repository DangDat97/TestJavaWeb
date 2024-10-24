package naxusjavaweb.web.service;

import naxusjavaweb.web.entity.Role;
import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<Role> getAllRoles();

    Optional<Role> getRoleById(int id);

    Role saveRole(Role role);

    void deleteRole(int id);

    Optional<Role> getRoleByName(String name);
}