package   com.emirates.University.Imp;
import java.util.*;
import java.io.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import  com.project.generator.services.*;
import com.project.generator.model.*;
  import com.project.generator.repository.*;
 
 
@Component
public class DepartServiceImp implements DepartService{
 
 
      @Autowired
      public Departrepository  departrepository;
 
 
 
   public Depart createDepart( Depart depart)
    {
     Depart  departmdl=null;
     if(depart!=null)
     {
         departmdl=departrepository.save(depart);
     }
  return departmdl;
}


    public List<Depart> getDepartAll()
     {
   
         List<Depart> departmdl=new ArrayList<>();
              for(Depart departmdls:departrepository.findAll())
              {
                departmdl.add(departmdls);
               }
      return  departmdl;
      
      }
 
    public Depart getDepartById(long id)
     {
         Depart  departmdl=null;
               Optional<Depart>   departData =departrepository.findById(id);
              
                 if (departData.isPresent()) {  
                      departmdl=departData.get();
                      return departmdl;
                 }
        return null;
      
      }
  
   public Depart   updateDepart( Depart depart,long id)
    {
   
       Depart  departmdl=getDepartById(id);
       if(depart!=null)
       {
          departmdl.setDepname(depart.getDepname());
             departrepository.save(departmdl);
       }
   return   depart;
   }
 
   public Depart  deleteDepart( Depart depart)
  {
      Depart   departmdl=null;
           if(depart!=null)
           {
                departrepository.delete(depart);
 
                departmdl=depart;
           }
  return departmdl;
}
 
   public  void  deleteDepartById(long id)
   {
                departrepository.deleteById(id);
    }
 
 
}
