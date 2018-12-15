import java.util.Random;

public class PersonGenerator {

    private static final Random random = new Random();

    public static Person createPerson(final int namesLength, final int maxAge) {
        final String firstName = StringGenerator.getRandomString(namesLength);
        final String secondName = StringGenerator.getRandomString(namesLength);
        final int age = random.nextInt(maxAge);

        return new Person(firstName, secondName, age);
    }
}
