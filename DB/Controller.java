package addstudent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class Controller {

    @Autowired
    private Service service;

    @RequestMapping(path="/students",method  =POST)
    public  void addStudent(@RequestBody Student student){
        service.addStudent(student);
    }

    @RequestMapping(path="/students",method = GET)
    public List<Student> getAllStudents (){
        return service.getAllStudents();
    }
}
