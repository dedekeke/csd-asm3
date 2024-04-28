package org.asm;

import java.util.HashSet;
import java.util.Objects;

public record Person(String ID, String name, String birthplace, String dob) {

    private static final HashSet<String> existed = new HashSet<>();

    public Person {
        if (ID == null || ID.isEmpty() || !existed.add(ID)) {
            throw new IllegalArgumentException("Invalid ID");
        }
    }

    public static Person addPerson(String ID, String name, String birthplace, String dob) {
        if (!existed.contains(ID)) {
            existed.add(ID);
            return new Person(ID, name, birthplace, dob);
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return String.format("%-10s %-10s %-10s %-10s", ID, name, birthplace, dob);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Person person = (Person) obj;
        return Objects.equals(ID, person.ID) &&
                Objects.equals(name, person.name) &&
                Objects.equals(birthplace, person.birthplace) &&
                Objects.equals(dob, person.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, birthplace, dob);
    }
}
