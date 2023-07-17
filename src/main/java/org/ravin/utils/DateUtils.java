package org.ravin.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtils {

    public static Date stringToDate(String dateString) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date parsedDate = null;
		try {
			parsedDate = dateFormat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return parsedDate;

	}

	public static String dateToString(Date date){
		if(date == null){
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(date);
	}
}
