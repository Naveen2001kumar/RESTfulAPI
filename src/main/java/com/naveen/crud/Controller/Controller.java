package com.naveen.crud.Controller;


import com.naveen.crud.Entity.Student;
import com.naveen.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/CRUD")
public class Controller  {

    @Autowired
    StudentService service;

    @GetMapping("/students")
    public List<Student>  getStudent()
    {

        return service.getStudent();
    }
    @GetMapping("students/{studentId}")
    public Student getStudentByID(@PathVariable int studentId)
    {
        return service.getStudentById(studentId);
    }
    @PostMapping("/students")
    public String setStudent(@RequestBody Student student)
    {
        return  service.setStudent(student);
    }
    @PutMapping("/students")
    public String updateStudent(@RequestBody Student student)
    {
        return service.putStudent(student);
    }
    @DeleteMapping("students/{studentId}")
    public String DeleteStudent(@PathVariable int studentId)
    {
        return service.deleteStudent(studentId);
    }

}
