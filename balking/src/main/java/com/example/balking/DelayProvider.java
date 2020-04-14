package com.example.balking;


import java.util.concurrent.TimeUnit;

/**
 * 接口模拟执行一些延迟工作
 */
public interface DelayProvider {
    /**
     *
     * @param interval 间隔
     * @param timeUnit 时间
     * @param task     任务
     */
    void executeAfterDelay(long interval, TimeUnit timeUnit, Runnable task);

}
