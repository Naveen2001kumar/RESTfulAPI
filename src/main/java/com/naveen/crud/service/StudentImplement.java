package com.naveen.crud.service;

import com.naveen.crud.DAO.StudentRepo;
import com.naveen.crud.Entity.Student;
import com.naveen.crud.Exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentImplement implements StudentService{
     @Autowired
     StudentRepo repo;
     @Override
    public Student fetchById(int id)
    {
        Student student = repo.findById(id).orElseThrow(()
                -> new StudentNotFoundException("Student could not be found")
        );
        return student;
    }
    @Override
    public List<Student> fetchAll()
    {
        List<Student> li = repo.findAll();
        if(li.isEmpty())
        {
            throw new StudentNotFoundException("The table is Empty");
        }
        return li;
    }
    @Override
   public String store(Student student)
   {
       if(student.getId()==0)
           throw new StudentNotFoundException("Enter a data's Correctly");
       repo.save(student);
       return "Inserted Successfully";
   }
    @Override
    public String updateStudent(int id , Student student) {
         Student student1 = repo.findById(id).orElseThrow(
                 ()-> new StudentNotFoundException("Student could not be found")
         );
         student1.setId(student1.getId());
         student1.setName(student.getName());
         student1.setAge(student.getAge());
         student1.setPhNo(student.getPhNo());
        repo.save(student1);
        return "Updated Successfully";
    }
    public String deleteStudent(int id)
    {
        Student student = repo.findById(id).orElseThrow(()
                -> new StudentNotFoundException("Student could not be found")
        );
        repo.delete(student);
        return "Deleted Successfully";
    }
}
