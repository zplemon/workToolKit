package com.workToolKit.tool;

import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ser.impl.IndexedListSerializer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

public class DateUtilTest {

    public static void main(String[] args) {
        
        System.out.println("卓越3号资金信托工银理财有限责任公司-工银理财·添利宝现金管理类开放净值型理财产品5号(23GS2069)受益人本金".length());
        
        int length = "卓越3号资金信托工银理财有限责任公司-工银理财·添利宝现金管理类开放净值型理财产品5号(23GS2069)受益人本金".length();
        System.out.println("卓越3号资金信托工银理财有限责任公司-工银理财·添利宝现金管理类开放净值型理财产品5号(23GS2069)受益人本金".substring(length - 35));
        String bankName = "建设银行";
        String subBankName = "1建设银行西直门支行";
        
        System.out.println(subBankName.indexOf(bankName));
        System.out.println(subBankName.substring(subBankName.indexOf(bankName) + bankName.length()));
        
        List<BigDecimal> test2 = null;
        test2.forEach(e -> {
            System.out.println(e);
        });
        
                
                String zeroDate = "2021-02-22";
        String dateStr2 = "2021-01-06";
        String dateStr3 = "2021-02-03";
        String dateStr4 = "2021-03-15";
        String dateStr5 = "2021-05-21";
        
        BigDecimal a = BigDecimal.ZERO;
        a.add(BigDecimal.TEN);
        
        System.out.println("a = " + a);
        
        a = a.add(BigDecimal.ONE);
        System.out.println("a1 = " + a);
        
        List<BigDecimal> test = new ArrayList<>();
        //test.add(BigDecimal.ONE);
        //test.add(BigDecimal.TEN);
        BigDecimal ccc = BigDecimal.ZERO;
        ccc = test.stream().reduce(BigDecimal::add).get();
        
        System.out.println("ccc = " + ccc);

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
        
        String abc = DateUtil.yearAndQuarter(DateUtil.parseDate(dateStr5));
        
        System.out.println("abc = " + abc);
        
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
