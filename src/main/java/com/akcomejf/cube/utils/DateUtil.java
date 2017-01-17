package com.akcomejf.cube.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {

	public static List<String> getBetweenDate(String from, String to, Integer dateType) {
		List<String> list = new ArrayList<String>();
		String style = "";
		if (Calendar.YEAR == dateType || 3 == dateType) {
			style = "yyyy";
		} else if (Calendar.MONDAY == dateType) {
			style = "yyyy-MM";
		} else if (Calendar.DATE == dateType) {
			style = "yyyyMMdd";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(style);
		String _from, _to;
		int _dateType;
		if (3 == dateType) {
			_from = from.split("-")[0];
			_to = to.split("-")[0];
			_dateType = 1;
		} else {
			_from = from;
			_to = to;
			_dateType = dateType;
		}
		list.add(_from);
		Calendar cal = Calendar.getInstance();
		try {
			Date toDate = sdf.parse(_to);
			cal.setTime(sdf.parse(_from));
			boolean bContinue = true;
			while (bContinue) {
				// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
				cal.add(_dateType, 1);
				// 测试此日期是否在指定日期之后
				if (toDate.after(cal.getTime())) {
					String _date = sdf.format(cal.getTime());
					list.add(_date);
				} else {
					break;
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		list.add(_to);
		// 季度时间段
		if (3 == dateType) {
			String[] begin = from.split("-");
			String[] end = to.split("-");
			List<String> quarterList = new ArrayList<String>();
			for (int i = 0; i < list.size(); i++) {
				String date = list.get(i);
				int j = 1;
				if (0 == i) {
					if ("04".equals(begin[1])) {
						quarterList.add(from);
						continue;
					} else {
						j = Integer.valueOf(begin[1]);
					}
				}
				int max = 5;
				if (i == list.size() - 1) {
					if ("01".equals(end[1])) {
						quarterList.add(to);
						break;
					} else {
						max = Integer.valueOf(end[1]) + 1;
					}
				}
				for (; j < max; j++) {
					quarterList.add(date + "-0" + j);
				}
			}
			return quarterList;
		}
		return list;
	}
	
	public static String formatDate(long time, String style) {
		Date date = new Date(time);
		SimpleDateFormat outFormat = new SimpleDateFormat(style);
		return outFormat.format(date);
	}
}
