import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1115. 交替打印FooBar
 */
public class PrintFooBarAlternately_1115 {}

class FooBar {
    private int n;

    private AtomicInteger flag;

    public FooBar(int n) {
        this.n = n;
        this.flag = new AtomicInteger(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (flag.get() == 1) {
                Thread.yield();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            flag.set(1);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (flag.get() == 0) {
                Thread.yield();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            flag.set(0);
        }
    }
}

class FooBar1 {
    private ReentrantLock lock = new ReentrantLock();
    private Condition fooCondition = lock.newCondition();
    private Condition barCondition = lock.newCondition();
    private int count = 1;
    private int n;

    public FooBar1(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            if(count != 1) {
                fooCondition.await();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            barCondition.signal();
            count=2;
            lock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            if(count != 2) {
                barCondition.await();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooCondition.signal();
            count=1;
            lock.unlock();
        }
    }
}
