import java.io.File;

/**
 * This sets the behaviors for all media items that contain a file, forcing them to be able to return their associated file
 * 
 * @author Sean Twomey
 *
 */

public interface MediaFile 
{
    public File getFile();
}
