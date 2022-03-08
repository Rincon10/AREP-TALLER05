package edu.escuelaing.arep.threads;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 3/7/2022
 * @project App
 */
public class HelloThread extends Thread {
    public static List<Thread> threadList = new LinkedList<>();

    @Override
    public void run() {
        System.out.println("Hello from a thread a thread object: " + this.toString());
    }

    public static void main(String[] args) {
        Integer i = 5;
        while (i > 0) {
            Thread t = new HelloThread();
            t.start();
            threadList.add(t);
            i--;
        }
        System.out.println("Hello from main: " + Thread.currentThread().toString());
        threadList.forEach( thread -> {
            System.out.println("Stack trace" + thread.getState());
        });
    }
}
