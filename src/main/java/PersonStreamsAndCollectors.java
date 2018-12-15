import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonStreamsAndCollectors {

    private static final int MAX_AGE = 20;

    public static void main(String... args) {
        Supplier<Person> personSupplier = () -> PersonGenerator.createPerson(5, MAX_AGE);

        Person any = Stream.generate(personSupplier)
                .findAny()
                .get();

        List<Person> people = Stream.generate(personSupplier)
                .limit(3)
                .collect(Collectors.toList());

        Person over100 = Stream.generate(personSupplier)
                .filter(person -> person.getAge() >= MAX_AGE - 10)
                .findAny()
                .get();

        int ageOfFirst = Stream.generate(personSupplier)
                .mapToInt(Person::getAge)
                .findFirst()
                .getAsInt();

        Map<Integer, List<Person>> peopleGroupedByAge = Stream.generate(personSupplier)
                .limit(100)
                .collect(Collectors.groupingBy(Person::getAge));

        Map<Integer, Long> peopleByAge = Stream.generate(personSupplier)
                .limit(100)
                .collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));

        Map<Boolean, List<Person>> adultsAndYouth = Stream.generate(personSupplier)
                .limit(100)
                .collect(Collectors.partitioningBy(p -> p.getAge() >= 18));

        Double averageAge = Stream.generate(personSupplier)
                .limit(100)
                .collect(Collectors.averagingInt(Person::getAge));

        List<String> names = Stream.generate(personSupplier)
                .limit(7)
                .collect(Collectors.mapping(Person::getSecondName, Collectors.toList()));

        String namesAsString = Stream.generate(personSupplier)
                .limit(7)
                .collect(Collectors.mapping(Person::getSecondName, Collectors.joining(";")));
    }
}
