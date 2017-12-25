package idv.carl.scjp.datetime;

import java.time.*;

/**
 * @author Carl Lu
 */
public class DateTimeDemo {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.of(2017, Month.JUNE, 15, 13, 39);
        Instant instant = dateTime.atZone(ZoneId.of("Europe/Paris")).toInstant();
        System.out.println(instant); // 2017-06-15T11:39:00Z

        Instant nowInstant = Instant.now();
        final ZoneId zoneidPlus8 = ZoneId.of("UTC+8");
        final LocalDateTime nowLocalDateTime = LocalDateTime.ofInstant(nowInstant, zoneidPlus8);
        final ZoneOffset zoneid8hr1 = (ZoneOffset) ZoneId.of("+8");

        final Instant nowLocalDateTimeToInstant = nowLocalDateTime.toInstant(zoneid8hr1);
        System.out.println(nowLocalDateTimeToInstant);

        final ZonedDateTime currentPoint = ZonedDateTime.now(Clock.system(ZoneId.of("Asia/Taipei")));

        final MonthDay birthday = MonthDay.of(11, 4);
    }
}
