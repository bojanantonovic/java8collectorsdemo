import org.junit.jupiter.api.Test;

class PersonGeneratorTest {

    @Test
    public void createPerson() {
        final Person person = PersonGenerator.createPerson(5, 20);
        System.out.println(person);
    }
}