package  com.emirates.University.rest;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import com.project.generator.model.*;
import com.project.generator.services.*;
import   com.project.generator.services.Imp.*;
 
 
 @RestController
 @RequestMapping("/api")
 @CrossOrigin(origins ="*")
 public class Departcontroller{
 
 
      @Autowired
      public DepartService  departservice;
 
 
 
   @PostMapping("/depart/create")
   public ResponseEntity<Depart>  createDepart(@RequestBody Depart depart)
    {
      try { 
          Depart departmdl=null;
              if(depart!=null)
               {
                  departmdl=departservice.createDepart(depart);
  
                }
                return new  ResponseEntity<>(departmdl,HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
     }
  
    @GetMapping("/depart/data")
    public ResponseEntity<List<Depart>>  getDepart()
     {
      try {
               List<Depart> departmdl=departservice.getDepartAll();
           
                return new  ResponseEntity<>(departmdl,HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
     }
  
    @GetMapping("/depart/data/{id}")
    public ResponseEntity<Depart>  getDepartById(@PathVariable("id") long id)
     {
      try {
               Depart departmdl=departservice.getDepartById(id);
                return new  ResponseEntity<>(departmdl,HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
     }
  
   @PutMapping("/depart/update/{id}")
   public ResponseEntity<Depart>  updateDepart(@PathVariable("id") long id, @RequestBody Depart depart)
      {
        
         Depart	departmdl=null;
              if(depart!=null)
              {
                 departmdl=departservice.updateDepart(depart,id);
                  return  new   ResponseEntity<>(departmdl,HttpStatus.OK);
               }else{
                  return  new   ResponseEntity<>(departmdl,HttpStatus.NOT_FOUND);
             }
}
  
   @PutMapping("/depart/update/{id}")
   public ResponseEntity<Depart>  updateDepart(@PathVariable("id") long id, @RequestBody Depart depart)
      {
        
         Depart	departmdl=null;
              if(depart!=null)
              {
                 departmdl=departservice.updateDepart(depart,id);
                  return  new   ResponseEntity<>(departmdl,HttpStatus.OK);
               }else{
                  return  new   ResponseEntity<>(departmdl,HttpStatus.NOT_FOUND);
             }
}
  
   @PutMapping("/depart/update/{id}")
   public ResponseEntity<Depart>  updateDepart(@PathVariable("id") long id, @RequestBody Depart depart)
      {
        
         Depart	departmdl=null;
              if(depart!=null)
              {
                 departmdl=departservice.updateDepart(depart,id);
                  return  new   ResponseEntity<>(departmdl,HttpStatus.OK);
               }else{
                  return  new   ResponseEntity<>(departmdl,HttpStatus.NOT_FOUND);
             }
}
 
 
}
