package pl.sda.finalapp.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Query("select r from Role r where r.roleName =?1")
    Optional<Role> findByRoleName(String roleName);
}
