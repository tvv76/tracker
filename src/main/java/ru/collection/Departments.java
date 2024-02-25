package ru.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> departments) {
        Set<String> temp = new LinkedHashSet<>();

        for (String dept : departments) {
            String[] deptStructure = dept.split("/", 0);
            StringBuilder output = new StringBuilder().append(deptStructure[0]);
            temp.add(output.toString());
            for (int i = 1; i < deptStructure.length; i++) {
                output.append("/");
                output.append(deptStructure[i]);
                temp.add(output.toString());
            }
        }

        return new ArrayList(temp);
    }

    public static void sortAsc(List<String> departments) {
        departments.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> departments) {
        departments.sort(new DepartmentsDescComparator());
    }
}
