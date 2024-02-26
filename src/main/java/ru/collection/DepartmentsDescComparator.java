package ru.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftStructure = (left + "/ ").split("/", 2);
        String[] rightStructure = (right + "/ ").split("/", 2);
        StringCompare compare = new StringCompare();
        return compare.compare(rightStructure[0], leftStructure[0]) != 0 ? compare.compare(rightStructure[0], leftStructure[0]) : compare.compare(leftStructure[1], rightStructure[1]);
    }
}
