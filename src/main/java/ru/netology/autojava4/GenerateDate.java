package ru.netology.autojava4;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class GenerateDate {
    public String dateCreate(long days) {
        LocalDate timeNow = LocalDate.now().plusDays(days);
        return timeNow.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public String dateTimestampSevenDays() {
        LocalDate timeNow = LocalDate.now().plusDays(7);
        Instant instant = timeNow.atStartOfDay(ZoneId.systemDefault()).toInstant();
        return String.valueOf(instant.getEpochSecond() * 1000);
    }
}
