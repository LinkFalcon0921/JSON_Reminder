package helpers;

import java.io.*;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import data.DateInfo;
import data.Letters;

public class JsonSaves {

	public static boolean writeData(File site, Iterator<Letters> letter) {
		JSONArray list = new JSONArray();
		boolean state = false;

		try {
			while (letter.hasNext()) {
				Letters act = letter.next();
				JSONObject item = new JSONObject();
				item.put("Subject", act.getSUBJECT());
				item.put("Description", act.getDescp());
				
				DateInfo fech = act.getDate();
				item.put("Date created", fech.getCreated().getTime());
				item.put("Date reminder", fech.getReminder().getTime());

				list.put(item);
			}

			BufferedWriter wr = new BufferedWriter(new FileWriter(site));
			wr.write(list.toString());
			wr.close();
			state = true;

		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}
		return state;

	}
}
