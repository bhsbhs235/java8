package org.example;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DatePractice {

    public void go(){
        // Date 는 쓰레드 세이프 하지 않다.
        // Date(1,2,4,5) month는 0부터 1월달인데 등등 불편한게 많다. type 세이프 하지 않다.

        /*Instant instant = Instant.now(); // 기준시

        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);
        ZonedDateTime zonedDateTime = instant.atZone(zoneId);
        System.out.println(zonedDateTime);*/

        /*LocalDateTime now = LocalDateTime.now(); // 실행하는 서버의 존으로 시간이 검색됨
        LocalDateTime birthDat = LocalDateTime.of(1994, Month.MARCH, 2, 7, 0, 0);
        System.out.println(now);

        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));*/

        /*LocalDate today = LocalDate.now();
        LocalDate thisYearBirthDay = LocalDate.of(2023, Month.MARCH, 2);

        Period period = Period.between(today, thisYearBirthDay);
        System.out.println(period);

        Period until = today.until(thisYearBirthDay);
        System.out.println(until.get(ChronoUnit.DAYS));*/

        /*LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter MMddyyyy =  DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter iso = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        System.out.println(now.format(MMddyyyy));
        System.out.println(now.format(iso));

        LocalDate parse = LocalDate.parse("03/02/1994", MMddyyyy);
        System.out.println(parse);*/

    }
}
