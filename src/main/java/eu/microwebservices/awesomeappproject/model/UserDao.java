package eu.microwebservices.awesomeappproject.model;

import org.springframework.data.repository.*;
import org.springframework.transaction.annotation.*;

@Transactional
public interface UserDao extends CrudRepository<User, Long> {

  /**
   * This method will find an User instance in the database by its email.
   * Note that this method is not implemented and its working code will be
   * automagically generated from its signature by Spring Data JPA.
   */
  public User findByEmail(String email);
  
    /**
   * This method will find an User instance in the database by its name.
   * Note that this method is not implemented and its working code will be
   * automagically generated from its signature by Spring Data JPA.
   */
  public User findByName(String name);

}
