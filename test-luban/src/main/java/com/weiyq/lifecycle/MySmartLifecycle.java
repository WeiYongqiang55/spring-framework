package com.weiyq.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.SmartLifecycle;

public class MySmartLifecycle implements SmartLifecycle {

    boolean flag =false; //表示是不是正在running
    /**
     * Returns {@code true} if this {@code Lifecycle} component should get
     * started automatically by the container at the time that the containing
     * {@link ApplicationContext} gets refreshed.
     * <p>A value of {@code false} indicates that the component is intended to
     * be started through an explicit {@link #start()} call instead, analogous
     * to a plain {@link Lifecycle} implementation.
     *
     * @see #start()
     * @see #getPhase()
     * @see LifecycleProcessor#onRefresh()
     * @see ConfigurableApplicationContext#refresh()
     */
    @Override
    public boolean isAutoStartup() {
        return true;
    }

    /**
     * Indicates that a Lifecycle component must stop if it is currently running.
     * <p>The provided callback is used by the {@link LifecycleProcessor} to support
     * an ordered, and potentially concurrent, shutdown of all components having a
     * common shutdown order value. The callback <b>must</b> be executed after
     * the {@code SmartLifecycle} component does indeed stop.
     * <p>The {@link LifecycleProcessor} will call <i>only</i> this variant of the
     * {@code stop} method; i.e. {@link Lifecycle#stop()} will not be called for
     * {@code SmartLifecycle} implementations unless explicitly delegated to within
     * the implementation of this method.
     *
     * @param callback
     * @see #stop()
     * @see #getPhase()
     */
    @Override
    public void stop(Runnable callback) {
        System.out.println("runable stop");
        flag= false;
//        加上这一句，调用stop不会等30秒了，马上结束。如果不加调用stop方法后还要再等等待30秒才会停止容器
        callback.run();
    }

    /**
     * Start this component.
     * <p>Should not throw an exception if the component is already running.
     * <p>In the case of a container, this will propagate the start signal to all
     * components that apply.
     *
     * @see SmartLifecycle#isAutoStartup()
     */
    @Override
    public void start() {
        System.out.println("smart life cycle start");
        flag = true;
    }

    /**
     * Stop this component, typically in a synchronous fashion, such that the component is
     * fully stopped upon return of this method. Consider implementing {@link SmartLifecycle}
     * and its {@code stop(Runnable)} variant when asynchronous stop behavior is necessary.
     * <p>Note that this stop notification is not guaranteed to come before destruction: On
     * regular shutdown, {@code Lifecycle} beans will first receive a stop notification before
     * the general destruction callbacks are being propagated; however, on hot refresh during a
     * context's lifetime or on aborted refresh attempts, only destroy methods will be called.
     * <p>Should not throw an exception if the component isn't started yet.
     * <p>In the case of a container, this will propagate the stop signal to all components
     * that apply.
     *
     * @see SmartLifecycle#stop(Runnable)
     * @see DisposableBean#destroy()
     */
    @Override
    public void stop() {
        System.out.println("smart life cycle stop");
        flag = false;
    }

    /**
     * Check whether this component is currently running.
     * <p>In the case of a container, this will return {@code true} only if <i>all</i>
     * components that apply are currently running.
     *
     * @return whether the component is currently running
     */
    @Override
    public boolean isRunning() {
        return flag;
    }

    /**
     * Return the phase value of this object.  优先级 越小优先级越大
     */
    @Override
    public int getPhase() {
        return 0;
    }
}
