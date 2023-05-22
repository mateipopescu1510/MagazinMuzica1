package Utils;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Audit {
	FileWriter fw;
	final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yy-MM-dd/HH:mm");
	public Audit(){
		try{
			fw = new FileWriter("src/Data/audit.csv");
		}
		catch (IOException exception){
			System.out.println(exception.getMessage());
		}
	}
	
	public void log(String event) throws IOException{
		fw.append(dateFormat.format(LocalDateTime.now()));
		fw.append(",");
		fw.append(event);
		fw.append("\n");
		fw.flush();
	}
}