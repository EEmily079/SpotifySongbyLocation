package location.sample.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import location.sample.demo.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

   
   
    @Query("SELECT u.premium FROM User u WHERE u.id = :userId")
    boolean isUserPremium(@Param("userId") int userId);
   
 
}