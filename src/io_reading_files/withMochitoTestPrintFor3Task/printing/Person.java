package printing;

public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "printing.Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
