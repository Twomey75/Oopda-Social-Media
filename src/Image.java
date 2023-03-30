import java.io.File;

/**
 * This class represents the image media item and has a file that it is able to access
 * 
 * @author Sean Twomey
 *
 */

public class Image extends Media implements MediaFile{
    // The image file
    File file;

    public Image(String title, String description, String filePath, Topic mediaTopic)
    {
        super(title, description, mediaTopic);
        this.file = new File(filePath);
        htmlString = "<h2>" + title + "</h2>" + "<figure><img src='" + file.toURI() + "' />" + "<figcaption>" + description + "</figcaption></figure><hr />";
    }

    /**
     * returns the file of the image media item
     * @return the file of the image media item
     */
    public File getFileName() 
    {
        return file;
    }
}
