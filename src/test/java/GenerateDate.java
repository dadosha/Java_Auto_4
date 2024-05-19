import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GenerateDate {
    public String dateCreate(long days) {
        LocalDate timeNow = LocalDate.now().plusDays(days);
        return timeNow.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public List<String> dateTimestampSevenDays() {
        LocalDate timeNow = LocalDate.now().plusDays(7);
        Instant instant = timeNow.atStartOfDay(ZoneId.systemDefault()).toInstant();
        return List.of(String.valueOf(instant.getEpochSecond() * 1000), timeNow.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
    }
}
