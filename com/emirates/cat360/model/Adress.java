package com.emirates.cat360.model;
import java.util.*;
import org.springframework.stereotype.Component;
import java.util.Objects;
import javax.persistence.*;
 
@Entity
@Table(name = "adress")
public class Adress{
 
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
 
  @Column(name = "address")
  private String   address;
 
public  Adress(){}
 
public Adress( String address){
     this.address=address;
  }
  public String getAddress()
   {
     return address;
  }
   
  public void setAddress(String address )
  {
     this.address=address;
  }
@Override 
public String toString() { 
 return "Adress[id="+id+",address="+address+"]";
  }
}
