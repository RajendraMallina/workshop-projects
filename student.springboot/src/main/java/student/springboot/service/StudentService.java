package student.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student.springboot.model.Student;
import student.springboot.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository repository;

	public boolean addStudent(Student s) {

		Optional<Student> std = repository.findById(s.getId());

		if (std.isEmpty()) {

			repository.save(s);
			return true;
		} else {
			return false;
		}

	}

	public Student getStudent(int id) {
		Optional<Student> std = repository.findById(id);

		if (std.isEmpty()) {
			return null;
		}else {
			return std.get();
		}
	}

	public List<Student> getStudentByMarks(double marks) {
		
		List<Student> students = repository.getStudentsByMarks(marks);
		return students;
	}

	public List<Student> getAllStudents() {
		return repository.findAll();
	}

	public Student updateStudentNameById(int id, String newName) {
		
		Optional<Student> std = repository.findById(id);

		if (std.isEmpty()) {

			return null;
		} else {
			
			Student s = std.get();
			s.setName(newName);
			repository.save(s);
			return s;
		}
	}

	public boolean deleteStudent(int id) {
		Optional<Student> std = repository.findById(id);

		if (std.isEmpty()) {

			return false;
		} else {
			
			repository.deleteById(id);
			return true;
		}
	}
}
