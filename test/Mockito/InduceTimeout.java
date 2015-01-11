package Mockito;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//class to be used solely by mockito to induce an account timeout
public class InduceTimeout {
	public String turnBackTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, -3);

		return dateFormat.format(cal.getTime());
	}
}
