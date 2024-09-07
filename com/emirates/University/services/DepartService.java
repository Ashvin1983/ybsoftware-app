package com.emirates.University.services;
import java.util.*;
import org.springframework.stereotype.*;
import com.project.generator.model.*;
 
 
@Service
@Component
public interface  DepartService{
 
 
 
   public Depart createDepart( Depart depart);
 
    public List<Depart> getDepartAll();
 
    public Depart getDepartById(long id);
 
   public Depart updateDepart( Depart depart,long id);
  
   public Depart deleteDepart( Depart depart);
 
    public void deleteDepartById(long id);
 
 
}
