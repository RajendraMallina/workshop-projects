package student.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import student.springboot.model.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Query(value = "select * from student where marks=?1", nativeQuery = true)
	List<Student> getStudentsByMarks(double marks);

}
