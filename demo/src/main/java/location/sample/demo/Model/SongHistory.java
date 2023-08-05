package location.sample.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class SongHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int playTime;

    private int timeOfPlay;

    @ManyToOne(fetch = FetchType.LAZY) // Many-to-One relationship with UserLocation
    @JoinColumn(name = "location_id") // This is the foreign key column in the SongHistory table
    private UserLocation userLocation;

    @ManyToOne(fetch = FetchType.LAZY) // Many-to-One relationship with Song
    @JoinColumn(name = "song_id") // This is the foreign key column in the SongHistory table
    private Song song;

    public SongHistory() {
    }

    public SongHistory(int playTime, int timeOfPlay) {
        this.playTime = playTime;
        this.timeOfPlay = timeOfPlay;
       
    }
    public int getPlayTime() {
        return playTime;
    }

    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }

    public int getTimeOfPlay() {
        return timeOfPlay;
    }

    public void setTimeOfPlay(int timeOfPlay) {
        this.timeOfPlay = timeOfPlay;
    }
     public Song getSong() {
        return null;
    }
    public void setSong(Song song) {
        this.song = song;
    }
  
    
    public UserLocation getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(UserLocation userLocation) {
        this.userLocation = userLocation;
    }

  
}

