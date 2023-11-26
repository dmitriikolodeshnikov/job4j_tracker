package ru.job4j.tracker;

public class Bus implements Transport {
    @Override
    public void move() {
        System.out.println("Автобус начинает движение");
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("На остановке заходит " + passengers + " пассажиров");
    }

    @Override
    public double refill(double litres) {
        return litres * 55.6;
    }
}
