package ru.stream;

import java.util.List;
import java.util.function.Predicate;

public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predicate) {
        List<Student> result = students.stream()
                .filter(predicate)
                .toList();
        return result;
    }
}
