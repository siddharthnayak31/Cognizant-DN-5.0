package Q29_Records;

import java.util.List;

record Person(String name, int age) {}

public class RecordsExample {

    public static void main(String[] args) {

        Person p1 = new Person("Astha", 21);
        Person p2 = new Person("Riya", 17);
        Person p3 = new Person("Rahul", 25);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        List<Person> people = List.of(p1, p2, p3);

        System.out.println("\nPeople age 18 or above:");

        people.stream()
              .filter(person -> person.age() >= 18)
              .forEach(System.out::println);
    }
}