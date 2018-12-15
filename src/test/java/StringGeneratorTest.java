import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringGeneratorTest {

    @Test
    void testLength() {
        int length = 5;

        String randomString = StringGenerator.getRandomString(length);
        System.out.println(randomString);

        assertEquals(length, randomString.length());
    }

    @Test
    void testLetterRange() {
        String randomString = StringGenerator.getRandomString(1);

        char randomCharacter = randomString.charAt(0);
        System.out.println(randomCharacter);

        assertTrue(randomCharacter >= 'A');
        assertTrue(randomCharacter <= 'Z');
    }

}