package location.sample.demo.Model;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class UserLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double latitude;

    private double longitude;

    private long timeStamp;

    private String address;
    
    private String dateTime;

    @OneToMany(mappedBy = "userLocation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SongHistory> songHistoryList = new ArrayList<>();

   
    // Constructors, getters, setters, and other methods go here.

    // Helper method to manage bidirectional relationship with SongHistory
    public void addSongHistory(SongHistory songHistory) {
        songHistoryList.add(songHistory);
        songHistory.setUserLocation(this);
    }

    // public void removeSongHistory(SongHistory songHistory) {
    //     songHistoryList.remove(songHistory);
    //     songHistory.setUserLocation(null);
    // }
     public UserLocation() {

      }

    public UserLocation(double latitude, double longitude, long timeStamp,String address,String dateTime) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.timeStamp = timeStamp;
        this.dateTime = dateTime;
    
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
     public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime= dateTime;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
    public Long getId() {
        return id;
    }
}

