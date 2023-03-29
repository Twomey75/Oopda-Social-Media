import java.time.LocalDate;
import java.net.MalformedURLException;
import java.net.URL;

public class Ad extends Media{
    private URL url;
    private String adName;

    public Ad(String url1, String title, String description, Topic mediaTopic) throws MalformedURLException {
        super(title, description, mediaTopic);
        this.setUrl(url1);
        
    }

    public void setUrl(String url1) throws MalformedURLException {
        url = new URL(url1);
    }

    
    public String generateURL(){
        return url.toString();
    }

    public String toString(){
        return "Come buy " + getTitle() + ", you know you want too. " + generateURL();
        }

        
    
}

}
