package javatest;

/**
 * Created by wang on 16-5-6.
 */

/**
 * 内部类在控制类框架中应用特别多
 * 下面是一个简单的例子,来自于Java编程思想
 */
public abstract class IEvent {
    protected long eventTime;
    private long delayTime;

    public IEvent(long delayTime) {
        this.delayTime = delayTime;
    }

    public void start() {
        this.eventTime = System.nanoTime() + delayTime;
        /*
         * jdk1.5 nanoTime不能按顺序正常运行
         * jdk1.8 可以正常运行
         */
       // this.eventTime = System.currentTimeMillis() + delayTime;
    }

    public boolean isReady() {
        return System.nanoTime() >= eventTime;
       // return System.currentTimeMillis() >= eventTime;
    }

    public abstract void action();
}
