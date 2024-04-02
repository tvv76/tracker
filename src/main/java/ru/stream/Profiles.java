package ru.stream;

import java.util.List;

public class Profiles {

    public static List<Address> collect(List<Profile> profiles) {
        List<Address> result = profiles.stream()
                .map(profile -> profile.getAddress())
                .toList();
        return result;
    }
}
