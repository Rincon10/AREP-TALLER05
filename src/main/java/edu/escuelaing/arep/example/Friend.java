package edu.escuelaing.arep.example;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 3/7/2022
 * @project App
 */
public class Friend {
    private String name;
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public Friend(String name) {
        this.name = name;
    }

    public void bow(Friend f) {
        synchronized (lock1) {
            System.out.format("%s: %s me saludo:", name, f.getName());
            System.out.println("");
            f.bowBack(this);
        }
    }

    public void bowBack(Friend f) {
        synchronized (lock2) {
            System.out.format("%s: %s me retorono el saludo:", name, f.getName());
            System.out.println("");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Friend f1, f2;
        f1 = new Friend("f1");
        f2 = new Friend("f2");

        new Thread(new Runnable() {
            @Override
            public void run() {
                f1.bow(f2);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                f2.bow(f1);
            }
        }).start();
    }
}
