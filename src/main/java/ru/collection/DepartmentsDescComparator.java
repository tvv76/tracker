package ru.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftStructure = (left + "/ ").split("/", 2);
        String[] rightStructure = (right + "/ ").split("/", 2);
        return rightStructure[0].equals(leftStructure[0]) ? leftStructure[1].compareTo(rightStructure[1]) :
                rightStructure[0].compareTo(leftStructure[0]);
    }
}
