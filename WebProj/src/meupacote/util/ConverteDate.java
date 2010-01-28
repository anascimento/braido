package meupacote.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConverteDate {
	public static String formatarData(String data) throws Exception{
		if(data == null || data.equals(""))
			return null;
			String dataF = null;
			try{
				DateFormat df = new SimpleDateFormat("yyyy");
				Date date = df.parse(data);
				dataF = df.format(date);
			}catch(ParseException pe){
				throw pe;
			}
		return dataF;
	}
	public static Date formatarData(Date data) throws Exception{
		if(data == null)
			return null;
		Date date = null;
		date = new Date(data.getTime());
		return date;
	}
	public static Date strToDate(String data) throws Exception{
		if(data == null)
			return null;
		Date dataF = null;
		try{
			DateFormat dataFormat = new SimpleDateFormat("MM/dd/yyyy");
			long timestamp = dataFormat.parse(data).getTime();
			dataF = new Date(timestamp);
		}catch(ParseException pe){
			throw pe;
		}
		return dataF;
	}
}
