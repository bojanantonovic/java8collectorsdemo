import java.util.Random;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class StringGenerator {

    private static final Random random = new Random();

    private static final Supplier<IntStream> intStreamSupplier = () -> random.ints('A', 'Z');

    private static final IntFunction<String> asStringCharacter = (int n) -> String.valueOf((char) n);

    public static String getRandomString(int maxSize) {
        final IntStream intStream = intStreamSupplier.get();

        return intStream
                .mapToObj(asStringCharacter)
                .limit(maxSize)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

}


