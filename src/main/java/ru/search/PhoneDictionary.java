package ru.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if ((person.getAddress()
                    + person.getSurname() +
                    person.getPhone() +
                    person.getAddress()).contains(key)) {
                result.add(person);
            }
        }
        return result;
    }
}
