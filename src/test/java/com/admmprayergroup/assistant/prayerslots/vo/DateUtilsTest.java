package com.admmprayergroup.assistant.prayerslots.vo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class DateUtilsTest {

    @Test
    void shouldCheckTheFirstDayIsThePrayerStartingDate() {
        LocalDate prayerStartingDate = LocalDate.of(2021, 5, 24);
        LocalDate date = DateUtils.getDate(1L);
        Assertions.assertEquals(prayerStartingDate, date);
    }

    @Test
    void shouldCheckPrayerStartingDateIsTheFirstDay() {
        LocalDate date = LocalDate.of(2021, 5, 24);
        Long dayCount = DateUtils.getDayCount(date);
        Assertions.assertEquals(1, dayCount);
    }

}
