public class Person {

    private final String secondName;

    private final String firstName;

    private final int age;

    public Person(final String secondName, final String firstName, final int age) {
        this.secondName = secondName;
        this.firstName = firstName;
        this.age = age;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "secondName='" + secondName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }
}
