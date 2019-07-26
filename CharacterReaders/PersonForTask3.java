public class PersonForTask3 {
    String name;
    int age;

    public PersonForTask3(String name,int age){
        this.name=name;
        this.age=age;
    }
    public String getName(){
        return name;
    }
    public  int getAge(){
        return  age;
    }
    public String toString(){
        return "name: "+name+"  age: "+age;
    }
}
