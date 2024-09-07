package  com.emirates.cat360.rest;
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
 public class Adresscontroller{
 
 
      @Autowired
      public AdressService  adressservice;
 
 
 
   @PostMapping("/adress/create")
   public ResponseEntity<Adress>  createAdress(@RequestBody Adress adress)
    {
      try { 
          Adress adressmdl=null;
              if(adress!=null)
               {
                  adressmdl=adressservice.createAdress(adress);
  
                }
                return new  ResponseEntity<>(adressmdl,HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
     }
  
    @GetMapping("/adress/data")
    public ResponseEntity<List<Adress>>  getAdress()
     {
      try {
               List<Adress> adressmdl=adressservice.getAdressAll();
           
                return new  ResponseEntity<>(adressmdl,HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
     }
  
    @GetMapping("/adress/data/{id}")
    public ResponseEntity<Adress>  getAdressById(@PathVariable("id") long id)
     {
      try {
               Adress adressmdl=adressservice.getAdressById(id);
                return new  ResponseEntity<>(adressmdl,HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
     }
  
   @PutMapping("/adress/update/{id}")
   public ResponseEntity<Adress>  updateAdress(@PathVariable("id") long id, @RequestBody Adress adress)
      {
        
         Adress	adressmdl=null;
              if(adress!=null)
              {
                 adressmdl=adressservice.updateAdress(adress,id);
                  return  new   ResponseEntity<>(adressmdl,HttpStatus.OK);
               }else{
                  return  new   ResponseEntity<>(adressmdl,HttpStatus.NOT_FOUND);
             }
}
  
   @PutMapping("/adress/update/{id}")
   public ResponseEntity<Adress>  updateAdress(@PathVariable("id") long id, @RequestBody Adress adress)
      {
        
         Adress	adressmdl=null;
              if(adress!=null)
              {
                 adressmdl=adressservice.updateAdress(adress,id);
                  return  new   ResponseEntity<>(adressmdl,HttpStatus.OK);
               }else{
                  return  new   ResponseEntity<>(adressmdl,HttpStatus.NOT_FOUND);
             }
}
  
   @PutMapping("/adress/update/{id}")
   public ResponseEntity<Adress>  updateAdress(@PathVariable("id") long id, @RequestBody Adress adress)
      {
        
         Adress	adressmdl=null;
              if(adress!=null)
              {
                 adressmdl=adressservice.updateAdress(adress,id);
                  return  new   ResponseEntity<>(adressmdl,HttpStatus.OK);
               }else{
                  return  new   ResponseEntity<>(adressmdl,HttpStatus.NOT_FOUND);
             }
}
 
 
}
