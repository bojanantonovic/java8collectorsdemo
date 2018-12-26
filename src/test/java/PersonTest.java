import org.junit.jupiter.api.Test;

public class PersonTest {

	@Test
	void testLombok() {
		final Person person = new Person("A", "B", 10);

		System.out.println(person.getFirstName());
		System.out.println(person.getSecondName());
		System.out.println(person.getAge());
	}
}
