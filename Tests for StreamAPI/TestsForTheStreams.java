import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestsForTheStreams {

	// Test for N 6. Method accepts a sentence and
	// returns number of words starting with a certain letter
	@Test
	public void testNumberOfWordsStartingFromCertainLetter() {
		String testString = "aaaaaaaa fffffff aa bbbb a bbb aaa ggggggggggg";
		long number = Streams.numberOfWords(testString, "a");
		assertEquals(4, number);
	}

	// Test for N 7. Check if the string is number
	// Test 7-1:
	@Test
	public void testIfStringIsNumber() {
		String testString = "1459032";
		boolean numberOrNot = Streams.isDig(testString);
		assertTrue(numberOrNot);
	}

	// Test for N 7. Check if the string is number
	// Test 7-2:
	@Test
	public void testIfStringIsNumber1() {
		String testString = "adf45";
		boolean numberOrNot = Streams.isDig(testString);
		assertTrue(numberOrNot);
	}

	// Test for N 10. Count total age of those older than 17:
	@Test
	public void testAgeOlderSeventeen() {
		Person p1 = new Person("Anna Mons", 16);
		Person p2 = new Person("Koenigsegg", 35);
		Person p3 = new Person("Peter the Great", 47);
		Person p4 = new Person("John Smith", 16);
		Person p5 = new Person("Ivanov", 47);
		List<Person> list = Arrays.asList(p1, p2, p3, p4, p5);
		int age = Streams.ageAll(list);
		assertEquals(129, age);
	}

	// Test for N 11.They are of legal age in Germany:
	@Test
	public void testLegalAge() {
		Person p1 = new Person("Anna Mons", 16);
		Person p2 = new Person("Koenigsegg", 35);
		Person p3 = new Person("Peter the Great", 47);
		Person p4 = new Person("John Smith", 16);
		Person p5 = new Person("Ivanov", 47);
		List<Person> list = Arrays.asList(p1, p2, p3, p4, p5);
		String legalAge = Streams.legalAge(list);
		assertEquals("in Germany Koenigsegg and Peter the Great and Ivanov are of legal age.", legalAge);

	}

}
