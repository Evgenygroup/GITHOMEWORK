package collections_homework_lists;

public class Address {
    /*Есть два класса: Address с полями улица и номер дома и Person с полями имя иAddress. Нужно написать
    функцию:List<Address> getAddresses(List<Person> persons)то есть по списку persons возвращать список их адресов
     */
    private String street;
    private int number;

    public Address(String street, Integer number) {
        this.street = street;
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", number=" + number +
                '}';
    }
}
