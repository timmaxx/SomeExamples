package multithread.p01;

public class MyThread extends Thread {
    public void run() {
        // некоторое долгое действие, вычисление
        long sum=0;
        for (int i=0; i<1000; i++) {
            sum+=i;
        }
        System.out.println(sum);
    }
}