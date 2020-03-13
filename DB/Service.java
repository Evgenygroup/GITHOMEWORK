package addstudent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Service {

    private Repository repository;

    @Autowired
    public Service(Repository repository){
        this.repository=repository;
    }

    public  void  addStudent(Student student){
        repository.save(student);
    }

    public  List<Student>getAllStudents(){
        return  repository.findAll();
    }

}
