import java.time.LocalDate;
import java.net.MalformedURLException;
import java.net.URL;

public class Event extends Media{
    private LocalDate date;
    private URL url;
    private String eventName;

    public Event(int year, int month, int day, String url1, String title, String description, Topic topic) throws MalformedURLException {
        super(title, description, topic);
        this.setDate(year, month, day);
        this.setUrl(url1);
        htmlString = "<h2>" + title + "</h2>" + "<p>" + description + "</p>";
    }

    public void setDate(int year, int month, int day){
        this.date = LocalDate.of(year, month, day);
    }

    public void setUrl(String url1) throws MalformedURLException {
        url = new URL(url1);
    }

    
    public String generateURL(){
        return url.toString();
    }

    public String getDateString(){
        return date.toString();
    }

    public String toString(){
        return "Come check out " + eventName + " on " + getDateString() + " for more info, go to our website " + generateURL();
        }

        
    
}
