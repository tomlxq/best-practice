package com.example.date;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * SimpleDateFormat 是线程不安全的类，一般不要定义为 static 变量，如果定义为 static，必须
 * 加锁，或者使用 DateUtils 工具类
 *
 * @author TomLuo
 * @date 2023年03月26日 22:32
 */
public class SimpleDateFormatDemo {


    private static final ThreadLocal<SimpleDateFormat> DATE_FORMAT = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));

    /**
     * 使用 ThreadLocal
     * 使用 ThreadLocal 来保证 SimpleDateFormat 的线程安全性，这样每个线程都会获取到自己的 SimpleDateFormat 实例。示例代码如下：
     * @param date
     * @return
     */
    public static String formatDateWithThreadLocal(Date date) {
        SimpleDateFormat formatter = DATE_FORMAT.get();
        return formatter.format(date);
    }

    private static final SimpleDateFormat DATE_FORMAT2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    /**
     * 使用同步方法或代码块
     * 另一种解决方案是使用同步方法或代码块来保证线程安全
     * @param date
     * @return
     */
    public static synchronized String formatDateWithSynchronized(Date date) {
        return DATE_FORMAT2.format(date);
    }
    public static String formatDateWithDateFormatUtil(Date date) {
        return DateFormatUtils.format(date, "yyyy-MM-dd hh:mm:ss");
    }

    /**
     * JDK 8 引入了一组新的时间和日期 API，包括 Instant、LocalDate、LocalDateTime、ZonedDateTime 等类，这些类在性能、可读性、健壮性等方面均优于原来的时间类（如 Date、Calendar、SimpleDateFormat 等）。
     *
     * 其中 Instant 类是代替 Date 的推荐类，它表示时间轴上的一个瞬时点，可以精确到纳秒级别。LocalDateTime 类是代替 Calendar 的推荐类，它表示一个没有时区偏移量的日期和时间，可以轻松地进行日期计算和格式化。DateTimeFormatter 类是代替 SimpleDateFormat 的推荐类，它提供了一种线程安全的方式来格式化和解析日期/时间字符串，并且支持自定义格式。
     *
     * 相对于旧的时间和日期类，新的 API 更加可读、健壮、灵活和线程安全。例如，对于线程安全，这些新的 API 中的绝大多数类都是不可变的（Immutable），并且严格限制了可变状态的修改，这样就可以在多线程环境下安全地共享，避免了并发问题的产生。
     */
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC);
    public static String formatDate(Instant instant) {
        return FORMATTER.format(instant);
    }

    public static Instant parseDate(String dateStr) {
        return FORMATTER.parse(dateStr, Instant::from);
    }
}