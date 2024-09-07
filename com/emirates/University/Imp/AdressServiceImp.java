package   com.emirates.University.Imp;
import java.util.*;
import java.io.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import  com.project.generator.services.*;
import com.project.generator.model.*;
  import com.project.generator.repository.*;
 
 
@Component
public class AdressServiceImp implements AdressService{
 
 
      @Autowired
      public Adressrepository  adressrepository;
 
 
 
   public Adress createAdress( Adress adress)
    {
     Adress  adressmdl=null;
     if(adress!=null)
     {
         adressmdl=adressrepository.save(adress);
     }
  return adressmdl;
}


    public List<Adress> getAdressAll()
     {
   
         List<Adress> adressmdl=new ArrayList<>();
              for(Adress adressmdls:adressrepository.findAll())
              {
                adressmdl.add(adressmdls);
               }
      return  adressmdl;
      
      }
 
    public Adress getAdressById(long id)
     {
         Adress  adressmdl=null;
               Optional<Adress>   adressData =adressrepository.findById(id);
              
                 if (adressData.isPresent()) {  
                      adressmdl=adressData.get();
                      return adressmdl;
                 }
        return null;
      
      }
  
   public Adress   updateAdress( Adress adress,long id)
    {
   
       Adress  adressmdl=getAdressById(id);
       if(adress!=null)
       {
          adressmdl.setAddress(adress.getAddress());
             adressrepository.save(adressmdl);
       }
   return   adress;
   }
 
   public Adress  deleteAdress( Adress adress)
  {
      Adress   adressmdl=null;
           if(adress!=null)
           {
                adressrepository.delete(adress);
 
                adressmdl=adress;
           }
  return adressmdl;
}
 
   public  void  deleteAdressById(long id)
   {
                adressrepository.deleteById(id);
    }
 
 
}
