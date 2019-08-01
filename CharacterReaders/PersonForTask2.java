import java.time.LocalDate;

public class PersonForTask2 {

    String name;
    LocalDate dateOfBirth;


    public PersonForTask2(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;

    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getName() {
        return name;
    }


    public String toString() {
        return name + " , " + dateOfBirth;
    }

}
