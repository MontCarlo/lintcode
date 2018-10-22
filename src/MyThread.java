
public class MyThread implements Runnable {
    String name;

    Object lock1;

    Object lock2;

    
    public MyThread(String name, Object lock1, Object lock2) {
        this.name = name;
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        int count = 10;
        while(count > 0) {
            synchronized (lock1) {
                synchronized (lock2) {
                    System.out.println(name);
                    count --;
                    
                    lock2.notifyAll();
                }
                try {
                    lock1.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }


    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        MyThread threadA = new MyThread("A", b, c);
        MyThread threadB = new MyThread("B", c, a);
        MyThread threadC = new MyThread("C", a, b);
        new Thread(threadA).start();
        Thread.sleep(100);
        new Thread(threadB).start();
        Thread.sleep(100);
        new Thread(threadC).start();
    }

}
