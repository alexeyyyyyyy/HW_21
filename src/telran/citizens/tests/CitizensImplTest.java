package telran.citizens.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.citizens.dao.Citizens;
import telran.citizens.dao.CitizensImpl;
import telran.citizens.model.Person;

class CitizensImplTest {
	Citizens citizens;

	@BeforeEach
	void setUp() throws Exception {
		citizens = new CitizensImpl();
	}

	@Test
	void testAdd() {
		assertEquals(0, citizens.size());
		Person person = new Person(1, "John", "Doe", LocalDate.of(1990, 1, 1));
		assertTrue(citizens.add(person), "Person added");
		assertEquals(1, citizens.size());
	}

	@Test
	void testRemove() {
		Person person = new Person(2, "Jane", "Doe", LocalDate.of(1985, 5, 5));
		citizens.add(person);
		assertTrue(citizens.remove(2), "Person removed");
		assertEquals(0, citizens.size());
	}

	@Test
	void testFindInt() {
		Person person = new Person(3, "Alice", "Smith", LocalDate.of(1992, 3, 15));
		citizens.add(person);
		Person person1 = citizens.find(3);
		assertNotNull(person1);
		assertEquals("Alice", person1.getFirstName());
	}

	@Test
	void testFindIntInt() {
		citizens.add(new Person(4, "Bob", "Brown", LocalDate.of(2000, 1, 1)));
		citizens.add(new Person(5, "Charlie", "Green", LocalDate.of(1995, 1, 1)));

		Iterable<Person> found = citizens.find(20, 30); 
		int count = 0;
		for (Person p : found) {
			count++;
		}
		assertEquals(2, count);
	}

	@Test
	void testFindString() {
		citizens.add(new Person(6, "David", "Jarvison", LocalDate.of(1980, 1, 1)));
        citizens.add(new Person(7, "Emma", "Jarvison", LocalDate.of(1990, 1, 1)));

        Iterable<Person> found = citizens.find("Jarvison");
        int count = 0;
        for (Person p : found) {
            count++;
        }
        assertEquals(2, count);
	}

	@Test
	void testGetAllPersonSortedById() {
		citizens.add(new Person(9, "Fiona", "White", LocalDate.of(1998, 1, 1)));
        citizens.add(new Person(8, "George", "Blue", LocalDate.of(1991, 1, 1)));

        Iterable<Person> sorted = citizens.getAllPersonSortedById();
        assertEquals(8, sorted.iterator().next().getId());
	}

	@Test
	void testGetAllPersonSortedByLastName() {
		 citizens.add(new Person(10, "Hannah", "Adams", LocalDate.of(1987, 1, 1)));
	        citizens.add(new Person(11, "Ian", "Carter", LocalDate.of(1992, 1, 1)));

	        Iterable<Person> sorted = citizens.getAllPersonSortedByLastName();
	        assertEquals("Adams", sorted.iterator().next().getLastName());
	}

	@Test
	void testGetAllPersonSortedByAge() {
		citizens.add(new Person(12, "Jack", "Evan", LocalDate.of(2003, 1, 1)));
        citizens.add(new Person(13, "Kate", "Davis", LocalDate.of(1995, 1, 1)));

        Iterable<Person> sorted = citizens.getAllPersonSortedByAge();
        assertEquals(12, sorted.iterator().next().getId());
	}

	@Test
	void testSize() {
		 assertEquals(0, citizens.size());
	        citizens.add(new Person(14, "Laura", "Lee", LocalDate.of(1988, 1, 1)));
	        assertEquals(1, citizens.size());
	}

}
