import java.io.File;

public class Song extends Media implements MediaFile{
    File file;

    public Song(String title, String description, String filePath, Topic mediaTopic, String artist)
    {
        super(title, description, mediaTopic);
        this.file = new File(filePath);
        htmlString = "<h2>" + title + "</h2>" + "<p>" + description + "</p>" + "<audio controls autoplay> <source src='" + file.toURI() + 
        "' type='audio/mp3' />" + "Your browser does not support the audio element.</audio>" + "by " + artist;
    }

    public File getFileName() 
    {
        return file;
    }
}