package ru.stream;

import java.util.Comparator;
import java.util.List;

public class Profiles {

    public static List<Address> collect(List<Profile> profiles) {
        List<Address> result = profiles.stream()
                .map(profile -> profile.getAddress())
                .toList();
        return result;
    }

    public static List<Address> collectSortWithoutDuplicate(List<Profile> profiles) {
        List<Address> result = collect(profiles).stream()
                .sorted(Comparator.comparing(Address::getCity))
                .distinct()
                .toList();

        return result;
    }

}
