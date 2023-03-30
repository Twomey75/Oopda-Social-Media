import java.io.File;

/**
 * This class represents the song media item and has a file that it is able to access
 * 
 * @author Sean Twomey
 *
 */

public class Song extends Media implements MediaFile{
    // The song file
    File file;

    public Song(String title, String description, String filePath, Topic mediaTopic, String artist)
    {
        super(title, description, mediaTopic);
        this.file = new File(filePath);
        htmlString = "<h2>" + title + "</h2>" + "<p>" + description + "</p>" + "<audio controls autoplay> <source src='" + file.toURI() + 
        "' type='audio/mp3' />" + "Your browser does not support the audio element.</audio>" + "by " + artist + "<hr />";
    }

    /**
     * returns the file of the song media item
     * @return the file of the song media item
     */
    public File getFile() 
    {
        return file;
    }
}