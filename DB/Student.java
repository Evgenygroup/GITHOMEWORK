package addstudent;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int studentId;
    private String firstName;
    private String lastName;
    private String courseId;

    public Student() {
    }

    public Student(String firstName, String lastName,String courseId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseId=courseId;
    }

    public Student(int studentId, String firstName, String lastName,String courseId) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseId=courseId;
    }

    public long getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }


}
