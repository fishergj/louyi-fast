package net.fisher.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import com.github.pagehelper.util.StringUtil;

/**
  * 日期工具类
 * @author jin_xiaoling.pfu
 *
 */
public class DateUtil {
	/**
	 * yyyy-MM-dd
	 */
	public static final String YEAR_TO_DAY = "yyyy-MM-dd";

	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static final String YEAR_TO_SECOND = "yyyy-MM-dd HH:mm:ss";

	public static final String YEAR_TO_HOUR = "yyyy-MM-dd HH";
	
	public static final String YEAR_TO_MINUTE = "yyyy-MM-dd HH:mm";
	
	public static final String YEAR_TO_MILLSECOND = "yyyyMMddHHmmssSSS";

	/**
	 * 获取系统时间格式
	 * 
	 * @return
	 */
	public static String getSysDt() {
		SimpleDateFormat bartDateFormat = new SimpleDateFormat(YEAR_TO_MILLSECOND);
		Date date = new Date();
		String dtFmt = bartDateFormat.format(date);
		return dtFmt;
	}

	/**
	 * 日期字符串转成日期
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date strToDate(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(YEAR_TO_SECOND);
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 日期字符串转成日期
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date strToDate1(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(YEAR_TO_MINUTE);
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 *   日期转换成字符串 
	 * 
	 * @param date 
	 * @return str 
	 */
	public static String dateToStr(Date date) {
		SimpleDateFormat format = new SimpleDateFormat(YEAR_TO_SECOND);
		String str = format.format(date);
		return str;
	}
	
	/**
	 *   日期转换成字符串 
	 * 
	 * @param date 
	 * @return str 
	 */
	public static String dateHourToStr(Date date) {
		SimpleDateFormat format = new SimpleDateFormat(YEAR_TO_HOUR);
		String str = format.format(date);
		return str;
	}

	/**
	 * UTC时间格式转换成Date
	 * 
	 * @param utcTime
	 * @return
	 */
	public static Date utc2Local(String utcTime) {
		String utcTimePatten = "yyyy-MM-dd'T'HH:mm:ss'Z'";
		SimpleDateFormat utcFormater = new SimpleDateFormat(utcTimePatten);
		utcFormater.setTimeZone(TimeZone.getTimeZone("UTC"));// 时区定义并进行时间获取
		Date gpsUTCDate = null;
		try {
			gpsUTCDate = utcFormater.parse(utcTime);
		} catch (ParseException e) {
			e.printStackTrace();
			return gpsUTCDate;
		}
		return gpsUTCDate;
	}

	/***
	 * 获得本月第一天
	 *
	 */
	public static String getMonthFirstDay() {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		String first = format.format(c.getTime());
		return first;
	}

	/***
	 * 获得本月最后一天
	 */
	public static String getMonthyLastDay() {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
		String last = format.format(ca.getTime());
		return last;
	}

	/****
	 * 
	 * 获得时间往前推1年
	 ***/
	public static String getLastYear() {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.YEAR, -1);
		String last = format.format(ca.getTime());
		return last;
	}

	/**
	 * 当前天格式化
	 * @param format
	 * @return
	 */
	public static String formatDate(String format) {

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date());
	}

	/**
	 * 某个日期格式化
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDate(Date date, String format) {

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * 格式化明天时间日期
	 * @param format
	 * @return
	 */
	public static String formatTomorrowDate(String format) {

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		return sdf.format(calendar.getTime());
	}

	/**
	 * 日期比较
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int compare(Date date1, Date date2) {

		return date1.compareTo(date2);
	}

	/**
	 * 日期比较
	 * @param date1
	 * @param format
	 * @param date2
	 * @return
	 * @throws ParseException
	 */
	public static int compare(String date1, String format, Date date2) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = sdf.parse(date1);
		return date.compareTo(date2);
	}

	/**
	 * 日期直接相差的秒数
	 * @param fromDt
	 * @param toDt
	 * @return
	 */
	public static int getBetweenSeconds(Date fromDt, Date toDt) {
		long from = fromDt.getTime();
		long to = toDt.getTime();
		int between = (int) ((to - from) / 1000);
		return between;
	}

	/**
	 * 日期格式化
	 * @param date
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static Date parse(String date, String format) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.parse(date);
	}

	/**
	 * 日期格式化，带时区
	 * @param date
	 * @param format
	 * @param locale
	 * @param timeZone
	 * @return
	 * @throws ParseException
	 */
	public static Date parse(String date, String format, Locale locale, TimeZone timeZone) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat(format, locale);
		sdf.setTimeZone(timeZone);
		return sdf.parse(date);
	}
	
	/**
	 * 下一天
	 * @param date
	 * @param i
	 * @return
	 */
	public static Date getNextDay(Date date, int i) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, i);
		date = calendar.getTime();
		return date;
	}

	/**
	 * 下一年
	 * @param date
	 * @param i
	 * @return
	 */
	public static Date getNextYear(Date date, int i) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, i);
		date = calendar.getTime();
		return date;
	}
	
	/**
	 * 获取当前时间的分钟数
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date getDateMinute(Date date) throws ParseException {
		String dtFmt = formatDate(date, YEAR_TO_MINUTE);
		Date minuteDt = parse(dtFmt,YEAR_TO_MINUTE);
		return minuteDt;
	}
	
	/**
	 * 获取一天最大小时分
	 * @return
	 * @throws ParseException
	 */
	public static Date getMaxDayMinute() throws ParseException {
		Calendar calendarInstance = Calendar.getInstance();
	    //设置每天的最大小时
		calendarInstance.set(Calendar.HOUR_OF_DAY, calendarInstance.getActualMaximum(Calendar.HOUR_OF_DAY));
		//设置每小时最大分钟
		calendarInstance.set(Calendar.MINUTE, calendarInstance.getActualMaximum(Calendar.MINUTE));
		return getDateMinute(calendarInstance.getTime());
	}
	
	/**
	 * 获取一天最小小时分
	 * @return
	 * @throws ParseException
	 */
	public static Date getMinDayMinute() throws ParseException {
		Calendar calendarInstance = Calendar.getInstance();
	    //设置每天的最小小时
		calendarInstance.set(Calendar.HOUR_OF_DAY, calendarInstance.getActualMinimum(Calendar.HOUR_OF_DAY));
		//设置每小时最小分钟
		calendarInstance.set(Calendar.MINUTE, calendarInstance.getMinimum(Calendar.MINUTE));
		return getDateMinute(calendarInstance.getTime());
	}
	
	public static Date addMinute(Date date,int minutes) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, minutes);
		date = calendar.getTime();
		return date;
	}
	
	public static String fmtDateMinute(Date date,int minutes) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, minutes);
		date = calendar.getTime();
		String dtFmt = formatDate(date, YEAR_TO_MINUTE);
		return dtFmt;
	}
	/**
	  * 格式化日期
	 * @param date
	 * @return
	 */
	public static String fmtDateMinute(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		date = calendar.getTime();
		String dtFmt = formatDate(date, YEAR_TO_MINUTE);
		return dtFmt;
	}
	
	/**
	  * 格式化日期
	 * @param date
	 * @param minutes
	 * @return
	 */
	public static String fmtDateMinute(String date,int minutes) {
		Date dt = strToDate1(date);
		return fmtDateMinute (dt,minutes);		
	}
	
	/**
	  * 格式化日期
	 * @param date
	 * @param minutes
	 * @return
	 */
	public static String fmtDateMinute(String date) {
		Date dt = strToDate1(date);
		return fmtDateMinute (dt);		
	}
	
	/**
	 * 获取当前时间的分钟数
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date getDateHour(Date date) throws ParseException {
		String dtFmt = formatDate(date, YEAR_TO_HOUR);
		Date hourDt = parse(dtFmt,YEAR_TO_HOUR);
		return hourDt;
	}
	
	/**
	 * 下一个分钟
	 * @param date
	 * @param i
	 * @return
	 * @throws ParseException 
	 */
	public static Date getNextMinute(Date date, int minutes) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, minutes);
		date = calendar.getTime();
		return getDateMinute(date);
	}

	/**
	 * 获取指定周期之前的时刻
	 *
	 * @param endTime
	 * @param period
	 * @return
	 */
	public static long getBeforPeriodTimestamp(long endTime, DateUtil.Period period) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(endTime);

		calendar.add(period.getCalendarField(), 0 - period.getAmount());
		return calendar.getTimeInMillis();
	}

	/**
	 * 获取指定周期之前的时刻
	 *
	 * @param endTime
	 * @param period
	 * @return
	 */
	public static Date getDate(long millionSeconds) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millionSeconds);

		
		return calendar.getTime();
	}

	/**
	 * 获取指定周期之前的时长
	 *
	 * @param endTime
	 * @param period
	 * @return
	 */
	public static long getBeforPeriodDuration(long endTime, DateUtil.Period period) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(endTime);

		calendar.add(period.getCalendarField(), 0 - period.getAmount());
		return endTime - calendar.getTimeInMillis();
	}

	;

	public enum Period {
		/**
		 * 一天
		 */
		ONE_DAY("一天", Calendar.DAY_OF_MONTH, 1),
		/**
		 * 一天
		 */
		TWO_DAY("两天", Calendar.DAY_OF_MONTH, 2),
		/**
		 * 一天
		 */
		THREE_DAY("三天", Calendar.DAY_OF_MONTH, 3),
		/**
		 * 一天
		 */
		ONE_WEEK("一星期", Calendar.WEEK_OF_MONTH, 1),
		/**
		 * 一天
		 */
		TWO_WEEK("两星期", Calendar.WEEK_OF_MONTH, 2),
		/**
		 * 一天
		 */
		THREE_WEEK("三星期", Calendar.WEEK_OF_MONTH, 3),
		/**
		 * 一天
		 */
		ONE_MONTH("一月", Calendar.MONTH, 1);

		private Period(String name, int calendarField, int amount) {
			this.name = name;
			this.calendarField = calendarField;
			this.amount = amount;
		}

		private String name;

		private int calendarField;

		private int amount;

		public String getName() {

			return this.name;
		}

		public int getCalendarField() {

			return calendarField;
		}

		public int getAmount() {

			return amount;
		}
	}

	/**
	 * @param time
	 * @param format
	 * @return
	 */
	public static String format(Long time, String format) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time);
		return DateUtil.formatDate(calendar.getTime(), format);
	}

	public static boolean isWorkDay(Calendar calendar) {

		return !(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
				|| calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY);
	}

	/**
	 * @param date
	 * @return
	 */
	public static boolean isWorkDay(Date date) {

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return isWorkDay(c);
	}

	/**
	 * @param year
	 * @return
	 */
	public static final boolean isGregorianLeapYear(int year) {

		return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
	}

	/**
	 * @param mon
	 * @return
	 */
	public static final String addMonth(int mon) {

		return mon + 1 < 10 ? "0" + (mon + 1) : (mon + 1) + "";
	}

	/**
	 * @param day
	 * @return
	 */
	public static final String addDay(int day) {

		return day < 10 ? "0" + day : day + "";
	}

	/**
	 * getDateTimeTicks(这里用一句话描述这个方法的作用) java时间转C#时间
	 *
	 * @param @return 设定文件
	 * @return String DOM对象
	 * @Exception 异常对象
	 * @since CodingExample Ver(编码范例查看) 1.1
	 */
	public static long getDateTimeTicks() {

		// C# DateTime.Now.Ticks属性的值表示自 0001 年 1 月 1 日午夜 12:00:00（表示
		// DateTime.MinValue）以来经过的以 100 纳秒为间隔的间隔数
		long timeticks;
		// 1979与0001相隔毫秒数 (1979-0001)*365*24*60*60*1000
		long time_JAVA_Long = Long.parseLong("62378208000000");
		// java长整型日期，毫秒为单位
		Date dt_1979 = new Date();
		// long型的毫秒数
		long tricks_1979 = dt_1979.getTime();
		// 1970年1月1日刻度
		long time_tricks = (tricks_1979 + time_JAVA_Long) * 10000;
		timeticks = time_tricks;

		return timeticks;
	}

	/**
	 * getDayCountOfMonth 取某年某月的天數
	 *
	 * @param date 日期YYYYMMDD
	 * @return int 月的天數
	 * @Exception 异常对象
	 */
	public static int getDayCountOfMonth(String date) {

		try {
			if (StringUtil.isEmpty(date)) {
				return 0;
			}
			switch (date.substring(4, 6)) {
			case "01":
			case "03":
			case "05":
			case "07":
			case "08":
			case "10":
			case "12":
				return 31;
			case "04":
			case "06":
			case "09":
			case "11":
				return 30;
			case "02":
				// 润年
				if (isGregorianLeapYear(Integer.parseInt(date.substring(0, 4)))) {
					return 29;
				} else {
					return 28;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
