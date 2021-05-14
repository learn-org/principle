package com.learn.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author: lxj
 * @Date: 2020/8/4
 * @Description:
 */

public class DateUtils {

    private static final String YYYY_MM_DD_ = "yyyy-MM-dd";

    private static final String YYYY_MM_DD = "yyyy/MM/dd";

    private static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    private static final String YYYYMMDD = "yyyyMMdd";
    private static final AtomicInteger atomicInteger = new AtomicInteger(0);
    public static void main(String[] args) throws Exception {
        /*String s = "死锁";
        String regex = "[0]|[1-9]*";
        System.out.println(Pattern.matches(regex, s));
        String userByTeamForStr = "586";
        for (String ss : "545,555".split(",")) {
            if (!userByTeamForStr.contains(ss)) {
                userByTeamForStr = userByTeamForStr + "," + ss;
            }
        }
        System.out.println(userByTeamForStr);
//        System.out.println(userByTeamForStr.replaceFirst(",", ""));
        List<Map<String,Object>> lists1 = new ArrayList<>();
        List<Map<String,Object>> lists2 = new ArrayList<>();


        //--------------lists1--------------------
        Map<String,Object> h1 = new HashMap<>();
        h1.put("name","fdsa0");
        h1.put("2","fdsa001");
        h1.put("3","fdsa0");
        h1.put("4","fdsa0");

        Map<String,Object> h2 = new HashMap<>();
        h2.put("name","fdsa00");
        h2.put("2","fdsa001");
        h2.put("3","fdsa00");
        h2.put("4","fdsa00");

        lists1.add(h1);
        lists1.add(h2);
        Map<String,Map<String,Object>> ms = lists1.stream().collect(Collectors.toMap(m->m.get("2").toString(),a->a,(k1, k2)-> k1));
        System.out.println(ms);

        System.out.println(getNowDateStr("yyyy-MM-dd HH:mm:ss"));
//        System.out.println(getDateStrFormat("2020-01-12 12:09:09", "yyyy-MM-dd"));
        System.out.println("2020-01-12 12:09:09".substring(0, "2020-01-12 12:09:09".indexOf(" ")));*/
        System.out.println(dateFormat("2020-01-12 12:30:09", "yyyy-MM-dd HH:mm:ss").getTime() - dateFormat("2020-01-12 12:23:09", "yyyy-MM-dd HH:mm:ss").getTime());
        System.out.println(getDateDuration("2020-01-12 12:23:09", "2020-01-12 12:23:25"));
        System.out.println(getBrowsingDuration ("2020-01-12 12:23:09","2020-01-12 12:23:25"));
        System.out.println(getDuration("4",  "3"));
        String dateTimeStr = "2020-11-12 12:30:09";
        String dateStr = "2020-11-12";
        System.out.println(LocalDate.parse(dateTimeStr.substring(0, dateTimeStr.indexOf(" "))));
        System.out.println(LocalTime.parse(dateTimeStr.substring(dateTimeStr.indexOf(" ") + 1)));
        System.out.println(LocalDateTime.of(LocalDate.parse(dateTimeStr.substring(0, dateTimeStr.indexOf(" "))), LocalTime.parse(dateTimeStr.substring(dateTimeStr.indexOf(" ") + 1))));
        System.out.println(DateTimeFormatter.ofPattern(YYYYMMDD).format(LocalDateTime.of(LocalDate.parse(dateTimeStr.substring(0, dateTimeStr.indexOf(" "))), LocalTime.parse(dateTimeStr.substring(dateTimeStr.indexOf(" ") + 1)))));
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        System.out.println(calendar.getFirstDayOfWeek());
        System.out.println(date);
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_);
        calendar.setTime(sdf.parse(dateTimeStr));
        System.out.println(calendar.getTime());
    }
    private static Integer getBrowsingDuration (String startDate, String endDate) throws Exception {
        long duration = DateUtils.getDateDuration(startDate, endDate);
        BigDecimal a = new BigDecimal(duration + "");
        BigDecimal b = new BigDecimal("1000");
        return a.divide(b, 0, BigDecimal.ROUND_UP).intValue();
    }
    private static BigDecimal getDuration (String min, String max) {
        BigDecimal a = new BigDecimal(min);
        BigDecimal b = new BigDecimal(max);
        System.out.println(a.divide(b, 5, BigDecimal.ROUND_HALF_UP));
        return a.divide(b, 0, BigDecimal.ROUND_UP);
    }
    public static boolean isValidDate(String pattern, Object object){
        if (Objects.isNull(object)) {
            return Boolean.FALSE;
        }
        String regex = "";
        switch (pattern){
            case YYYY_MM_DD_:
                regex = "^[1-9]\\d{3}\\-(0?[1-9]|1[0-2])\\-(((0?[1-9])|((1|2)[0-9])|30|31))$";
                break;
            case YYYY_MM_DD:
                regex = "^[1-9]\\d{3}\\/(0?[1-9]|1[0-2])\\/(((0?[1-9])|((1|2)[0-9])|30|31))$";
                break;
            case YYYYMMDD:
                regex = "^[1-9]\\d{3}(0?[1-9]|1[0-2])(((0?[1-9])|((1|2)[0-9])|30|31))$";
                break;
            default:
                break;
        }
        return Pattern.matches(regex, object.toString());
    }

    /**
     * 判断结束日期是否大于等于开始日期
     * @param startDate
     * @param endDate
     * @return
     */
    private static boolean isStartDateAfterEndDate(String startDate, String endDate){
        try{
            return LocalDate.parse(startDate).isAfter(LocalDate.parse(endDate));
        }catch (Exception e){
            return Boolean.FALSE;
        }
    }

    /**
     * 计算时间长（单位：毫秒）
     * @param startDate
     * @param endDate
     * @return
     * @throws ParseException
     */
    public static long getDateDuration (String startDate, String endDate) throws ParseException {
        return dateFormat(endDate, "yyyy-MM-dd HH:mm:ss").getTime() - dateFormat(startDate, "yyyy-MM-dd HH:mm:ss").getTime();
    }
    /**
     * 将字符串根据格式转为日期
     * @param date
     * @param pattern
     * @return
     */
    public static Date dateFormat(String date, String pattern) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.parse(date);
    }

    private static Date toDate(String date){
        LocalDate localDate = LocalDate.parse(date);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }

    public static String getNowDateStr (String format) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        return dateTimeFormatter.format(LocalDateTime.now());
    }

    public static String getDateStrFormat (String dateStr, String format) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(dateStr).format(dateTimeFormatter);
    }
}
