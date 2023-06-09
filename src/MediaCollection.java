import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.HashMap;

/**
 * This class takes care of all the Topics and their corresponding media items
 * 
 * @author Andrew Petrany
 * @author Sean Twomey
 * 
 */
public class MediaCollection {
    // Initialize the hash map that will contain all of the media items
    HashMap<Topic, Media> mediaCollection = new HashMap<Topic, Media>();

    public MediaCollection() throws MalformedURLException, URISyntaxException {
        mediaCollection.put(Topic.Doritos, new Ad("https://www.doritos.com","DORITOS", "the second best triangle", Topic.Doritos) ); 
        mediaCollection.put(Topic.Bacon, new Image("Bacon", "Yummy Bacon", "assets//bacon.jpg", Topic.Bacon ));
        mediaCollection.put(Topic.Hamsters, new Song ("Hamsters", "hamster song","assets//HamsterDance.wav", Topic.Hamsters, "artist"));
        mediaCollection.put(Topic.Volkswagons, new Ad("https://www.google.com", "Volkswagons", "Pls buy a volkswagon :)", Topic.Volkswagons));
        mediaCollection.put(Topic.Yachts, new Image("Yachts", "Big yacht", "assets//yacht.jpg", Topic.Yachts));
        mediaCollection.put(Topic.Squirrels, new Image("Squirtle >>> charizard (I know nothing about yu- gi- oh)", "Do you have an iq higher then a squirrel?", "assets//squirrel.png", Topic.Squirrels));
        mediaCollection.put(Topic.Popcorn, new  Song("Popcorn", "Popcorn song","assets//Popcorn.wav", Topic.Popcorn, "artist"));
        mediaCollection.put(Topic.Music, new Song("Song", "Music song","assets//Music.wav", Topic.Music, "artist"));
        mediaCollection.put(Topic.Pancakes, new Video("Pancakes", "Nice pancakes yum", "assets//Pancakes.mp4", Topic.Pancakes));
        mediaCollection.put(Topic.Toothpaste, new Video("ToothPaste", "1% of doctors dont reccommend toothpaste!", "assets//Toothpaste.mp4", Topic.Toothpaste));
        mediaCollection.put(Topic.Sugar, new Song("Sugar", "sugar song","assets//Sugar.wav", Topic.Sugar, "artist"));
        mediaCollection.put(Topic.Barbies, new Image("Barbies", "Buy barbies now", "assets//barbie.jpeg", Topic.Barbies));
        mediaCollection.put(Topic.Investments, new Event(2022, 12, 4, "https://www.google.com", "Real estate investments", "Learn how to invest in real estate", Topic.Investments));
        mediaCollection.put(Topic.Superman, new Event(2023, 4, 2, "https://www.google.com", "MEET SUPERMAN", "Meet the hero who saved metropolis", Topic.Superman));
        mediaCollection.put(Topic.Hairstyles, new Image("Hair Styles", "If you're insecure about your hair, change it!", "assets//Hairstyles.jpg", Topic.Hairstyles));
        mediaCollection.put(Topic.Pizza, new Event(2023, 5, 25, "https://www.google.com", "Andrew's Pizza Party", "Come getta da pizza", Topic.Pizza));
        mediaCollection.put(Topic.Romance, new Song("Bad Romance", "Bad romance is a good song","assets//BadRomance.wav", Topic.Romance, "Lady GAGA"));
        mediaCollection.put(Topic.Travel, new Ad("https://www.google.com","Hotel Trivago", "Get hotel rooms in isreal for 5000 a night(what a steal!)", Topic.Travel));
        mediaCollection.put(Topic.Grapes, new Ad("https://www.google.com","Grapes", "They did surgery on a grape", Topic.Grapes));
    }

    /**
     * Returns the collection of media items
     * @return the collection of media items
     */
    public HashMap<Topic, Media> getMediaCollection()
    {
        return mediaCollection;
    }

    /**
     * Return an indvidual media item from the collection of media items by providing it's corresponding topic
     * @param topic the topic of the media item that is being accessed
     * @return the media item that corresponds to the provided topic
     */
    public Media getMediaItem(Topic topic)
    {
        return mediaCollection.get(topic);
    }

}
