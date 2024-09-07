package   com.emirates.University.Imp;
import java.util.*;
import java.io.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import  com.project.generator.services.*;
import com.project.generator.model.*;
  import com.project.generator.repository.*;
 
 
@Component
public class EployeeServiceImp implements EployeeService{
 
 
      @Autowired
      public Eployeerepository  eployeerepository;
 
 
 
   public Eployee createEployee( Eployee eployee)
    {
     Eployee  eployeemdl=null;
     if(eployee!=null)
     {
         eployeemdl=eployeerepository.save(eployee);
     }
  return eployeemdl;
}


    public List<Eployee> getEployeeAll()
     {
   
         List<Eployee> eployeemdl=new ArrayList<>();
              for(Eployee eployeemdls:eployeerepository.findAll())
              {
                eployeemdl.add(eployeemdls);
               }
      return  eployeemdl;
      
      }
 
    public Eployee getEployeeById(long id)
     {
         Eployee  eployeemdl=null;
               Optional<Eployee>   eployeeData =eployeerepository.findById(id);
              
                 if (eployeeData.isPresent()) {  
                      eployeemdl=eployeeData.get();
                      return eployeemdl;
                 }
        return null;
      
      }
  
   public Eployee   updateEployee( Eployee eployee,long id)
    {
   
       Eployee  eployeemdl=getEployeeById(id);
       if(eployee!=null)
       {
          eployeemdl.setEmpname(eployee.getEmpname());
          eployeemdl.setEmpdep(eployee.getEmpdep());
          eployeemdl.setEmpadd(eployee.getEmpadd());
             eployeerepository.save(eployeemdl);
       }
   return   eployee;
   }
 
   public Eployee  deleteEployee( Eployee eployee)
  {
      Eployee   eployeemdl=null;
           if(eployee!=null)
           {
                eployeerepository.delete(eployee);
 
                eployeemdl=eployee;
           }
  return eployeemdl;
}
 
   public  void  deleteEployeeById(long id)
   {
                eployeerepository.deleteById(id);
    }
 
 
}
