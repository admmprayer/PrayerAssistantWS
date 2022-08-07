package com.admmprayergroup.assistant.prayerslots.vo;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public final class DateUtils {

    private static final LocalDate prayerStartDate = LocalDate.of(2021, Month.MAY, 24);

    private DateUtils() {
    }

    public static LocalDate getDate(Long dayCount) {
        return prayerStartDate.plusDays(dayCount).minusDays(1);
    }

    public static Long getDayCount(LocalDate date) {
        return ChronoUnit.DAYS.between(prayerStartDate, date) + 1;
    }

}
