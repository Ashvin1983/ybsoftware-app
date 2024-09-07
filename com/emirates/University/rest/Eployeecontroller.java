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
 public class Eployeecontroller{
 
 
      @Autowired
      public EployeeService  eployeeservice;
 
 
 
   @PostMapping("/eployee/create")
   public ResponseEntity<Eployee>  createEployee(@RequestBody Eployee eployee)
    {
      try { 
          Eployee eployeemdl=null;
              if(eployee!=null)
               {
                  eployeemdl=eployeeservice.createEployee(eployee);
  
                }
                return new  ResponseEntity<>(eployeemdl,HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
     }
  
    @GetMapping("/eployee/data")
    public ResponseEntity<List<Eployee>>  getEployee()
     {
      try {
               List<Eployee> eployeemdl=eployeeservice.getEployeeAll();
           
                return new  ResponseEntity<>(eployeemdl,HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
     }
  
    @GetMapping("/eployee/data/{id}")
    public ResponseEntity<Eployee>  getEployeeById(@PathVariable("id") long id)
     {
      try {
               Eployee eployeemdl=eployeeservice.getEployeeById(id);
                return new  ResponseEntity<>(eployeemdl,HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
     }
  
   @PutMapping("/eployee/update/{id}")
   public ResponseEntity<Eployee>  updateEployee(@PathVariable("id") long id, @RequestBody Eployee eployee)
      {
        
         Eployee	eployeemdl=null;
              if(eployee!=null)
              {
                 eployeemdl=eployeeservice.updateEployee(eployee,id);
                  return  new   ResponseEntity<>(eployeemdl,HttpStatus.OK);
               }else{
                  return  new   ResponseEntity<>(eployeemdl,HttpStatus.NOT_FOUND);
             }
}
  
   @PutMapping("/eployee/update/{id}")
   public ResponseEntity<Eployee>  updateEployee(@PathVariable("id") long id, @RequestBody Eployee eployee)
      {
        
         Eployee	eployeemdl=null;
              if(eployee!=null)
              {
                 eployeemdl=eployeeservice.updateEployee(eployee,id);
                  return  new   ResponseEntity<>(eployeemdl,HttpStatus.OK);
               }else{
                  return  new   ResponseEntity<>(eployeemdl,HttpStatus.NOT_FOUND);
             }
}
  
   @PutMapping("/eployee/update/{id}")
   public ResponseEntity<Eployee>  updateEployee(@PathVariable("id") long id, @RequestBody Eployee eployee)
      {
        
         Eployee	eployeemdl=null;
              if(eployee!=null)
              {
                 eployeemdl=eployeeservice.updateEployee(eployee,id);
                  return  new   ResponseEntity<>(eployeemdl,HttpStatus.OK);
               }else{
                  return  new   ResponseEntity<>(eployeemdl,HttpStatus.NOT_FOUND);
             }
}
 
 
}
