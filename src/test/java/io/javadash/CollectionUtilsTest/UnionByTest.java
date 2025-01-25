package io.javadash.CollectionUtilsTest;

import java.util.Objects;
import org.junit.jupiter.api.Test;
import static io.javadash.CollectionUtils.*;  // Correct import for the collection utility methods
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import static org.junit.jupiter.api.Assertions.*;

public class UnionByTest {

    @Test
    void testUnionByWithIteratee() {
        List<Person> list1 = new ArrayList<>();
        list1.add(new Person("Alice", 30));
        list1.add(new Person("Bob", 25));

        List<Person> list2 = new ArrayList<>();
        list2.add(new Person("Alice", 30));  // Duplicate based on name
        list2.add(new Person("Charlie", 35));

        Function<Person, String> byName = Person::getName;  // Use name as the iteratee for uniqueness

        List<Person> result = unionBy(byName, list1, list2);

        // The result should contain only one "Alice", one "Bob", and one "Charlie" based on the name
        assertEquals(new ArrayList<>(List.of(
            new Person("Alice", 30),
            new Person("Bob", 25),
            new Person("Charlie", 35))), result);
    }

    @Test
    void testUnionByWithEmptyList() {
        List<Person> list1 = new ArrayList<>();
        List<Person> list2 = new ArrayList<>();

        Function<Person, String> byName = Person::getName;

        List<Person> result = unionBy(byName, list1, list2);

        // The result should be an empty list
        assertEquals(new ArrayList<>(), result);
    }

    @Test
    void testUnionByWithNullList() {
        List<Person> list1 = null;
        List<Person> list2 = new ArrayList<>();
        list2.add(new Person("Alice", 30));

        Function<Person, String> byName = Person::getName;

        List<Person> result = unionBy(byName, list1, list2);

        // The result should be equal to list2 as list1 is null
        assertEquals(new ArrayList<>(List.of(new Person("Alice", 30))), result);
    }

    @Test
    void testUnionByWithComplexIteratee() {
        List<Person> list1 = new ArrayList<>();
        list1.add(new Person("Alice", 30));
        list1.add(new Person("Bob", 25));

        List<Person> list2 = new ArrayList<>();
        list2.add(new Person("Charlie", 35));
        list2.add(new Person("Alice", 30)); // Duplicate based on name

        Function<Person, Integer> byAge = Person::getAge;  // Use age as the iteratee for uniqueness

        List<Person> result = unionBy(byAge, list1, list2);

        // The result should contain only one "Alice" (age 30) and "Bob" (age 25)
        assertEquals(new ArrayList<>(List.of(
            new Person("Alice", 30),
            new Person("Bob", 25),
            new Person("Charlie", 35))), result);
    }

    // Custom class for testing with union functionality
    static class Person {
        private String name;
        private int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Person person = (Person) obj;
            return age == person.age && name.equals(person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public String toString() {
            return name + ", " + age;
        }
    }
}




