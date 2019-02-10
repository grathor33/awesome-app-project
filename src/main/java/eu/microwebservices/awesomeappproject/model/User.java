package eu.microwebservices.awesomeappproject.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tab_user")
public class User {

  @Id
  //@GeneratedValue(strategy = GenerationType.AUTO)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  /**
   * Sorry but, there is no validation here with email!
   * It is not secure because of no validation from user input! See https://www.owasp.org
   * It is only for educational purposes...
   */
  @NotNull
  private String email;
  
  /**
   * This is a name generally, which could be the nickname or the firstname,
   * but if the user prefer it could be last name...
   * There is no validation here!
   * It is only for educational purposes...
   */
  @NotNull
  private String name;
  
  public User() {
  }

  public User(Long id) { 
    this.id = id;
  }
  
  public User(String email, String name) {
    this.email = email;
    this.name = name;
  }
  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
  
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email=" + email +
                '}';
    }

}
 
