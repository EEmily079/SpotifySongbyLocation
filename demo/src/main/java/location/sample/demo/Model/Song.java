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
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uri;
    private String artistUri;
    private String trackUri;
    private String albumUri;

    @OneToMany(mappedBy = "song", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SongHistory> songHistoryList = new ArrayList<>();

  
    // Helper method to manage bidirectional relationship with SongHistory
    public void addSongHistory(SongHistory songHistory) {
        songHistoryList.add(songHistory);
        songHistory.setSong(this);
    }

    public void removeSongHistory(SongHistory songHistory) {
        songHistoryList.remove(songHistory);
        songHistory.setSong(null);
    }
    
    public Song() {
    }
    
    public Song(String uri, String artistUri, String trackUri, String albumUri) {
        this.uri = uri;
        this.artistUri = artistUri;
        this.trackUri = trackUri;
        this.albumUri = albumUri;
    }

    public String getUri() {
        return uri;
    }
    public void setUri(String uri) {
        this.uri = uri;
    }
    public String getArtistUri() {
        return artistUri;
    }
    public void setArtistUri(String artistUri) {
        this.artistUri = artistUri;
    }
    public String getTrackUri() {
        return trackUri;
    }
    public void setTrackUri(String trackUri) {
        this.trackUri = trackUri;
    }
    public String getAlbumUri() {
        return albumUri;
    }
    public void setAlbumUri(String albumUri) {
        this.albumUri = albumUri;
    }

   
}
