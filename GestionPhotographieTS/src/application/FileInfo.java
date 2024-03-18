package application;

import java.io.File;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class FileInfo {
    private String fileName;
    private Date lastModified;
    private String Satut;

    public FileInfo(File file) {
        this.fileName = file.getName();
        this.lastModified = new Date(file.lastModified());

      //default time zone
    	ZoneId defaultZoneId = ZoneId.systemDefault();

    	//creating the instance of LocalDate using the day, month, year info
            LocalDate localDate = LocalDate.now();

            //local date + atStartOfDay() + default time zone + toInstant() = Date
            Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

        if(new Date(file.lastModified()).compareTo(date) > 0){
        	this.Satut = "En cours";
        }else{
        	this.Satut = "Terminé";
        }

    }

    public String getFileName() {
        return fileName;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public String getSatut() {
        return Satut;
    }
}
