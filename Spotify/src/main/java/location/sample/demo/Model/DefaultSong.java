package location.sample.demo.Model;

import jakarta.persistence.*;

@Entity
public class DefaultSong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String uri;
    private String songName;
    private String holiday;
    
    public DefaultSong(){

    }
    
    public DefaultSong(String uri, String songName,String holiday) {
        this.uri = uri;
        this.songName = songName;
        this.holiday = holiday;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getHoliday() {
        return holiday;
    }

    public void setHoliday(String holiday) {
        this.holiday = holiday;
    }
    
}
