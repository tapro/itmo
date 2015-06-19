package com.five;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Queswers {
	public String quest = null;
	public String ansStr = null;
	public String ansData = null;
	public Integer ansNum = null;
		
	public boolean checkStr(String answer) throws TaproException, ParseException, NumberFormatException{
		if (ansStr != null){
			if(!ansStr.equals(answer)){
				throw new TaproException("<br>Вы дали неверный ответ");
			}
		}
		if (ansData != null){
			SimpleDateFormat myDateFormat = new SimpleDateFormat("dd.MM.yyyy");
			Date userDate = myDateFormat.parse(answer);
			Date realDate = myDateFormat.parse(ansData);
			if (!userDate.equals(realDate)){
				return false;
			}
	//		dateFormat.parse(answer);
		}
		if (ansNum != null){
			if(ansNum != Integer.parseInt(answer)){
				return false;
			}
		}
		return true;
	}

}
