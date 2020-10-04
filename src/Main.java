import sun.util.resources.ms.CalendarData_ms_MY;

import java.util.Arrays;

public class Main {

    static final int size = 10000000;
    static final int h = size / 2;

    static void arrCalculations(float[] arr, int startIndex) {

        for (int i = 0, j = startIndex; i < arr.length; i++, j++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
        }
    }

    static void arrCalculations(float[] arr, int startIndex, int endIndex) {

        for (int i = startIndex; i < endIndex; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    public static void method1() {

        float[] arr = new float[size];

        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();

        arrCalculations(arr, 0);

        System.out.println(System.currentTimeMillis() - a);
    }

    public static void method3(int threadNumber) {

        float[] arr = new float[size];

        Arrays.fill(arr, 1);

        int remainder = arr.length % threadNumber;
        int elementNumber = size / threadNumber;

        long a = System.currentTimeMillis();

        Thread[] threads = new Thread[threadNumber];

        for (int i = 0; i < remainder; i++) {

            int startIndex = i * (elementNumber + 1);
            int endIndex = startIndex + elementNumber + 1;

            threads[i] = new Thread(() -> {
                arrCalculations(arr, startIndex, endIndex);
            }
            );
        }

        for (int i = remainder; i < threads.length; i++) {

            int startIndex = i * elementNumber;
            int endIndex = startIndex + elementNumber;

            threads[i] = new Thread(() -> {
                arrCalculations(arr, startIndex, endIndex);
            }
            );
        }

        for (Thread thread: threads) {
            thread.start();
        }

        try {
            for (Thread thread: threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(System.currentTimeMillis() - a);
    }

    public static void method2() {

        float[] arr = new float[size];

        Arrays.fill(arr, 1);

        float[] a1 = new float[h];
        float[] a2 = new float[h];

        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread t1 = new Thread(() -> {
            arrCalculations(a1, 0);
        }
        );

        Thread t2 = new Thread(() -> {
            arrCalculations(a2, h);
        }
        );

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        System.out.println(System.currentTimeMillis() - a);
    }

    public static void main(String[] args) {
        method1();
        method2();
        method3(50);


    }
}