package ru.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Ivan Ivanov");
        student.setGroup("A-113");
        student.setEnrolledAt(LocalDate.of(2000, 9, 1));
        String ln = System.lineSeparator();
        System.out.println(String.format("Student: %s " + ln
                + "enrolled at %s" + ln
                + "group #%s", student.getName(), student.getEnrolledAt(), student.getGroup()));
    }
}
