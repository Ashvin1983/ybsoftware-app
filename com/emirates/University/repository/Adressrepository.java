package com.emirates.University.repository;
import java.util.*;
import java.io.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.repository.CrudRepository;
import com.project.generator.model.*;
import org.springframework.data.mongodb.repository.MongoRepository;
 
 
@Component
public interface Adressrepository extends CrudRepository<Adress,Long>{
 
 
 
}
