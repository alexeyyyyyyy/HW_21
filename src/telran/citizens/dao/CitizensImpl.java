package telran.citizens.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import telran.citizens.model.Person;

public class CitizensImpl implements Citizens {
	
	  private List<Person> citizensList;
	  
	  
	  public CitizensImpl() {
	        citizensList = new ArrayList<>();
	    }
	
	@Override
	public boolean add(Person person) {
		if (citizensList.stream().anyMatch(p -> p.getId() == person.getId())) {
            return false; 
        }
        citizensList.add(person);
        return true;
	}

	@Override
	public boolean remove(int id) {
		return citizensList.removeIf(person -> person.getId() == id);
	}

	@Override
	public Person find(int id) {
		 return citizensList.stream()
                 .filter(person -> person.getId() == id)
                 .findFirst()
                 .orElse(null);
	}

	@Override
	public Iterable<Person> find(int minAge, int maxAge) {
		  int currentYear = LocalDate.now().getYear();
	        return citizensList.stream()
	                           .filter(person -> {
	                               int age = currentYear - person.getBirthDate().getYear();
	                               return age >= minAge && age <= maxAge;
	                           })
	                           .toList();
	}

	@Override
	public Iterable<Person> find(String lastName) {
		 return null;
	}

	@Override
	public Iterable<Person> getAllPersonSortedById() {
		 return null;
	}

	@Override
	public Iterable<Person> getAllPersonSortedByLastName() {
		 return null;
	}

	@Override
	public Iterable<Person> getAllPersonSortedByAge() {
		 return null;
	}

	@Override
	public int size() {
		return citizensList.size();
	}

}
