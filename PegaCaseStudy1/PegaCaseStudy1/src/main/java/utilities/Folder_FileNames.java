package utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Folder_FileNames {
	// Generating FileName for the image and text files
		public static String fileName() {
			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd_MM_yyyy HH_mm_ss");
			String dateTime = "_" + now.format(format);
			return dateTime;
		}
		

}
