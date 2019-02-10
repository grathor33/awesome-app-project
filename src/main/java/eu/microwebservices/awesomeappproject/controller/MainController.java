package eu.microwebservices.awesomeappproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Hello World! This is welcome page of Awesome App Demo! " +
           "<a href='http://www.microwebservices.eu'>microwebservices.eu</a> :)";
    }
  
  	@RequestMapping("/en")
  	@ResponseBody
	public String home() {
        return "Hello World! This is Awesome App Demo here! " +
           "<a href='http://www.microwebservices.eu/en'>microwebservices.eu</a> :)";
	}

}
