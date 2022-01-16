package helpers;

import java.io.File;

public class PathsTo {
	private static String PATHDEFAULT = "Files\\";
	private final String USERS = "Letters\\";

	private static PathsTo path;

	private PathsTo() {

	}

	public static PathsTo get() {
		if (path == null)
			path = new PathsTo();

		return path;
	}

	private void getDefaultPath(String data) {
		File site = new File(data);

		if (!site.exists())
			site.mkdirs();
	}

	public String getLettersPath() {
		getDefaultPath(PATHDEFAULT + USERS);
		return PATHDEFAULT + USERS;
	}

}
