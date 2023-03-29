import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class Ad extends Media{
    private URL url;

    public Ad(String url1, String title, String description, Topic mediaTopic) throws MalformedURLException, URISyntaxException {
        super(title, description, mediaTopic);
        this.setUrl(url1);
        htmlString = "<h2>" + title + "</h2>" + "<p>" + description + "</p>" + "<a href='" + url.toURI() + "'>" + url + "</a>";
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

