package io.javadash.CollectionUtilsTest;

import java.util.Objects;
import org.junit.jupiter.api.Test;
import static io.javadash.CollectionUtils.*;  // Correct import for the collection utility methods
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import static org.junit.jupiter.api.Assertions.*;

public class UniqByTest {

    @Test
    void testUniqByWithIteratee() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Alice", 30));
        list.add(new Person("Bob", 25));
        list.add(new Person("Alice", 30));  // Duplicate based on name

        Function<Person, String> byName = Person::getName;  // Function to extract name for comparison

        List<Person> result = uniqBy(list, byName);

        // The result should contain only one instance of "Alice" and "Bob"
        assertEquals(new ArrayList<>(List.of(new Person("Alice", 30), new Person("Bob", 25))), result);
    }

    @Test
    void testUniqByWithEmptyList() {
        List<Person> list = new ArrayList<>();

        Function<Person, String> byName = Person::getName;  // Function to extract name for comparison

        List<Person> result = uniqBy(list, byName);

        assertEquals(new ArrayList<>(), result);  // Should return an empty list
    }

    @Test
    void testUniqByWithNullList() {
        List<Person> list = null;

        Function<Person, String> byName = Person::getName;  // Function to extract name for comparison

        List<Person> result = uniqBy(list, byName);

        assertEquals(new ArrayList<>(), result);  // Should return an empty list
    }

    @Test
    void testUniqByWithNullIteratee() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Alice", 30));
        list.add(new Person("Bob", 25));
        list.add(new Person("Alice", 30));  // Duplicate based on name

        List<Person> result = uniqBy(list, null);

        // Since the iteratee is null, the result should contain all elements
        assertEquals(new ArrayList<>(List.of(new Person("Alice", 30), new Person("Bob", 25), new Person("Alice", 30))), result);
    }

    @Test
    void testUniqByWithComplexIteratee() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Alice", 30));
        list.add(new Person("Alice", 25));
        list.add(new Person("Bob", 25));

        Function<Person, Integer> byAge = Person::getAge;  // Function to extract age for comparison

        List<Person> result = uniqBy(list, byAge);

        // The result should contain only one "Alice" (age 30) and "Bob" (age 25)
        assertEquals(new ArrayList<>(List.of(new Person("Alice", 30), new Person("Bob", 25))), result);
    }

    // Custom class for testing with unique functionality
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





