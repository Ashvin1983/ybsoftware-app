package com.emirates.University.model;
import java.util.*;
import org.springframework.stereotype.Component;
import java.util.Objects;
import javax.persistence.*;
 
@Entity
@Table(name = "depart")
public class Depart{
 
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
 
  @Column(name = "depname")
  private String   depname;
 
public  Depart(){}
 
public Depart( String depname){
     this.depname=depname;
  }
  public String getDepname()
   {
     return depname;
  }
   
  public void setDepname(String depname )
  {
     this.depname=depname;
  }
@Override 
public String toString() { 
 return "Depart[id="+id+",depname="+depname+"]";
  }
}
