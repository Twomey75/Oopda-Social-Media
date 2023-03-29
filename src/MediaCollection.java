import java.net.MalformedURLException;
import java.util.HashMap;

public class MediaCollection {
    HashMap<Topic, Media> mediaCollection;

    public MediaCollection()
    {
        mediaCollection = new HashMap<Topic, Media>();
        mediaCollection.put(Topic.Bacon, new Image("bacon", "A slice", "assets\\bacon.jpg", Topic.Bacon));
        mediaCollection.put(Topic.Toothpaste, new Video("Toothpaste", "Minty Fresh", "assets\\toothpaste.mp4", Topic.Toothpaste));
        mediaCollection.put(Topic.Sugar, new Song("Sugar", "Add some sweetness to life", "assets\\sugar.wav", Topic.Sugar, "Def Leppard"));
    }

    public HashMap<Topic, Media> getMediaCollection()
    {
        return mediaCollection;
    }

}
