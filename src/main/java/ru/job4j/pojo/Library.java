package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 1000);
        Book profLibrary = new Book("Professional library", 800);
        Book philosophy = new Book("Philosophy of Java", 1500);
        Book completeGuide = new Book("Сomplete guide of Java", 1200);
        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = profLibrary;
        books[2] = philosophy;
        books[3] = completeGuide;
        for (int i = 0; i < books.length; i++) {
            Book boo = books[i];
            System.out.println(boo.getName() + " - " + boo.getCount());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;

        for (int i = 0; i < books.length; i++) {
            Book boo = books[i];
            System.out.println(boo.getName() + " - " + boo.getCount());

        }
        for (int i = 0; i < books.length; i++) {
            Book boo = books[i];
            if (boo.getName().equals("Clean code")) {
                System.out.println(boo.getName() + " - " + boo.getCount());
            }
        }
    }
}
