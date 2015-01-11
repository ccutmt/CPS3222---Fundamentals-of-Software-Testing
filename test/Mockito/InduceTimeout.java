package Mockito;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class InduceTimeout {
	public String turnBackTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, -3);

		return dateFormat.format(cal.getTime());
	}
}
