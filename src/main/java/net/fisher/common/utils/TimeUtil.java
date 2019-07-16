package net.fisher.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 时间工具类
 * @author jin_xiaoling.pfu
 *
 */
public class TimeUtil {

	public static final String YEAR_TO_MINUTE = "yyyy-MM-dd HH:mm";
	
	public static final String YEAR_TO_MINUTE_0 = "yyyy-MM-dd HH:00";
	
	/**
	 * 获取某一时间的分组
	 * 
	 * @param date
	 * @return
	 */
	public static int getMinute(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MINUTE);
	}
	
	/**
	 * 获取下一个小时开始时间
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date getNextHour(Date date) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR, 1);
		Date newDate = calendar.getTime();
		String fmt = DateUtil.formatDate(newDate, YEAR_TO_MINUTE_0);
		return DateUtil.parse(fmt, YEAR_TO_MINUTE_0);
	}
	
	public static Date getPartsTime(Date date,int partsMinute) throws ParseException {
		int minute = getMinute(date);
		int partsIndex = minute/partsMinute;
		int recordMinute = partsMinute*(partsIndex + 1);
		Date recordTime = null;
		if(recordMinute == 60) {
			recordTime = TimeUtil.getNextHour(date);
		}else {
			Date hour = DateUtil.getDateHour(date);
			String hourFmt = DateUtil.dateHourToStr(hour);
			String newHourFmt = hourFmt + ":" + recordMinute;
			recordTime = DateUtil.parse(newHourFmt, YEAR_TO_MINUTE);
		}
		return recordTime;
	}
	
	/**
	 * 获取分钟差
	 * @param fromDt
	 * @param toDt
	 * @return
	 */
	public static int diffMinutes(Date fromDt,Date toDt) {
		long from = fromDt.getTime();
		long to = toDt.getTime();
		int minutes = (int) ((to - from)/(1000 * 60));
		return minutes;
	}

	/**
	 * 获取前n天日期和相应星期数
	 *
	 * @return 日期和相应星期数
	 */
	public static Map<String, String> getweektime(String d) {

		Map<String, String> retMap = new HashMap<String, String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -Integer.parseInt(d));
		Date monday = c.getTime();
		String week = getWeekStringOfDate(monday);
		String preMonday = sdf.format(monday);
		retMap.put("week", week);
		retMap.put("time", preMonday);

		SimpleDateFormat MM = new SimpleDateFormat("M");
		SimpleDateFormat dd = new SimpleDateFormat("dd");
		String MM1 = MM.format(monday);
		String dd1 = dd.format(monday);
		String res = MM1 + "月" + dd1 + "日";
		retMap.put("monDay", res);

		return retMap;
	}

	/**
	 * 获取当前日期是星期几
	 *
	 * 
	 */
	public static String getWeekStringOfDate(Date dt) {

		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		return weekDays[w];
	}

	/**
	 * 获取当前日期是星期几
	 *
	 * 
	 */
	public static int getWeekIntOfDate(Date dt) {

		int[] weekDays = { 0,1,2,3,4,5,6};
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		return weekDays[w];
	}

	/**
	 * 日期格式化为xxxx年xx月xx日 xx:xx:xx
	 *
	 * @param date
	 */
	public static String formmaterDateTimeStringToString(String datetime) {

		String result = "";
		if (null != datetime && !datetime.isEmpty()) {
			result = datetime.substring(0, 16).replace(" ", "-").replace(":", "-");
			if (null != result && !result.isEmpty()) {
				String[] arrtime = result.split("-");
				if (null != arrtime) {
					result = arrtime[1] + "月" + arrtime[2] + "日  " + arrtime[3] + "时" + arrtime[4] + "分";
				}
			}
		}
		return result;
	}

	/**
	 * 获取前n天的日期 2种表现方式
	 *
	 * @return 前n天的日期 2种表现方式
	 */
	public static Map<String, String> getStatetime(int daynum) throws ParseException {

		Map<String, String> retMap = new HashMap<String, String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -daynum);
		Date monday = c.getTime();
		String pretime = sdf.format(monday);
		String preDay = sdf2.format(monday);
		retMap.put("time", pretime);
		retMap.put("preDay", preDay);
		return retMap;
	}

	/**
	 * 获取两个日期之间的日期
	 *
	 * @param start 开始日期
	 * @param end   结束日期
	 * @return 日期集合
	 */
	public static List<String> getBetweenDates(String inpstart, String inpend) {

		// 时间转换类
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date start = null;
		Date end = null;
		try {
			start = sdf.parse(inpstart);
			end = sdf.parse(inpend);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> result = new ArrayList<String>();
		result.add(inpstart);
		Calendar tempStart = Calendar.getInstance();
		tempStart.setTime(start);
		tempStart.add(Calendar.DAY_OF_YEAR, 1);
		Calendar tempEnd = Calendar.getInstance();
		tempEnd.setTime(end);
		while (tempStart.before(tempEnd)) {
			result.add(sdf.format(tempStart.getTime()));
			tempStart.add(Calendar.DAY_OF_YEAR, 1);
		}
		result.add(inpend);
		return result;
	}

	/**
	 * 获取两个日期之间的日期
	 *
	 * @param start 开始日期
	 * @param end   结束日期
	 * @return 日期集合 时间格式为YYYYMMDD
	 */
	public static List<String> getBetweenRealDates(String inpstart, String inpend) {

		// 时间转换类
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date start = null;
		Date end = null;
		try {
			start = sdf.parse(inpstart);
			end = sdf.parse(inpend);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> result = new ArrayList<String>();
		result.add(inpstart);
		Calendar tempStart = Calendar.getInstance();
		tempStart.setTime(start);
		tempStart.add(Calendar.DAY_OF_YEAR, 1);
		Calendar tempEnd = Calendar.getInstance();
		tempEnd.setTime(end);
		while (tempStart.before(tempEnd)) {
			result.add(sdf.format(tempStart.getTime()));
			tempStart.add(Calendar.DAY_OF_YEAR, 1);
		}
		result.add(inpend);
		return result;
	}

	/**
	 * 获取一个日期的月日
	 *
	 * @param start 开始日期
	 * @param end   结束日期
	 * @return 日期
	 */
	public static String getDateDay(String time) {

		// 时间转换类
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd");
		Date temptime = null;
		try {
			temptime = sdf.parse(time);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String DateDay = sdf2.format(temptime);
		return DateDay;
	}

	/**
	 * 获取一个月的所有日期
	 *
	 * @param start 开始日期
	 * @return 日期
	 */
	public static String[] getMonthDays(String date) {

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, Integer.parseInt(date.substring(0, 4)));
		calendar.set(Calendar.MONTH, Integer.parseInt(date.substring(5, 7)) - 1);
		int month = Integer.parseInt(date.substring(5, 7));
		int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		String[] days = new String[maxDay];
		for (int i = 1; i <= maxDay; i++) {
			days[i - 1] = String.valueOf(month) + "月" + String.valueOf(i) + "日";
		}
		return days;
	}

	/**
	 * 获取当前日期是星期几
	 * 
	 * @return 当前日期是星期几
	 */
	public static int getWeekNum(String time) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date temptime = null;
		try {
			temptime = sdf.parse(time);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(temptime);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		return w;
	}

	/**
	 * 获取当前日期格式，由YYYY/MM/DD--》YYYYMMDD
	 * 
	 * @return 当前日期是星期几
	 */
	public static String UpdateFormat(String time) {

		String newtime = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
		if (null != time && !time.isEmpty()) {
			Date temptime = null;
			try {
				temptime = (Date) sdf.parse(time);
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
			newtime = sdf2.format(temptime);
		}
		return newtime;
	}

	/**
	 * 获取当前日期格式，由YYYYMMDD--》YYYY/MM/DD
	 * 
	 * @return 当前日期是星期几
	 */
	public static String UpdateDateFormat(String time) {

		String newtime = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
		if (null != time && !time.isEmpty()) {
			Date temptime = null;
			try {
				temptime = (Date) sdf.parse(time);
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
			newtime = sdf2.format(temptime);
		}
		return newtime;
	}

	/**
	 * 获取当前日期格式，由YYYY/MM--》YYYYMM
	 * 
	 * @return 当前日期是星期几
	 */
	public static String UpdateFormatMonth(String time) throws ParseException {

		String newtime = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMM");
		Date temptime = null;
		try {
			temptime = (Date) sdf.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		newtime = sdf2.format(temptime);
		return newtime;
	}

	/**
	 * 获取当前日期格式，由YYYY-MM-DD--》YYYYMMDD
	 * 
	 * @return 当前日期是星期几
	 */
	public static String UpdateFormatReal(String time) {

		String newtime = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
		if (null != time && !time.isEmpty()) {
			Date temptime = null;
			try {
				temptime = (Date) sdf.parse(time);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			newtime = sdf2.format(temptime);
		}
		return newtime;
	}
}
