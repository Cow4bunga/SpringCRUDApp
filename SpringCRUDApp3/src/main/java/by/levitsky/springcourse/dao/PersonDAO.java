package by.levitsky.springcourse.dao;

import by.levitsky.springcourse.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int peopleCounter;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++peopleCounter, "Joe"));
        people.add(new Person(++peopleCounter, "Bob"));
        people.add(new Person(++peopleCounter, "Sam"));
        people.add(new Person(++peopleCounter, "Jack"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().
                filter(p -> p.getId() == id).
                findAny().
                orElse(null);
    }

    public void save(Person person) {
        person.setId(++peopleCounter);
        people.add(person);
    }

    public void update(int id, Person person) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(person.getName());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
