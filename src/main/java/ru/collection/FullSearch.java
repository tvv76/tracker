package ru.collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FullSearch {
    public Set<String> extractNumber(List<Task> tasks) {
        Set<String> result = new HashSet<>();
        for (Task task : tasks) {
            result.add(task.getNumber());
        }
        return result;
    }
}