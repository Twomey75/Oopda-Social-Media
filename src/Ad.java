import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
/**
 * @author Andrew Petrany
 */
public class Ad extends Media{
    private URL url;

    /**
     * 
     * @param url1 - the url
     * @param title - the title
     * @param description - the description
     * @param mediaTopic - the topic class enum
     * @throws MalformedURLException - exception for URL
     * @throws URISyntaxException - exception for URI
     */
    public Ad(String url1, String title, String description, Topic mediaTopic) throws MalformedURLException, URISyntaxException {
        super(title, description, mediaTopic);
        this.setUrl(url1);
        htmlString = "<h2>" + title + "</h2>" + "<p>" + description + "</p>" + "<a href='" + url.toURI() + "'>" + url + "</a><hr />";
    }

    /**
     * Allows the user to set the url of this ad
     * @param url1 - the url of the object
     * @throws MalformedURLException - exception for URL
     */
    public void setUrl(String url1) throws MalformedURLException {
        url = new URL(url1);
    }

        
    
}

