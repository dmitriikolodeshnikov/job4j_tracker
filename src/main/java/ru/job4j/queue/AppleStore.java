package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        String lastHappyCustomer = "";
        int availableItems = count;
        for (int i = 0; i < queue.size() + count; i++) {
            Customer customer = queue.poll();
            if (availableItems > 0) {
                lastHappyCustomer = customer.name();
                availableItems--;
            } else {
                break;
            }
        }
        return lastHappyCustomer;
    }

    public String getFirstUpsetCustomer() {
        int availableItems = count;
        for (int i = 0; i < queue.size() + count; i++) {
            Customer customer = queue.poll();
            if (availableItems == 0) {
               return customer.name();

            }
            availableItems--;

        }
        return "";
    }
}