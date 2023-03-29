public class Media {
    private String title;
    private String description;
    protected String htmlString;

    public Media(String title, String description)
    {
        this.title = title;
        this.description = description;
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

}
