package com.naveen.crud.service;

import com.naveen.crud.DAO.StudentRepo;
import com.naveen.crud.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
     @Autowired
    StudentRepo repo;
    public Student getStudentById(int id)
    {
        Student student = repo.findById(id);
        if(student==null)
        {
            throw new RuntimeException("There is a no data in this id:"+id);
        }
        return student;
    }
    public List<Student> getStudent()
    {
        List<Student> li = repo.findAll();
        if(li == null)
        {
            throw new RuntimeException("The table is Empty");
        }
        return li;
    }
   public String setStudent(Student student)
   {
       if(student == null)
       {
           throw new RuntimeException("Enter a Student details Correctly");
       }
       repo.save(student);
       return "Inserted Successfully";
   }

    public String putStudent(Student student) {
        if(student == null )
        {
            throw new RuntimeException("We can't find the row");
        }
        repo.save(student);
        return "Updated Successfully";
    }
    public String deleteStudent(int id)
    {
        repo.deleteById(id);
        return "Deleted Successfully";
    }
}
