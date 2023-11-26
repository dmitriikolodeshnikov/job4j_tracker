package ru.job4j.tracker;

public interface Transport {
    void move();

    void passengers(int passengers);

    double refill(double litres);

}
