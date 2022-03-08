package edu.escuelaing.arep;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 3/7/2022
 * @project App
 */
public class HelloRunnable implements Runnable {
    public void run() {
        System.out.println("Hello from Runnable "+ Thread.currentThread());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Integer n = 100;
        ExecutorService pool = Executors.newFixedThreadPool(10);
        while ( n>0){
            pool.submit(new HelloRunnable());
            n++;
        }
        System.out.println("Hello From main: " + Thread.currentThread());

    }
}
