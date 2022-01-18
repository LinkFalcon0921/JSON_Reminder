package data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertorDate {
	private static ConvertorDate admin;
	private SimpleDateFormat format;

	private ConvertorDate() {
		format = new SimpleDateFormat("E dd/MMMMM/yyyy");
	}

	public static ConvertorDate get() {
		if (admin == null)
			admin = new ConvertorDate();

		return admin;
	}

	public Date getDateTime(String date) {
		Date data = null;

		try {
			data = format.parse(date);
		} catch (ParseException e) {
		}

		return data;
	}
	
	public Date getDateTime(long date) {
		Date data = null;

		try {
			data = new Date(date);
		} catch (NullPointerException e) {
		}

		return data;
	}

	public String getDateInfo(Date date) {
		String data = null;

		try {
			if (date != null)
				data = format.format(date);
		} catch (NullPointerException e) {
		}

		return data;
	}

	public String getDateInfo(long milis) {
		String data = null;

		try {
			if (milis > 0)
				data = format.format(milis);
		} catch (NullPointerException e) {
		}

		return data;
	}
	
}
