package org.sesame.ms.security.authentication.repositories;

import org.sesame.ms.security.authentication.models.Logs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

public interface LogsRepository extends JpaRepository <Logs, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE users SET failedattempt = :failedattempt WHERE email = :email ",nativeQuery = true)
    Integer updateFailedAttempts(@Param("email") String email, @Param("failedattempt") int failedattempt);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update users set locked=:islocked where email=:email",nativeQuery = true)
    Integer lockOrUnlockUser(@Param("email") String email, @Param("islocked") Boolean islocked);


    @Query(value = "select failedattempt from users WHERE email = :name ",nativeQuery = true)
    Integer getFailedAttempts(@Param("name") String name);
    
    @Query(value = "select locked from users WHERE email=:email ",nativeQuery = true)
    Boolean getIsUserLocked(@Param("email") String email);
    
    @Query(value = "select status from users WHERE email = :name ",nativeQuery = true)
    String getUserStatus(@Param("name") String name);
   






}
