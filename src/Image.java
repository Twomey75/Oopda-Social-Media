import java.io.File;

public class Image extends Media implements MediaFile{
    File file;

    public Image(String title, String description, String filePath)
    {
        super(title, description);
        this.file = new File(filePath);
        htmlString = "<h2>" + title + "</h2>" + "<figure><img src='" + file.toURI() + "' />" + "<figcaption>" + description + "</figcaption></figure><hr />";
    }

    public File getFileName() 
    {
        return file;
    }
}
