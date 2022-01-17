package helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Managers.CreateLetters;
import data.Letters;

public class JsonTakes {
	public static Stack<Letters> getData(File site) {
		Stack<Letters> base = new Stack<Letters>();
		String json;
		try {
			json = getJson(site);
			JSONArray ps = new JSONArray(json);

			if (ps.length() > 0) {

				for (int t = 0; t < ps.length(); t++) {
					JSONObject obj = ps.getJSONObject(t);
					Letters lt = CreateLetters.get().create(obj.getString("Subject"),obj.getString("Description"));
					lt.setDate(obj.getLong("Date"));
					base.add(lt);
				}
			}

		} catch (JSONException e) {
		}

		return base;
	}

	private static String getJson(File site) {
		Scanner myReader;
		StringBuffer sb = new StringBuffer();
		try {
			myReader = new Scanner(site);

			while (myReader.hasNextLine()) {
				sb.append(myReader.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sb.toString();
	}
}
