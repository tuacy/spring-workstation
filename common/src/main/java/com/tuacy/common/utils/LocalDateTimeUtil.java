package com.tuacy.common.utils;


import com.google.common.collect.Lists;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * LocalDataTime 相关的一些工具类
 *
 * @author wuyx
 * @version 1.0
 * @date 2021/5/23 8:51
 */
public class LocalDateTimeUtil {

    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter DATETIME_FORMATTER_0 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    public static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 获取当前系统时间
     *
     * @return 当前系统时间
     */
    public static LocalTime getLocalTime() {
        return LocalTime.now();
    }

    /**
     * 获取当前系统日期
     *
     * @return 当前系统日期
     */
    public static LocalDate getLocalDate() {
        return LocalDate.now();
    }

    /**
     * 获取当前系统日期时间
     *
     * @return 当前系统日期时间
     */
    public static LocalDateTime getLocalDateTime() {
        return LocalDateTime.now();
    }

    /**
     * 获取当前系统日期时间毫秒数
     *
     * @return 当前系统日期时间毫秒数
     */
    public static long getLocalDateTimeStamp() {
        //获取毫秒数
        return LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    /**
     * 时间戳转LocalDateTime字符串时间格式
     *
     * @return 时间戳转LocalDateTime字符串时间格式
     */
    public static String getLocalDateTimeStringtime(long time) {
        return LocalDateTime.ofEpochSecond(time / 1000, 0, ZoneOffset.ofHours(8)).format(DATETIME_FORMATTER);
    }

    /**
     * LocalDateTime转时间戳
     *
     * @return LocalDateTime转时间戳
     */
    public static long getLocalDateTimeToMstime(LocalDateTime time) {
        return time.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }


    /**
     * 获取当前系统时间字符串
     *
     * @return 当前系统时间字符串
     */
    public static String getLocalTimeString() {
        return LocalTime.now().format(TIME_FORMATTER);
    }

    /**
     * 获取当前系统时间字符串
     *
     * @param formatter 时间格式化字符串
     * @return 当前系统时间字符串
     */
    public static String getLocalTimeString(String formatter) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(formatter);
        return LocalTime.now().format(dateTimeFormatter);
    }

    /**
     * 获取当前系统日期字符串
     *
     * @return 当前系统日期字符串
     */
    public static String getLocalDateString() {
        return LocalDate.now().format(DATE_FORMATTER);
    }

    /**
     * LocalDateTime转日期时间字符串
     *
     * @return LocalDateTime转日期时间字符串
     */
    public static String localDateTime2String(LocalDateTime localDateTime) {
        return localDateTime.format(DATETIME_FORMATTER);
    }

    /**
     * 获取当前系统日期时间字符串
     *
     * @return 当前系统日期时间字符串
     */
    public static String localDateTime2String() {
        return LocalDateTime.now().format(DATETIME_FORMATTER);
    }

    /**
     * 获取当前系统日期字符串
     *
     * @return 当前系统日期时间字符串
     */
    public static String localDate2String(LocalDate localDate) {
        return localDate.format(DATE_FORMATTER);
    }

    /**
     * 字符串转LocalTime
     *
     * @param time LocalTime对应字符串
     * @return LocalTime
     */
    public static LocalTime string2LocalTime(String time) {
        return LocalTime.parse(time, TIME_FORMATTER);
    }

    /**
     * 字符串转LocalDate
     *
     * @param date LocalDate对应字符串
     * @return LocalDate
     */
    public static LocalDate string2LocalDate(String date) {
        return LocalDate.parse(date, DATE_FORMATTER);
    }

    /**
     * 字符串转LocalDate
     *
     * @param date      LocalDate对应字符串
     * @param formatter 格式化字符串
     * @return LocalDate
     */
    public static LocalDate string2LocalDate(String date, String formatter) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(formatter);
        return LocalDate.parse(date, dateTimeFormatter);
    }

    /**
     * 字符串转LocalDateTime
     *
     * @param dateTime LocalDateTime对应字符串
     * @return LocalDateTime
     */
    public static LocalDateTime string2LocalDateTime(String dateTime) {
        if ("yyyy-MM-dd HH:mm".length() == dateTime.length()) {
            return LocalDateTime.parse(dateTime, DATETIME_FORMATTER_0);
        }
        return LocalDateTime.parse(dateTime, DATETIME_FORMATTER);
    }

    /**
     * 字符串转LocalDateTime
     *
     * @param dateTime  LocalDateTime对应字符串
     * @param formatter 时间格式化字符串
     * @return LocalDateTime
     */
    public static LocalDateTime string2LocalDateTime(String dateTime, String formatter) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(formatter);
        return LocalDateTime.parse(dateTime, dateTimeFormatter);
    }

    /**
     * Date转LocalDateTime
     *
     * @param date Date
     * @return LocalDateTime
     */
    public static LocalDateTime date2LocalDateTime(Date date) {
        //An instantaneous point on the time-line.(时间线上的一个瞬时点。)
        Instant instant = date.toInstant();
        //A time-zone ID, such as {@code Europe/Paris}.(时区)
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDateTime();
    }

    /**
     * Date转LocalDate
     *
     * @param date date
     * @return LocalDate
     */
    public static LocalDate date2LocalDate(Date date) {
        //An instantaneous point on the time-line.(时间线上的一个瞬时点。)
        Instant instant = date.toInstant();
        //A time-zone ID, such as {@code Europe/Paris}.(时区)
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDate();
    }

    /**
     * Date转LocalDate
     *
     * @param date date
     * @return LocalTime
     */
    public static LocalTime date2LocalTime(Date date) {
        //An instantaneous point on the time-line.(时间线上的一个瞬时点。)
        Instant instant = date.toInstant();
        //A time-zone ID, such as {@code Europe/Paris}.(时区)
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalTime();
    }

    /**
     * LocalDateTime转换为Date
     *
     * @param localDateTime LocalDateTime
     * @return Date
     */
    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        //Combines this date-time with a time-zone to create a  ZonedDateTime.
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }

    /**
     * 日期相隔天数
     *
     * @param startDateInclusive 开始日期
     * @param endDateExclusive   结束日期
     * @return 日期相隔天数
     */
    public static int periodDays(LocalDate startDateInclusive, LocalDate endDateExclusive) {
        return Period.between(startDateInclusive, endDateExclusive).getDays();
    }

    /**
     * 日期相隔小时
     *
     * @param startInclusive 开始日期
     * @param endExclusive   结束日期
     * @return 日期相隔小时
     */
    public static long durationHours(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toHours();
    }

    /**
     * 日期相隔分钟
     *
     * @param startInclusive 开始日期
     * @param endExclusive   结束日期
     * @return 日期相隔分钟
     */
    public static long durationMinutes(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toMinutes();
    }

    /**
     * 日期相隔毫秒数
     *
     * @param startInclusive 开始日期
     * @param endExclusive   结束日期
     * @return 日期相隔毫秒数
     */
    public static long durationMillis(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toMillis();
    }

    /**
     * 获取指定时间是这个月的第几周
     *
     * @param strData 时间字符串
     * @return 是当前月的第几周
     */
    public static int getWeekOfMonth(String strData) {
        return getWeekOfMonth(string2LocalDateTime(strData));
    }

    /**
     * 获取指定时间是这个月的第几周
     *
     * @param strData   时间字符串
     * @param formatter 时间格式
     * @return 是当前月的第几周
     */
    public static int getWeekOfMonth(String strData, String formatter) {
        return getWeekOfMonth(string2LocalDateTime(strData, formatter));
    }

    /**
     * 获取指定时间是这个月的第几周
     *
     * @param date 时间
     * @return 是当前月的第几周
     */
    public static int getWeekOfMonth(LocalDateTime date) {
        // 将字符串格式化
        Calendar calendar = Calendar.getInstance();
        // 设置星期一才是一周的第一天
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(localDateTime2Date(date));
        return calendar.get(Calendar.WEEK_OF_MONTH);
    }

    /**
     * 获取当前时间所在月份,所在周的每天
     *
     * @param date 指定时间所在的周
     * @return 当前时间所在月份, 所在周的每天
     */
    public static List<LocalDateTime> getMonthWeekDayList(String date) {
        return getMonthWeekDayList(LocalDateTimeUtil.string2LocalDateTime(date));
    }

    /**
     * 获取当前时间所在月份,所在周的每天
     *
     * @param date 指定时间所在的周
     * @return 当前时间所在月份, 所在周的每天
     */
    public static List<LocalDateTime> getMonthWeekDayList(LocalDateTime date) {
        Calendar currentCal = Calendar.getInstance();
        currentCal.setTime(localDateTime2Date(date));
        // 当月第一天
        LocalDateTime monthFirstDay = date.with(TemporalAdjusters.firstDayOfMonth())
                .withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);
        // 当月最后一天
        LocalDateTime monthLastDay = date.with(TemporalAdjusters.lastDayOfMonth())
                .withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);

        // 前后7天
        LocalDateTime startDay = date.plusDays(-7);
        if (startDay.isBefore(monthFirstDay)) {
            startDay = monthFirstDay;
        }
        LocalDateTime endDay = date.plusDays(7);
        if (endDay.isAfter(monthLastDay)) {
            endDay = monthLastDay;
        }

        List<LocalDateTime> retList = Lists.newArrayList();
        // 当前日期在这个月的第几周
        int weekOfMonth = getWeekOfMonth(date);
        while (!startDay.isAfter(endDay)) {
            if (weekOfMonth == getWeekOfMonth(startDay)) {
                retList.add(startDay);
            }
            startDay = startDay.plusDays(1);
        }

        return retList;
    }

    /**
     * 获取当前时间所在月份,所在周的每天
     *
     * @param date 指定时间所在的周
     * @return 当前时间所在月份, 所在周的每天
     */
    public static List<LocalDateTime> getMonthDayList(String date) {
        return getMonthDayList(LocalDateTimeUtil.string2LocalDateTime(date));
    }

    /**
     * 获取当前时间所在月份,所在周的每天
     *
     * @param date 指定时间所在的周
     * @return 当前时间所在月份, 所在周的每天
     */
    public static List<LocalDateTime> getMonthDayList(LocalDateTime date) {
        Calendar currentCal = Calendar.getInstance();
        currentCal.setTime(localDateTime2Date(date));
        // 当月第一天
        LocalDateTime monthFirstDay = date.with(TemporalAdjusters.firstDayOfMonth())
                .withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);
        // 当月最后一天
        LocalDateTime monthLastDay = date.with(TemporalAdjusters.lastDayOfMonth())
                .withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);

        List<LocalDateTime> retList = Lists.newArrayList();
        while (!monthFirstDay.isAfter(monthLastDay)) {
            retList.add(monthFirstDay);
            monthFirstDay = monthFirstDay.plusDays(1);
        }

        return retList;
    }

}
