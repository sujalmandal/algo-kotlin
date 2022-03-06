package algorithms.java;

public class JavaThreads {
    public static void main(String[] args) throws InterruptedException {
        final Object mutex = new Object();
        Thread t1 = new Thread(()->{
            try {
                runConcurrently1(mutex);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();

        Thread t2 = new Thread(()->{
            try {
                runConcurrently2(mutex);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.start();

        t1.join();
        t2.join();
    }

    public static void runConcurrently1(Object mutex) throws InterruptedException {
        synchronized (mutex){
            System.out.println("entered : 1");
            Thread.sleep(1000);
            mutex.wait();
            System.out.println("resumed : 1");
            mutex.notify();
        }
    }


    public static void runConcurrently2(Object mutex) throws InterruptedException {
        synchronized (mutex){
            System.out.println("entered : 2");
            Thread.sleep(2000);
            //mutex.notify();
            //Thread.sleep(3000);
            mutex.notify();
            mutex.wait();
            System.out.println("finished : 2");
        }
    }
}
