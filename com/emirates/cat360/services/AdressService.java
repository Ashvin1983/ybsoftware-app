package com.emirates.cat360.services;
import java.util.*;
import org.springframework.stereotype.*;
import com.project.generator.model.*;
 
 
@Service
@Component
public interface  AdressService{
 
 
 
   public Adress createAdress( Adress adress);
 
    public List<Adress> getAdressAll();
 
    public Adress getAdressById(long id);
 
   public Adress updateAdress( Adress adress,long id);
  
   public Adress deleteAdress( Adress adress);
 
    public void deleteAdressById(long id);
 
 
}
