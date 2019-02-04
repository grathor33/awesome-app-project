package eu.microwebservices.awesomeappproject.controller;

import eu.microwebservices.awesomeappproject.model.User;
import eu.microwebservices.awesomeappproject.model.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
   /**
    * HOW TO TEST:
    * $ mvn spring-boot:run
    * http://localhost:8080/
    * Use the following urls:
    *    /create-user?email=[email]&name=[name]:    create a new user with an auto-generated id and email and name as passed values.
    *    /delete-user?id=[id]:      delete the user with the passed id.
    *    /get-user-by-email?email=[email]:      retrieve the id for the user with the passed email address.
    *    /update-user?id=[id]&email=[email]&name=[name]:    update the email and the name for the user indentified by the passed id.
    */

  @Autowired
  private UserDao userDao;
  
  /**
   * /create-user  --> Create a new user and save it in the database.
   * It is not secure operation here! There is no validation here!  See https://www.owasp.org
   * It is only for REST educational purposes...
   * 
   * @param email User's email
   * @param name User's name
   * @return A string describing if the user is successfully created or not.
   */
  @RequestMapping("/create-user")
  @ResponseBody
  public String create(String email, String name) {
    User user = null;
    try {
      user = new User(email, name);
      userDao.save(user);
    }
    catch (Exception ex) {
      return "Error while creating the user: " + ex.toString();
    }
    return "User created succesfully!! (id = " + user.getId() + ")";
  }
  
  /**
   * /delete-user  --> Delete the user having the passed id.
   * It is not secure operation here! There is no validation here!
   * It is only for REST educational purposes...
   * 
   * @param id The id of the user to delete
   * @return A string describing if the user is successfully deleted or not.
   */
  @RequestMapping("/delete-user")
  @ResponseBody
  public String delete(Long id) {
    try {
      User user = new User(id);
      userDao.delete(user);
    }
    catch (Exception ex) {
      return "Error while deleting the user: " + ex.toString();
    }
    return "User deleted successfully!!";
  }
  
  /**
   * /get-user-by-email  --> Return the id for the user having the passed email.
   * It is not secure operation here! There is no validation here!
   * It is only for REST educational purposes...
   * 
   * @param email The email to search in the database.
   * @return The user id or a message error if the user is not found.
   */
  @RequestMapping("/get-user-by-email")
  @ResponseBody
  public String getByEmail(String email) {
    Long userId;
    try {
      User user = userDao.findByEmail(email);
      if (user != null) {
        userId = user.getId();
      } else {
        return "User not found!!";
      }
    }
    catch (Exception ex) {
      return "User not found!!";
    }
    return "The user is found, and id is: " + userId;
  }
  
  /**
   * /update-user  --> Update the email and the name for the user in the database 
   * having the passed id.
   * It is not secure operation here! There is no validation here!
   * It is only for REST educational purposes...
   * 
   * @param id The id for the user to update.
   * @param email The new email.
   * @param name The new name.
   * @return A string describing if the user is successfully updated or not.
   */
  @RequestMapping("/update-user")
  @ResponseBody
  public String updateUser(long id, String email, String name) {
    try {
      User user = userDao.findOne(id);
      user.setEmail(email);
      user.setName(name);
      userDao.save(user);
    }
    catch (Exception ex) {
      return "Error while updating the user: " + ex.toString();
    }
    return "User updated successfully!!";
  }
  
} 
