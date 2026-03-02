package ru.job4j.tracker;

public class BusMain {
    public static void main(String[] args) {
        Transport bus = new Bus();
        bus.move();
        bus.passengers(5);
        System.out.println("Сумма заправки: " + bus.refill(100));
    }
}
