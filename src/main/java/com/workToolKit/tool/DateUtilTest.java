package com.workToolKit.tool;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

public class DateUtilTest {

    public static void main(String[] args) {

        String zeroDate = "2021-02-22";
        String dateStr2 = "2021-01-06";
        String dateStr3 = "2021-02-03";
        String dateStr4 = "2021-03-15";
        String dateStr5 = "2021-05-21";

        LocalDate parseZeroDate = LocalDate.parse(zeroDate);
        LocalDate parse2 = LocalDate.parse(dateStr2);
        LocalDate parse3 = LocalDate.parse(dateStr3);
        LocalDate parse4 = LocalDate.parse(dateStr4);
        LocalDate parse5 = LocalDate.parse(dateStr5);
        //long between = ChronoUnit.DAYS.between(parse1, parse2);


        List<LocalDate> paymentSchedules = new ArrayList<>();
        paymentSchedules.add(parse2);
        paymentSchedules.add(parse3);
        paymentSchedules.add(parse4);
        paymentSchedules.add(parse5);

        List<BigDecimal> rateLists = Arrays.asList(new BigDecimal("0.5"),new BigDecimal("0.5"),new BigDecimal("0.5"),new BigDecimal("0.5"));


        AtomicBoolean zeroDateFlag = new AtomicBoolean(true);

        IntStream.range(0, paymentSchedules.size()).forEach(i -> {
            long between = 0L;
            if (zeroDateFlag.get()) {
                between = ChronoUnit.DAYS.between(parseZeroDate, paymentSchedules.get(i));
                if (between > 0) {
                    zeroDateFlag.set(false);
                }
            } else {
                between = ChronoUnit.DAYS.between(paymentSchedules.get(i - 1), paymentSchedules.get(i));
            }
            between = between <= 0 ? 0L : between;

            BigDecimal result = new BigDecimal(String.valueOf(between)).divide(new BigDecimal(365), 8, RoundingMode.HALF_UP);

            rateLists.set(i, rateLists.get(i).
                    multiply(result).setScale(8, RoundingMode.HALF_UP));
        });
    }
}
