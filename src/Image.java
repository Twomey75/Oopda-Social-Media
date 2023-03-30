import java.io.File;

/**
 * Blue print for an image media item
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
