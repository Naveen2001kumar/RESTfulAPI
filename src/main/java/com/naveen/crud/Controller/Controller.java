package com.naveen.crud.Controller;


import com.naveen.crud.Entity.Student;
import com.naveen.crud.service.StudentImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/crud")
public class Controller  {

    @Autowired
    StudentImplement service;

    @GetMapping("/students")
    public List<Student>  getStudent()
    {
        return service.fetchAll();
    }
    @GetMapping("students/{Id}")
    public Student getStudentByID(@PathVariable int Id)
    {
        return service.fetchById(Id);
    }
    @PostMapping("/students")
    public String setStudent(@RequestBody Student student)
    {
        return  service.store(student);
    }
    @PutMapping("/students/{id}")
    public String updateStudent(@RequestBody Student student,@PathVariable int id)
    {

        return service.updateStudent(id,student);
    }
    @DeleteMapping("students/{Id}")
    public String DeleteStudent(@PathVariable int Id)
    {
        return service.deleteStudent(Id);
    }

}
