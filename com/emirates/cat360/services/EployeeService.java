package com.emirates.cat360.services;
import java.util.*;
import org.springframework.stereotype.*;
import com.project.generator.model.*;
 
 
@Service
@Component
public interface  EployeeService{
 
 
 
   public Eployee createEployee( Eployee eployee);
 
    public List<Eployee> getEployeeAll();
 
    public Eployee getEployeeById(long id);
 
   public Eployee updateEployee( Eployee eployee,long id);
  
   public Eployee deleteEployee( Eployee eployee);
 
    public void deleteEployeeById(long id);
 
 
}
