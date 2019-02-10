package eu.microwebservices.awesomeappproject.model;

import org.springframework.data.repository.*;
import org.springframework.transaction.annotation.*;

@Transactional
public interface BookDao extends CrudRepository<Book, Long> {

  /**
   * This method will find an Book instance in the database by its name.
   * Note that this method is not implemented and its working code will be
   * automagically generated from its signature by Spring Data JPA.
   */
  public Book findByName(String name);

}
