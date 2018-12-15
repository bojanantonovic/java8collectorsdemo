import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonStreamsAndCollectors {

    private static final int MAX_AGE = 20;

    public static void main(String... args) {
        Supplier<Person> personSupplier = () -> PersonGenerator.createPerson(5, MAX_AGE);

        // streams

        // any random Person
        Person any = Stream.generate(personSupplier)
                .findAny()
                .get();

        // 3 instances of Person
        List<Person> people = Stream.generate(personSupplier)
                .limit(3)
                .collect(Collectors.toList());

        // first person with an age of at least 10
        Person over10 = Stream.generate(personSupplier)
                .filter(person -> person.getAge() >= MAX_AGE - 10)
                .findAny()
                .get();

        // stream of persons => their ages => first value/age
        int ageOfFirst = Stream.generate(personSupplier)
                .mapToInt(Person::getAge)
                .findFirst()
                .getAsInt();

        // collectors

        // grouping people by age
        Map<Integer, List<Person>> peopleGroupedByAge = Stream.generate(personSupplier)
                .limit(100)
                .collect(Collectors.groupingBy(Person::getAge));

        // age distribution of random people
        Map<Integer, Long> peopleByAge = Stream.generate(personSupplier)
                .limit(100)
                .collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));

        // people partitioned into adults and youth
        Map<Boolean, List<Person>> adultsAndYouth = Stream.generate(personSupplier)
                .limit(100)
                .collect(Collectors.partitioningBy(p -> p.getAge() >= 18));

        // average age
        Double averageAge = Stream.generate(personSupplier)
                .limit(100)
                .collect(Collectors.averagingInt(Person::getAge));

        // seconds names into a list
        List<String> secondDames = Stream.generate(personSupplier)
                .limit(7)
                .collect(Collectors.mapping(Person::getSecondName, Collectors.toList()));

        // all second names concatenated by a comma
        String secondNamesAsString = Stream.generate(personSupplier)
                .limit(7)
                .collect(Collectors.mapping(Person::getSecondName, Collectors.joining(";")));
    }
}
