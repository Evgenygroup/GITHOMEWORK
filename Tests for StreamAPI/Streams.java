import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

//6. method accepts a sentence and
// returns number of words starting with a certain letter
	public static long numberOfWords(String input, String w) {
		long count = Stream.of(input.split(" ")).filter(s -> s.startsWith(w)).count();
		return count;
	}

//7. check if the string is number - Character.isDigit() and Stream.allMatch().
	public static boolean isDig(String input) {
		boolean allMatch = input.chars().allMatch(Character::isDigit);
		return allMatch;
	}

//10.  total age of those older than 17
	public static int ageAll(List<Person> input) {
		Integer reduce = input.stream().filter(s -> s.getAge() > 17).map(Person::getAge).reduce(0, (s1, s2) -> s1 + s2);
		return reduce;

	}
	
// 11.They are of legal age in Germany
	public static String legalAge(List<Person> input) {
		String legalAge = input.stream().filter(s -> s.getAge() > 17).map(Person::getName)
				.collect(Collectors.joining(" and ", "in Germany ", " are of legal age."));
		return legalAge;

	}
}
