package com.vietko.soft.common;

import java.security.MessageDigest;
import java.util.*;

public class DataStatic {

	public static class DATETIME{
		public static String toString(Date mDate, String mFormat){
			Calendar time = Calendar.getInstance();
			if(mDate != null){
				time.setTime(mDate);
			}
			String year = time.get(Calendar.YEAR) + "";
			String month = (time.get(Calendar.MONTH) < 9 ? "0" : "") + (time.get(Calendar.MONTH)+1);
			String day = (time.get(Calendar.DAY_OF_MONTH) < 10 ? "0" : "") + time.get(Calendar.DAY_OF_MONTH);
			String hour = (time.get(Calendar.HOUR_OF_DAY) < 10 ? "0" : "") + time.get(Calendar.HOUR_OF_DAY);
			String minutes = (time.get(Calendar.MINUTE) < 10 ? "0" : "") + time.get(Calendar.MINUTE);
			String seconds = (time.get(Calendar.SECOND) < 10 ? "0" : "") + time.get(Calendar.SECOND);
			String miliSecond = time.get(Calendar.MILLISECOND)+"";
			return mFormat.replaceAll("yyyy", year)
					.replaceAll("MM", month)
					.replaceAll("dd", day)
					.replaceAll("hh", hour)
					.replaceAll("mm", minutes)
					.replaceAll("ss", seconds)
					.replaceAll("ms", miliSecond);
		}
	}
}
