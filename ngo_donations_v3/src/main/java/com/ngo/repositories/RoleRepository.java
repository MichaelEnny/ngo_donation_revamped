package com.ngo.repositories;

import com.ngo.model.Role;
import com.ngo.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/* RoleRepository interface. It contains a single method to retrieve a Role from the RoleName-*/

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
