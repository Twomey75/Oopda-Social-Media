import java.io.File;

public class Song extends Media implements MediaFile{
    File file;

    public Song(String title, String description, String filePath, Topic mediaTopic)
    {
        super(title, description, mediaTopic);
        this.file = new File(filePath);
        htmlString = "<h2>" + title + "</h2>" + "<p>" + description + "</p>" +  "<video width='300' autoplay>" + "<source src='" + file.toURI() +
        "' type='video/mp4' />" + "Your browser does not support the video element.</video><hr />";
    }

    public File getFileName() 
    {
        return file;
    }
}