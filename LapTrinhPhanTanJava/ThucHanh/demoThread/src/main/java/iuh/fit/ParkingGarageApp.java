/*
 * @ (#) ParkingGarageApp.java       08/01/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package iuh.fit;

import java.util.concurrent.*;

/*
 * @description
 * @author: Khanh Nguyen Thi Hoang
 * @date:   08/01/2024
 */
public class ParkingGarageApp {

    private  static ParkingGarage parkingGarage = new ParkingGarage(3); //

    public static void main(String[] args) {

        Runnable enter = () -> {
            parkingGarage.enter();
        };

        Runnable leave = () -> {
            try {
                Thread.sleep(3000);
                parkingGarage.leave();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.execute(enter);
        executorService.execute(enter);
        executorService.execute(enter);
        executorService.execute(enter);
        executorService.execute(enter);
        executorService.execute(enter);

        executorService.execute(leave);
        executorService.execute(leave);

        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }

        System.out.println("Available: " + parkingGarage.getAvailable());
        System.out.println("The number of cars in the parking garage: " + (parkingGarage.getCapacity() - parkingGarage.getAvailable()));

    }
}

class ParkingGarage {
    private int capacity; //
    private int available; //

    public ParkingGarage(int capacity) {
        this.capacity = capacity;
        this.available = capacity;
    }

    public synchronized void enter() {
        while (available == 0) { // neu bai do xe day
            try {
                System.out.println("The parking garage is full");
                wait(); // cho den khi co xe ra
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (available > 0) { //
            available--;
            System.out.println("A car is entering the parking garage");
            notifyAll();
        }
    }

    public synchronized void leave() {
        while (available == capacity) { //
            try {
                System.out.println("The parking garage is empty");
                wait(); // cho den khi co xe vao
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (available < capacity) { //
            available++;
            System.out.println("A car is leaving the parking garage");
            notifyAll();
        }
    }

    public int getAvailable() {
        return available;
    }

    public int getCapacity() {
        return capacity;
    }
}
