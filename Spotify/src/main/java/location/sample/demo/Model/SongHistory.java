package location.sample.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "songhistory", schema = "spotify")
public class SongHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int timetype;
    private long timestamp;

    @ManyToOne
    @JoinColumn(name = "song_id")
    private Song song;

    @ManyToOne
    @JoinColumn(name = "location_id") // This refers to the foreign key column in SongHistory table
    private Location location;

   @ManyToOne
    @JoinColumn(name = "user_id") // This refers to the foreign key column in SongHistory table
    private User user;

    public SongHistory (){

    }

    public SongHistory(int timetype, long timestamp, Song song, Location location, User user) {
        this.timetype = timetype;
        this.timestamp = timestamp;
        this.song = song;
        this.user = user;
    }

    public int getTimetype() {
        return timetype;
    }

    public void setTimetype(int timetype) {
        this.timetype = timetype;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    

    
}

    

   