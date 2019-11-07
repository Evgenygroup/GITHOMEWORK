import printing.Person;
import printing.Printer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;

public class FileReading {

     /* 3. Есть текстовый csv файл:“Ivan”, “18”“Piotr”, “20”“Anna”, “10”
    Вывести на экран отсортированный по возрасту список. Подсказка:
    вычитать файлпострочно с  помощью Reader’a, положить данные в список классов  printing.Person,
     списокотсортировать с помощью Stream API.   Можно усложнить - вычитать только тех, кто старше 17 лет.
      Тут разные вариантырешения: вычитать всех, потом отсортировать тех, кто старше 17,
      но если список вфайле большой, то может не стоит создавать объекты в Джаве,
     то есть проверять впроцессе чтения и создавать
     Джава объекты только для тех пользователей, чтостарше 17*/

    private Printer printer;

    public FileReading(Printer printer) {
        this.printer = printer;
    }

    public void sortedNamesbyAgeOlder17(String str) {
        try (BufferedReader in = new BufferedReader(new FileReader(str))) {
            in.lines()
                    .filter(p -> checkAge(p) > 17)
                    .map(s -> makePerson(s))
                    .sorted(Comparator.comparingInt(Person::getAge))
                    .forEachOrdered(p->printer.print(p));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int checkAge(String str) {
        String[] lineFromFile = str.split(",");
        return Integer.valueOf(lineFromFile[1]);
    }

    private Person makePerson(String str) {
        String[] lineFromFile = str.split(",");
        return (new Person(lineFromFile[0], Integer.valueOf(lineFromFile[1])));
    }

}
