package com.emirates.University.model;
import java.util.*;
import org.springframework.stereotype.Component;
import java.util.Objects;
import javax.persistence.*;
 
@Entity
@Table(name = "eployee")
public class Eployee{
 
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
 
  @Column(name = "empname")
  private String   empname;
 
  @Column(name = "empdep")
  private String   empdep;
 
  @Column(name = "empadd")
  private String   empadd;
 
public  Eployee(){}
 
public Eployee( String empname, String empdep, String empadd){
     this.empname=empname;
     this.empdep=empdep;
     this.empadd=empadd;
  }
  public String getEmpname()
   {
     return empname;
  }
   
  public void setEmpname(String empname )
  {
     this.empname=empname;
  }
  public String getEmpdep()
   {
     return empdep;
  }
   
  public void setEmpdep(String empdep )
  {
     this.empdep=empdep;
  }
  public String getEmpadd()
   {
     return empadd;
  }
   
  public void setEmpadd(String empadd )
  {
     this.empadd=empadd;
  }
@Override 
public String toString() { 
 return "Eployee[id="+id+",empname="+empname+",empdep="+empdep+",empadd="+empadd+"]";
  }
}
