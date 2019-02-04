package eu.microwebservices.awesomeappproject.controller;

import eu.microwebservices.awesomeappproject.model.Book;
import eu.microwebservices.awesomeappproject.model.BookDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {
   /**
    * HOW TO TEST:
    * $ mvn spring-boot:run
    * http://localhost:8080/
    * Use the following urls:
    *    /create-book?name=[name]&price=[price]:    create a new book with an auto-generated id and price and name as passed values.
    *    /delete-book?id=[id]:      delete the book with the passed id.
    *    /update-book?id=[id]&email=[email]&name=[name]:    update the price and the name for the book indentified by the passed id.
    */

  @Autowired
  private BookDao bookDao;
  
  /**
   * /create-book  --> Create a new book and save it in the database.
   * It is not secure operation here! There is no validation here!  See https://www.owasp.org
   * It is only for REST educational purposes...
   * 
   * @param name Book's name
   * @param price Book's price
   * @return A string describing if the book is successfully created or not.
   */
  @RequestMapping("/create-book")
  @ResponseBody
  public String create(String name, Double price) {
    Book book = null;
    try {
      book = new Book(name, price);
      bookDao.save(book);
    }
    catch (Exception ex) {
      return "Error while creating the book: " + ex.toString();
    }
    return "User created succesfully!! (id = " + book.getId() + ")";
  }
  
  /**
   * /delete-book  --> Delete the book having the passed id.
   * It is not secure operation here! There is no validation here!
   * It is only for REST educational purposes...
   * 
   * @param id The id of the book to delete
   * @return A string describing if the book is successfully deleted or not.
   */
  @RequestMapping("/delete-book")
  @ResponseBody
  public String delete(Long id) {
    try {
      Book book = new Book(id);
      bookDao.delete(book);
    }
    catch (Exception ex) {
      return "Error while deleting the book: " + ex.toString();
    }
    return "Book deleted successfully!!";
  }
  
  /**
   * /update-book  --> Update the price and the name for the book in the database 
   * having the passed id.
   * It is not secure operation here! There is no validation here!
   * It is only for REST educational purposes...
   * 
   * @param id The id for the book to update.
   * @param name The new name.
   * @param price The new price.
   * @return A string describing if the book is successfully updated or not.
   */
  @RequestMapping("/update-book")
  @ResponseBody
  public String updateBook(long id, String name, Double price) {
    try {
      Book book = bookDao.findOne(id);
      book.setName(name);
      book.setPrice(price);
      bookDao.save(book);
    }
    catch (Exception ex) {
      return "Error while updating the book: " + ex.toString();
    }
    return "Book updated successfully!!";
  }
  
} 
