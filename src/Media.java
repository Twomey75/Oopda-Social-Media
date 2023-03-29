public class Media {
    private String title;
    private String description;
    protected String htmlString;
    private String mediaTopic;

    public Media(String title, String description, String mediaTopic)
    {
        this.title = title;
        this.description = description;
        this.mediaTopic = mediaTopic;
    }

    public String getTitle() 
    {
        return title;
    }

    public String getDescription()
    {
        return description;
    }

    public String getHtmlString() 
    {
        return htmlString;
    }

    public String getMediaTopic() 
    {
        return mediaTopic;
    }

}
