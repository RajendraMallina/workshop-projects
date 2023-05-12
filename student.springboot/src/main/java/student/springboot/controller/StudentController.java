package student.springboot.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import student.springboot.model.Student;
import student.springboot.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService service;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/add/student")
	public boolean addStudent(@RequestBody Student s) {
		return service.addStudent(s);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/get/student/{id}")
	public Student getStudent(@PathVariable int id) {
		return service.getStudent(id);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/get/student/marks/{marks}", method=RequestMethod.GET)
	public List<Student> getStudentsByMarks(@PathVariable double marks){
		return service.getStudentByMarks(marks);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/get/students")
	public List<Student> getAllStudents(){
		return service.getAllStudents();
	}
	
	@RequestMapping(value="/update/student/{id}/{newName}", method=RequestMethod.PUT)
	public Student updateStudentNameById(@PathVariable int id, @PathVariable String newName) {
		return service.updateStudentNameById(id, newName);
	}
	
	@RequestMapping(value="/delete/student/{id}", method=RequestMethod.DELETE)
	public boolean deleteStudent(@PathVariable int id) {
		return service.deleteStudent(id);
	}
}
