package collections_homework_lists;

public class Person {
   /* Есть два класса: Address с полями улица и номер дома и Person с полями имя иAddress. Нужно написать функцию:List<Address> getAddresses(List<Person> persons)
    то есть по списку persons возвращать список их адресов*/
   private String personName;
   private Address address;

    public Person(String personName, Address address) {
        this.personName = personName;
        this.address = address;
    }

    public String getPersonName() {
        return personName;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personName='" + personName + '\'' +
                ", address=" + address +
                '}';
    }
}
