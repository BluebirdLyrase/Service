/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author STD-PC
 */
@RestController
public class GreetingController {
    
    private static final String template = "Hello, %s!";///%s will be replace with name
    private final AtomicLong counter = new AtomicLong();
    @CrossOrigin///this will allow all to use service
//    @CrossOrigin(origins = "http://127.0.0.1:8081")///this will allow http://127.0.0.1:8081 to use service
//    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World")String name){
       return new Greeting(counter.incrementAndGet(),
                           String.format(template,name));
    }
    
    @CrossOrigin
    @RequestMapping("/SQL")
    public List<appData> sql(){
        SQL sql = new SQL();
       return sql.findAll();
    }
}
