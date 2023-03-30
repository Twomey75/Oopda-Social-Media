import java.io.File;

/**
 * This class represents the video media item and has a file that it is able to access
 * 
 * @author Sean Twomey
 *
 */

public class Video extends Media implements MediaFile{
    // The video file
    File file;

    public Video(String title, String description, String filePath, Topic mediaTopic)
    {
        super(title, description, mediaTopic);
        this.file = new File(filePath);
        htmlString = "<h2>" + title + "</h2>" + "<p>" + description + "</p>" +  "<video width='300' autoplay>" + "<source src='" + file.toURI() +
        "' type='video/mp4' />" + "Your browser does not support the video element.</video><hr />";
    }

    /**
     * returns the file of the video media item
     * @return the file of the video media item
     */
    public File getFile() 
    {
        return file;
    }
}