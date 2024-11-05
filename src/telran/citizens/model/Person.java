package telran.citizens.model;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Person implements Comparable<Person> {
	
	private int id;
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	
	
	
	public Person(int id, String firstName, String lastName, LocalDate birthDate) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}

	


	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public int getId() {
		return id;
	}




	public LocalDate getBirthDate() {
		return birthDate;
	}

	public int getAge() {
		return (int) ChronoUnit.YEARS.between(birthDate, LocalDate.now());
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return id == other.id;
	}




	@Override
	public int compareTo(Person o) {
		return Integer.compare(id, o.id);
	}

}
