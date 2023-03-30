import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.HashMap;

public class MediaCollection {
    HashMap<Topic, Media> mediaCollection;

    public void addItems() throws MalformedURLException, URISyntaxException {
        mediaCollection.put(Topic.Doritos, new Ad("url1","DORITOS", "the second best triangle", Topic.Doritos) ); 
        mediaCollection.put(Topic.Bacon, new Image("Bacon", "Yummy Bacon", "assets/bacon.jog", Topic.Bacon ));
        mediaCollection.put(Topic.Hamsters, new Song ("Hamsters", "hamster song","assets/HamsterDance.wav", Topic.Hamsters, "artist"));
        mediaCollection.put(Topic.Volkswagons, new Ad("url1", "Volkswagons", "Pls buy a volkswagon :)", Topic.Volkswagons));
        mediaCollection.put(Topic.Yachts, new Image("Yachts", "Big yacht", "assets/yacht.jpg", Topic.Yachts));
        mediaCollection.put(Topic.Squirrels, new Image("Squirtle >>> charizard (I know nothing about yu- gi- oh)", "Do you have an iq higher then a squirrel?", "assets/squirrels.png", Topic.Squirrels));
        mediaCollection.put(Topic.Popcorn, new  Song("Popcorn", "Popcorn song","assets/Popcorn.wav", Topic.Popcorn, "artist"));
        mediaCollection.put(Topic.Music, new Song("Song", "Music song","assets/Music.wav", Topic.Music, "artist"));
        mediaCollection.put(Topic.Pancakes, new Video("Pancakes", "Nice pancakes yum", "assests/Pancakes.mp4", Topic.Pancakes));
        mediaCollection.put(Topic.Toothpaste, new Video("ToothPaste", "1% of doctors dont reccommend toothpaste!", "assests/Toothpaste.mp4", Topic.Toothpaste));
        mediaCollection.put(Topic.Sugar, new Song("Sugar", "sugar song","assets/Sugar.wav", Topic.Sugar, "artist"));
        mediaCollection.put(Topic.Barbies, new Image("Barbies", "Buy barbies now", "assets/barbies.ppeg", Topic.Barbies));
        mediaCollection.put(Topic.Investments, new Event(2022, 12, 4, "url1", "Real estate investments", "Learn how to invest in real estate", Topic.Investments));
        mediaCollection.put(Topic.Superman, new Event(2023, 4, 2, "url1", "MEET SUPERMAN", "Meet the hero who saved metropolis", Topic.Superman));
        mediaCollection.put(Topic.Hairstyles, new Image("Hair Styles", "If you're insecure about your hair, change it!", "assets/Hairstyles.jpg", Topic.Hairstyles));
        mediaCollection.put(Topic.Pizza, new Event(2023, 5, 25, "url1", "Andrew's Pizza Party", "Come getta da pizza", Topic.Pizza));
        mediaCollection.put(Topic.Romance, new Song("Bad Romance", "Bad romance is a good song","assets/BadRommance.wav", Topic.Romance, "Lady GAGA"));
        mediaCollection.put(Topic.Travel, new Ad("url1","Hotel Trivago", "Get hotel rooms in isreal for 5000 a night(what a steal!)", Topic.Travel));
        mediaCollection.put(Topic.Grapes, new Ad("url1","Grapes", "They did surgery on a grape", Topic.Grapes));
    }

    public HashMap<Topic, Media> getMediaCollection()
    {
        return mediaCollection;
    }

}
