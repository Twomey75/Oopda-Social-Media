import java.time.LocalDate;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author Andrew Petrany
 */
public class Event extends Media{
    private LocalDate date;
    private URL url;

    /**
     * 
     * @param year - year of the event
     * @param month - month of the event
     * @param day - day of the event
     * @param url1 - url for the event
     * @param title - title of the event
     * @param description - description of the event
     * @param topic - the topic class enum of the event
     * @throws URISyntaxException
     * @throws MalformedURLException
     */
    public Event(int year, int month, int day, String url1, String title, String description, Topic topic) throws URISyntaxException, MalformedURLException {
        super(title, description, topic);
        this.setDate(year, month, day);
        this.setUrl(url1);
        htmlString = "<h2>" + title + "</h2>" + "<p>" + description + " " + date + "</p>" + "<a href='" + url.toURI() + "'>" + url + "</a><hr />";
    }

    /**
     * 
     * @param year - year of the event
     * @param month - month of the event
     * @param day - day of the eventy
     */
    public void setDate(int year, int month, int day){
        this.date = LocalDate.of(year, month, day);
    }

    /**
     * 
     * @param url1 - the url for the event
     * @throws MalformedURLException
     */
    public void setUrl(String url1) throws MalformedURLException {
        url = new URL(url1);
    }

  

    

        
    
}
