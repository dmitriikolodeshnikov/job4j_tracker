package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Kolodeshnikov Dmitrii Nikolaevich");
        student.setGroup(6345);
        student.setReceiptDate(new Date());
        System.out.println(student.getName() + ", group:" + student.getGroup() + ", receipt date: " + student.getReceiptDate());
    }
}
