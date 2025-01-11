package net.custom.rentals.management.repository;

import net.custom.rentals.management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import java.time.LocalDateTime;
//import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
	
	User findByUsernameOrEmail(String username, String email);
	/**
    Optional<User> findByEmail(String email);
    
    List<User> findByRole(String role);

    List<User> findByCreatedAtAfter(LocalDateTime date);

    List<User> findByLastLoginAfter(LocalDateTime date);

    List<User> findByUsernameContaining(String partialUsername);

    List<User> findByEmailContaining(String partialEmail);

    List<User> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);

    @Query("SELECT u FROM User u WHERE u.username = :username AND u.active = true")
    Optional<User> findByUsernameAndActive(@Param("username") String username);

    boolean existsByUsername(String username);
    
    boolean existsByEmail(String email);

    @Modifying
    @Query("UPDATE User u SET u.password = :password WHERE u.email = :email")
    void updatePasswordByEmail(@Param("email") String email, @Param("password") String password);
	**/
    void deleteByUsername(String username);
    
    void deleteByEmail(String email);

    // long countByActiveTrue();
}
