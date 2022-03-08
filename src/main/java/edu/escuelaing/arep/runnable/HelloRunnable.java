package edu.escuelaing.arep.runnable;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 3/7/2022
 * @project App
 */
public class HelloRunnable implements Runnable {
    public void run() {
        System.out.println("Hello from Runnable");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread( new HelloRunnable());
        t.start();
        try {
            t.join();// hace que el hilo main espere hasta que el hilo anterior termine
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello From main: " + Thread.currentThread());

    }
}
