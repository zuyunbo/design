/*
 * The MIT License
 * Copyright © 2014-2019 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.example.balking;

import java.util.concurrent.TimeUnit;

import com.example.balking.WashingMachineState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 洗衣机
 * Washing machine class.
 */
public class WashingMachine {

    private static final Logger LOGGER = LoggerFactory.getLogger(WashingMachine.class);
    private final DelayProvider delayProvider;
    private WashingMachineState washingMachineState;
    final Object lock;


    /**
     * Creates a new instance of WashingMachine.
     * (long interval, TimeUnit timeUnit, Runnable task) -> {
     * try {
     * Thread.sleep(timeUnit.toMillis(interval));
     * } catch (InterruptedException ie) {
     * ie.printStackTrace();
     * }
     * task.run();
     * }
     */
    public WashingMachine() {

        this(new DelayProvider() {
            @Override
            public void executeAfterDelay(long interval, TimeUnit timeUnit, Runnable task) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
                task.run();
            }
        });

    }

    /**
     * Creates a new instance of WashingMachine using provided delayProvider. This constructor is used
     * only for unit testing purposes.
     */
    public WashingMachine(DelayProvider delayProvider) {
        this.delayProvider = delayProvider;
        this.washingMachineState = WashingMachineState.ENABLED;
        this.lock = new Object();

    }

    public WashingMachineState getWashingMachineState() {
        return washingMachineState;
    }

    /**
     * *如果物体处于适当状态，则负责洗涤的方法
     * Method responsible for washing if the object is in appropriate state.
     */
    public void wash() {
        synchronized (lock) {
            WashingMachineState machineState = getWashingMachineState();
            LOGGER.info("{}: 机器状态: {}", Thread.currentThread().getName(), machineState);
            while (this.washingMachineState == WashingMachineState.WASHING) {
                try {
                    LOGGER.error("我在等待状态!");

                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                LOGGER.error("ERROR: Cannot wash if the machine has been already washing!");
            }
            this.washingMachineState = WashingMachineState.WASHING;
        }
        LOGGER.info("{}: 洗衣服", Thread.currentThread().getName());

        this.delayProvider.executeAfterDelay(1, TimeUnit.NANOSECONDS, this::endOfWashing);
    }

    /**
     * 通过更改机器状态来结束清洗的方法
     * Method responsible of ending the washing by changing machine state.
     */
    public synchronized void endOfWashing() {
        washingMachineState = WashingMachineState.ENABLED;
        this.await();
        LOGGER.info("{}: Washing completed.", Thread.currentThread().getId());
    }


    public void await() {
        synchronized (lock) {
            System.out.println("我要开始唤醒了");
            lock.notifyAll();
        }
    }


}
