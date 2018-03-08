package com.disney.cast.platform.vacationplanner.ui.snow.pages.common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeHelper {
    public static final String FORMAT1 = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT2 = "MMM dd, yyyy HH:mm";
    public static final String FORMAT3 = "MMM dd, yyyy";
    public static final String FORMAT4 = "HH:mm";
    public static final String FORMAT5 = "yyyy-MM-dd";

    public static String adjustTime(String time, int hours, String inputFormat) {
        return adjustTime(time, hours, inputFormat, FORMAT3);
    }

    public static String adjustTime(String time, int hours, String inputFormat, String outputFormat) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(inputFormat);
        LocalDateTime dateTime = LocalDateTime.parse(time, formatter);
        dateTime = dateTime.plusHours(hours);
        formatter = DateTimeFormatter.ofPattern(outputFormat);
        return dateTime.format(formatter);
    }

    public static String plusHour(String time, int plusHour) {
        LocalTime loca = LocalTime.parse(time);
        loca = loca.plusHours(plusHour);
        return loca.toString();
    }

    public static int daysDifference(String time, String time2) {
        String[] decTime = time.split("-");
        String[] decTime2 = time2.split("-");
        LocalDate date1 = LocalDate.of(Integer.parseInt(decTime[0]), Integer.parseInt(decTime[1]),
                Integer.parseInt(decTime[2]));
        LocalDate date2 = LocalDate.of(Integer.parseInt(decTime2[0]), Integer.parseInt(decTime2[1]),
                Integer.parseInt(decTime2[2]));

        return Math.abs(date1.getDayOfMonth() - date2.getDayOfMonth());
    }

    public static boolean time1AfterTime2(String time1, String time2, String inputFormat) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(inputFormat);
        LocalDateTime dateTime1 = LocalDateTime.parse(time1, formatter);
        LocalDateTime dateTime2 = LocalDateTime.parse(time2, formatter);
        return dateTime1.isAfter(dateTime2);
    }

    public static boolean time1AfterTime2(LocalDateTime localDate1, LocalDateTime localDate2) {
        return localDate1.isAfter(localDate2);
    }

    public static boolean date1AfterDate2(String date1, String date2) {
        String[] d2 = date2.split("/");
        LocalDate comparedDate = LocalDate.of(p(d2[2]), p(d2[0]), p(d2[1]));
        return date1AfterDate2(date1, comparedDate);
    }

    public static boolean date1AfterDate2(String date1, LocalDate date2) {
        String[] d1 = date1.split("/");
        return LocalDate.of(p(d1[2]), p(d1[0]), p(d1[1])).isAfter(date2);
    }

    public static boolean date1EqualsDate2(String date1, String date2) {
        String[] d2 = date2.split("/");
        LocalDate comparedDate = LocalDate.of(p(d2[2]), p(d2[0]), p(d2[1]));
        return date1EqualsDate2(date1, comparedDate);
    }

    public static boolean date1EqualsDate2(String date1, LocalDate date2) {
        String[] d1 = date1.split("/");
        return LocalDate.of(p(d1[2]), p(d1[0]), p(d1[1])).isEqual(date2);
    }

    private static int p(String va) {
        return Integer.parseInt(va);
    }
}
