/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import hello.bean.*;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author STD-PC
 */
@RestController
public class Controller {
    
    
    SQL sql = new SQL();
    
    @CrossOrigin
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public  @ResponseBody List<appDatamin> search(@RequestBody searchData data){
    return sql.search(data.getQuery(),data.getQname());
}
    
   @CrossOrigin
    @RequestMapping(value = "/findOne/{id}",method = RequestMethod.GET)
    public List<appData> findOne(@PathVariable("id") String id
    ){
       return sql.findOne(id);
    }
    
    @CrossOrigin
    @RequestMapping(value = "/content_rating",method = RequestMethod.GET)
    public List<content_rating> content_rating(){
       return sql.content_rating();
    }
    

    
    @CrossOrigin
    @RequestMapping(value = "/categoryList",method = RequestMethod.GET)
    public List<categoryList> categoryList(){
       return sql.categoryList();
    }
    
    @CrossOrigin
    @RequestMapping(value = "/installs",method = RequestMethod.GET)
    public List<installs> installs(){
       return sql.installs();
    }
    
    @CrossOrigin
    @RequestMapping(value = "/Review/{id}",method = RequestMethod.GET)
    public List<review> Review(@PathVariable("id") String id){
       return sql.review(id);
    }
    

}
