/**
 * Represents the basic idea of a media item
 * 
 * @author Sean Twomey
 * 
 */

public class Media {
    // The title of the media item
    private String title;
    // The description of the media item
    private String description;
    // Media item's associated html
    protected String htmlString;
    // The topic of the media item
    private Topic mediaTopic;

    public Media(String title, String description, Topic mediaTopic)
    {
        this.title = title;
        this.description = description;
        this.mediaTopic = mediaTopic;
    }

    /**
     * Returns the media item's title
     * @return the title of the media item
     */
    public String getTitle() 
    {
        return title;
    }

    /**
     * Returns the media item's description
     * @return the description of the media item
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Returns the media item's html
     * @return the html of the media item
     */
    public String getHtmlString() 
    {
        return htmlString;
    }

    /**
     * Returns the media item's topic
     * @return the topic of the media item
     */
    public Topic getMediaTopic() 
    {
        return mediaTopic;
    }

}
