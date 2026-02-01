package com.aditya.multithreading;

public class ThreadExample {
    public static void main(String[] args) {
        // using thread class
        class MyThread extends Thread {
            @Override
            public void run() {
                for(int i = 0; i < 5; i++){
                    System.out.println(Thread.currentThread().getName() + " - " + i);
                    try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }

        // using runnable interface
        class MyRunnable implements Runnable{

            @Override
            public void run() {
                for(int i = 0; i < 5; i++){
                    System.out.println(Thread.currentThread().getName() + " - " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        MyThread thread1 = new MyThread();
        Thread thread2 = new Thread(new MyRunnable());


        // Starting the threads
        thread1.start();
        thread2.start();
    }
}
