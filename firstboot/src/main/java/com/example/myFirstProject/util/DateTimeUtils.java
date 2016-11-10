package com.example.myFirstProject.util;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;
import java.util.TimeZone;

/**
 * Created by bjxiaojian on 2016/9/1.
 */
public class DateTimeUtils {

    private static final DateTimeFormatter fmt_yyyyMMddHHmmssSSS = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS");
    private static final DateTimeFormatter fmt_yyyyMMddHHmmss = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter fmt_yyyyMMddHHmm = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
    private static final DateTimeFormatter fmt_yyyyMMdd = DateTimeFormat.forPattern("yyyy-MM-dd");
    private static final DateTimeFormatter fmt_HHmmss = DateTimeFormat.forPattern("HH:mm:ss");
    private static final DateTimeFormatter fmt_HHmm = DateTimeFormat.forPattern("HH:mm");

    private static final DateTimeFormatter fmt_yyyyMMddHHmmss_noSplit = DateTimeFormat.forPattern("yyyyMMddHHmmss");
    private static final DateTimeFormatter fmt_yyyyMMddHHmm_noSplit = DateTimeFormat.forPattern("yyyyMMddHHmm");
    private static final DateTimeFormatter fmt_yyyyMMdd_noSplit = DateTimeFormat.forPattern("yyyyMMdd");
    private static final DateTimeFormatter fmt_HHmmss_noSplit = DateTimeFormat.forPattern("HHmmss");
    private static final DateTimeFormatter fmt_HHmm_noSplit = DateTimeFormat.forPattern("HHmm");

    private static final DateTimeFormatter fmt_YYYYMMDDHHMM = DateTimeFormat.forPattern("yyyyMMdd HH:mm");

    private static final DateTimeZone timeZone = DateTimeZone.forTimeZone(TimeZone.getTimeZone("GMT+8"));

    public static String fmtYyyyMMddHHmmss(DateTime d) {
        return fmt_yyyyMMddHHmmss.print(d.withZone(timeZone));
    }

    public static String fmtYyyyMMddHHmm(DateTime d) {
        return fmt_yyyyMMddHHmm.print(d.withZone(timeZone));
    }

    public static String fmtYyyyMMdd(DateTime d) {
        return fmt_yyyyMMdd.print(d.withZone(timeZone));
    }

    public static String fmtHHmmss(DateTime d) {
        return fmt_HHmmss.print(d.withZone(timeZone));
    }

    public static String fmtHHmm(DateTime d) {
        return fmt_HHmm.print(d.withZone(timeZone));
    }

    // 无分隔符
    public static String fmtYyyyMMddHHmmss_noSplit(DateTime d) {
        return fmt_yyyyMMddHHmmss_noSplit.print(d.withZone(timeZone));
    }

    public static String fmtYyyyMMddHHmm_noSplit(DateTime d) {
        return fmt_yyyyMMddHHmm_noSplit.print(d.withZone(timeZone));
    }

    public static String fmtYyyyMMdd_noSplit(DateTime d) {
        return fmt_yyyyMMdd_noSplit.print(d.withZone(timeZone));
    }

    public static String fmtHHmmss_noSplit(DateTime d) {
        return fmt_HHmmss_noSplit.print(d.withZone(timeZone));
    }

    public static String fmtHHmm_noSplit(DateTime d) {
        return fmt_HHmm_noSplit.print(d.withZone(timeZone));
    }

    public static DateTime parseYyyyMMddHHmmssSSS(String str) {
        DateTime d = fmt_yyyyMMddHHmmssSSS.parseDateTime(str);
        return d;
    }

    public static DateTime parseYyyyMMddHHmmss(String str) {
        DateTime d = fmt_yyyyMMddHHmmss.parseDateTime(str);
        return d;
    }

    public static DateTime parseYyyyMMddHHmm(String str) {
        DateTime d = fmt_yyyyMMddHHmm.parseDateTime(str);
        return d;
    }

    public static DateTime parseYYYYMMDDHHMM(String str) {
        DateTime d = fmt_YYYYMMDDHHMM.parseDateTime(str);
        return d;
    }

    public static DateTime parseYyyyMMdd(String str) {
        DateTime d = fmt_yyyyMMdd.parseDateTime(str);
        return d;
    }

    public static DateTime parseHHmmss(String str) {
        DateTime d = fmt_HHmmss.parseDateTime(str);
        return d;
    }

    public static DateTime parseHHmm(String str) {
        DateTime d = fmt_HHmm.parseDateTime(str);
        return d;
    }

    public static DateTime parseYyyyMMddHHmmss_noSplit(String str) {
        DateTime d = fmt_yyyyMMddHHmmss_noSplit.parseDateTime(str);
        return d;
    }

    public static DateTime parseYyyyMMddHHmm_noSplit(String str) {
        DateTime d = fmt_yyyyMMddHHmm_noSplit.parseDateTime(str);
        return d;
    }

    public static DateTime parseYyyyMMdd_noSplit(String str) {
        DateTime d = fmt_yyyyMMdd_noSplit.parseDateTime(str);
        return d;
    }

    public static DateTime parseHHmmss_noSplit(String str) {
        DateTime d = fmt_HHmmss_noSplit.parseDateTime(str);
        return d;
    }

    public static DateTime parseHHmm_noSplit(String str) {
        DateTime d = fmt_HHmm_noSplit.parseDateTime(str);
        return d;
    }

    /**
     * 判断被测试的日期是否在两个给定的日期范围内。
     *
     * @param testDate  被测试的日期
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return
     */
    public static boolean isInDateRange(DateTime testDate, DateTime startDate, DateTime endDate) {

        if (testDate == null) {
            return false;
        }

        if (startDate == null && endDate == null) {
            return true;
        }

        if (startDate != null && endDate == null) {
            return (testDate.compareTo(startDate) >= 0);
        }

        if (startDate == null && endDate != null) {
            return (testDate.compareTo(endDate) <= 0);
        }

        if (startDate != null && endDate != null) {
            return ((testDate.compareTo(startDate) >= 0) && (testDate.compareTo(endDate) <= 0));
        }

        return false;
    }

    public static DateTime plusSeconds(Date date, int seconds) {
        return toDateTime(date).plusSeconds(seconds);
    }

    public static DateTime toDateTime(Date date) {
        if (date == null) {
            return null;
        }
        return new DateTime().withMillis(date.getTime());
    }

    public static String format2String(Date date, String pattern) {
        if (date == null || StringUtils.isEmpty(pattern)) {
            return null;
        }
        DateTime datetime = formatDate2DT(date);
        return format2String(datetime, pattern);
    }

    public static DateTime formatDate2DT(Date date) {
        if (date == null) {
            return null;
        }
        return DateTime.now().withMillis(date.getTime());
    }

    public static String format2String(DateTime time, String pattern) {
        if (time == null || StringUtils.isEmpty(pattern)) {
            return null;
        }
        return time.toString(pattern);
    }
}
