package addstudent;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Student,Integer> {

}
