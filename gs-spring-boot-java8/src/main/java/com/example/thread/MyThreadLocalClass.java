package com.example.thread;

/**
 * 在使用 ThreadLocal 时，必须注意回收当前线程所绑定的 ThreadLocal 变量，尤其是在使用线程池的情况下，线程会被复用，
 * 如果不清理 ThreadLocal 变量，可能会影响后续业务逻辑和造成内存泄漏等问题。
 *
 * @author TomLuo
 * @date 2023年03月26日 22:52
 */
public class MyThreadLocalClass {
    private static final ThreadLocal<Object> MY_THREAD_LOCAL = new ThreadLocal<>();

    public static void set(Object value) {
        MY_THREAD_LOCAL.set(value);
    }

    public static Object get() {
        return MY_THREAD_LOCAL.get();
    }

    /**
     * 新的方法 remove()，用于清除当前线程的 ThreadLocal 变量
     */
    public static void remove() {
        MY_THREAD_LOCAL.remove();
    }
}