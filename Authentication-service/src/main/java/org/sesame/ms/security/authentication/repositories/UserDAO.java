package org.sesame.ms.security.authentication.repositories;

import org.sesame.ms.security.authentication.models.DAOUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<DAOUser, Long> {
    Optional<DAOUser> findByEmail(String email);

}
