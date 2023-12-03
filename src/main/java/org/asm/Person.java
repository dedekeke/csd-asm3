package org.asm;

import java.util.Objects;

public record Person(String ID, String name, String birthplace, String dob) {
    public Person {
        if (ID == null || ID.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        if (!isNumeric(ID)) {
            throw new IllegalArgumentException("ID must be numeric");
        }
    }

    @Override
    public String toString() {
        return String.format("%-10s %-10s %-20s %-10s", ID, name, dob, birthplace);
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

    // check id
    private boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
